package cn.nyc.study.db;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import cn.nyc.study.db.transaction.GoodStudentServiceImpl;
import cn.nyc.study.db.transaction.StudentService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=TransactionTest.class)
@ComponentScan(value="cn.nyc.study")
public class TransactionTest {
	
	//@Autowired
	//StudentService studentService;
	
	@Resource(name="goodStudentService") 
	StudentService goodStudentService;
	
	
	@Resource(name="studentService") 
	StudentService studentService;
	
	
	@Test
	public void findByName() throws Exception {
		//正常执行
		goodStudentService.addMoreStudent();

		//测试事物的情况
		//studentService.addMoreStudent();
	}
	

}
