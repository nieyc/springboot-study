package cn.nyc.study.db;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;


import cn.nyc.study.db.jdbc.UserService;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=JdbcTest.class)
@ComponentScan(value="cn.nyc.study")
public class JdbcTest {
	
	@Autowired
	private UserService userSerivce;
	


	@Before
	public void setUp() {
		// 准备，清空user表
		userSerivce.deleteAllUsers();
	}
	
	@Test
	public void test() throws Exception {
		// 插入5个用户
		userSerivce.create("a", 1);
		userSerivce.create("b", 2);
		userSerivce.create("c", 3);
		userSerivce.create("d", 4);
		userSerivce.create("e", 5);

		// 查数据库，应该有5个用户
		Assert.assertEquals(5, userSerivce.getAllUsers().intValue());

		// 删除两个用户
		userSerivce.deleteByName("a");
		userSerivce.deleteByName("e");

		// 查数据库，应该有3个用户
		Assert.assertEquals(3, userSerivce.getAllUsers().intValue());

	}
	


}
