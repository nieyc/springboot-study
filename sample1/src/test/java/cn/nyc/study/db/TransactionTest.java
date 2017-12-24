package cn.nyc.study.db;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import cn.nyc.study.db.transaction.StudentService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=TransactionTest.class)
@ComponentScan(value="cn.nyc.study")
public class TransactionTest {
	
	@Autowired
	StudentService studentService;
	
	@Test
	public void findByName() throws Exception {
		studentService.addMoreStudent();
	}
	

}
