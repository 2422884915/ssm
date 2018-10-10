//category的js
$(function(){
	baseURL =$("#baseURL").val();//获得项目路径
	tableInit();//表格初始化
	getFirstCate();//获取一级分类
	
});
//获取一级分类列表
function getFirstCate(){
	//ajax异步请求
	$.ajax({
		url :baseURL+"/category/firstCategorys",//请求地址
		type:"post",
		dataType:"json",
		data:{},
		success : function(data){
			vm.firstCategory =data.list.rows;//给vm名为firstCategory的设置数据
		}
	})
}
//通过jqgrid初始化表格的方法
function tableInit(){
	$("#jqGrid").jqGrid({ //表格初始化方法，需要指定表格的id
		url : baseURL + "/category/list",//请求的地址
		datatype: "json",//服务器返回的数据类型，默认的是xml
		mtype:"POST",//请求类型，默认为get
		postData :{},//提交的数据{name:value}
		colModel:[
		          {
		        	  label : "分类id",
		        	  name : "categoryId",
		        	  key : true,
		        	  width: 50
		          },
		          {
		        	  label :"分类名字",
		        	  name:"categoryName",
		        	  width : 100
		          },
		          {
		        	  label :"分类级别",
		        	  name:"level",
		        	  width : 100,
		        	  //对列进行格式化是设置的函数名称或类型
		        	  formatter: function(value,options,row){ //value:当前的对象  row：当前行
		        		  if(value ==1){
		        			  return "一级分类";
		        		  }else if(value==2){
		        			  return "二级分类";
		        		  }
		        	  }
		          },
		          {
		        	label : "创建时间",
		  			name : "createTime",
		  			width : 100,  
		          }
		          ],
		          viewrecords : true,//是否显示总记录数
		          height: 385,//表格的高度
		          rownumWidth :25,//设置宽度
		          rowNum :8,//设置 每页显示的记录数
		          rownumbers :true,//左侧的行号
		          multiselect :true,//左侧的复选框
		          autowidth : true,//宽度的自动调整
		          pager : "jqGridPager",//分页区的设置
		          jsonReader : {		//解析后台获取的数据
		        	  root : "page.rows",//查询的记录结果，表格显示的数据
		        	  page : "page.pageNum",//当前页码
		        	  total : "page.pages",//总页码数
		        	  records : "page.total" //总记录数
		        	  
		          }
	})
}

var vm =new Vue({
	el : "#myapp", //作用域
	data :{
		firstCategory :[] ,//一级分类列表
		show:true,
		category:{}	//增加或修改的对象
	},
	methods :{
		query : function() {
			var categoryName =$("#category_name").val();
			var pId =$("#myselect").val();
			$("#jqGrid").jqGrid('setGridParam',{ // setGridParam用于设置jqGrid的options选项。返回jqGrid对象
				postData:{
					categoryName:categoryName,
					pId:pId
				}
			}).trigger("reloadGrid");//trigger(“reloadGrid”);为重新载入jqGrid表格。
		},
		del :function(){
			//获得需要删除记录的id
			var ids =getSelectedRows(); //获取选择行
			//进行判断
			if(ids==null){
				return;
			}
			confirm("确定要删除这些选项吗？",function(){
				$.ajax({
					url:baseURL+"//category/delCategory",
					type:"post",
					dataType:"json",
					contentType:"application/json",//json字符串
					data:JSON.stringify(ids),
					success : function(data){
						if(data.code==0){
							alert("删除成功",vm.query());
						}else{
							alert("删除失败");
						}
					}
				})
			})
			
		},
		//添加按钮
		add:function(){
			this.show=false;
		},
		goBack :function(){
			this.show=true;
		},
		//添加或修改
		chgOrAdd:function(){
			if(this.category.categoryName==""||this.category.categoryName==null){
				return ;
			}
			if(this.category.categoryId==null){
				$.ajax({
					url:baseURL+"//category/addCategory",
					type:"post",
					dataType:"json",
					data:this.category,
					success : function(data){
						if(data.code==0){
							alert("删除成功",vm.query());
						}else{
							alert("删除失败");
						}
					}
				
				})
			}else{
				$.ajax({
					url:baseURL+"//category/chgCategory",
					type:"post",
					dataType:"json",
					data:this.category,
					success : function(data){
						if(data.code==0){
							alert("更新成功",vm.query());
						}else{
							alert("更新失败");
						}
					}
				
				})
			}
		
		},
		update:function(){
			var id=getSelectedRow();
			if(id==null){
				return ;
			}
			$.ajax({
				
				url:baseURL+"//category/info/"+id,
				type:"get",
				dataType:"json",
				data:{},
				success : function(data){
					if(data.code==0){
						vm.category=data.category;
						vm.show=false;
						
					}else{
						alert("请先选择");
					}
				}
			
			
			})
		}
		
		
		
	}
})