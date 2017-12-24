package cn.nyc.study.db;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import cn.nyc.study.db.mybatis.Student;
import cn.nyc.study.db.mybatis.StudentMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=JdbcTest.class)
@ComponentScan(value="cn.nyc.study")
public class IbatisTest {
	
	@Autowired
	private StudentMapper studentMapper;

	@Test
	@Rollback
	public void findByName() throws Exception {
		studentMapper.insert("AAA", 20);
		Student u = studentMapper.findByName("AAA");
		System.out.println("name:"+u.getName());
		//Assert.assertEquals(20, u.getAge().intValue());
		u.setAge(18);
		studentMapper.update(u);
		System.out.println(u.getAge());
		studentMapper.delete(u.getId());
	}

}
