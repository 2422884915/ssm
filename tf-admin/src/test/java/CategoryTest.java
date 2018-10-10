import java.util.List;
import java.util.Map;

import javax.faces.application.Application;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hpe.tf.dto.CategoryDto;
import com.hpe.tf.entity.Category;
import com.hpe.tf.service.CategoryService;

public class CategoryTest {
	@Test
	public void test(){
		ApplicationContext app =new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		CategoryService categoryService =(CategoryService) app.getBean("categoryServiceImpl");
		CategoryDto dto =new CategoryDto();
		dto.setCategoryName("服");
		dto.setPageNum(1);
		dto.setPageSize(3);
		Map<String, Object> map =categoryService.selectByInfo(dto);
		System.err.println(map);
	}
}
