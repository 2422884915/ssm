$(function(){
	baseURL =$("#baseURL").val();
	itemTableInit();
	
	getFirstCate();
	
});
function getFirstCate(){
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

function itemTableInit(){
	
	$("#jqGrid").jqGrid({ //表格初始化方法，需要指定表格的id
		url : baseURL + "/item/list",//请求的地址
		datatype: "json",//服务器返回的数据类型，默认的是xml
		mtype:"POST",//请求类型，默认为get
		postData :{},//提交的数据{name:value}
		colModel:[
		          {
		        	  label : "商品id",
		        	  name : "itemId",
		        	  key : true,
		        	  width: 50
		          },
		          {
		        	  label :"分类名字",
		        	  name:"category.categoryName",
		        	  width : 100
		          },
		          {
		        	  label :"商品名称",
		        	  name:"itemTitle",
		        	  width : 150,
		          },
		          {
		        	label : "商品图片",
		  			name : "itemImg",
		  			width : 150, 
		  			align: "center", sortable: false, editable: false, 
		  			 formatter: function(value,options,row){ //value:当前的对象  row：当前行
		  				 
		  				  return '<img  src='+value+' width="60px">';
		        	  }
		          },
		          {
		        	  label :"商品详细描述",
		        	  name:"itemDesc",
		        	  width : 150,
		          },
		          {
		        	  label :"商品价格",
		        	  name:"price",
		        	  width : 100,
		          },
		          {
		        	  label :"销量",
		        	  name:"sales",
		        	  width : 100,
		          },
		          {
		        	  label :"创建时间",
		        	  name:"createTime",
		        	  width : 100,
		          },
		          {
		        	  label :"是否删除",
		        	  name:"disabled",
		        	  width : 150,
		        	  formatter: function(value,options,row){ //value:当前的对象  row：当前行
		        		  if(value ==0){
		        			  return "未删除";
		        		  }else if(value==1){
		        			  return "删除";
		        		  }
		        	  }
		          },
		          {
		        	  label :"推荐商品",
		        	  name:"isRecommend",
		        	  width : 50,
		        	  formatter: function(value,options,row){ //value:当前的对象  row：当前行
		        		  if(value ==0){
		        			  return "不是";
		        		  }else if(value==1){
		        			  return "是";
		        		  }
		        	  }
		          },
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
	data:{
		firstCategory:[],
		secondCategory:[],
		show:true,
		item:{}//增加或更改的对象
	},
	methods:{
		getSecondCategory:function(){
			var pId =$("#myselect").val();
			
			$.ajax({
				url :baseURL+"/category/secondCategorys",//请求地址
				type:"post",
				dataType:"json",
				data:{pId:pId},
				success : function(data){
					vm.secondCategory =data.secondList.rows;//给vm名为firstCategory的设置数据
				}
			})
		},
		queryItem:function(){
			var itemTitle=$("#item_title").val();
			var categoryId=$("#secondCate").val();
			$("#jqGrid").jqGrid('setGridParam',{ // setGridParam用于设置jqGrid的options选项。返回jqGrid对象
				postData:{
					itemTitle:itemTitle,
					categoryId:categoryId
				}
			}).trigger("reloadGrid");//trigger(“reloadGrid”);为重新载入jqGrid表格。
			
		},
		addItem:function(){
			vm.show=false;
		},
		goBack:function(){
			vm.show=true;
		},
		addOrUpdateItem:function(){
			
			$.ajax({
				
				url :baseURL+"/category/addItem",//请求地址
				type:"post",
				dataType:"json",
				data:this.item,
				success : function(data){
					if(data.code==0){
						alert("添加成功",vm.queryItem());
					}else{
						alert("添加失败");
					}
				}
			
			})
		},
		uploadItemImg:function(){
			
			/*var formData = new FormData($("#addOrUpdateItemForm")[0]);*/
			var formData=new FormData();
			formData.append('itemImg',$('#itemImg')[0].files[0]);
			$.ajax({
				url: baseURL+"/item/uploadItemImg",
				type: 'POST',
				cache: false,
				data: formData,
				processData: false,
				contentType: false,
			    success : function(data){
			    	alert(data.url)
					vm.item.itemImg =data.url;
				}
			    })
		},
		deleteItemByIds:function(){
			//获得需要删除记录的id
			var ids =getSelectedRows(); //获取选择行
			//进行判断
			if(ids==null){
				return;
			}
			$.ajax({
			
				url :baseURL+"/category/deleteItemByIds",//请求地址
				type:"post",
				dataType:"json",
				data:JSON.stringify(ids),
				success : function(data){
					if(data.code==0){
						alert("删除成功",vm.queryItem());
					}else{
						alert("删除失败");
					}
				}
			
			})
		}
		
	}
})