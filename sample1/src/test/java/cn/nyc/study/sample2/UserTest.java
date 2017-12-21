package cn.nyc.study.sample2;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import cn.nyc.study.sample2.controller.UserController;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserTest.class)
public class UserTest {

	private MockMvc mockMvc;

	@Before
	public void setMockMvc() {
		mockMvc = MockMvcBuilders.standaloneSetup(new UserController()).build();// 设置要mock的Controller类，可以是多个
	}

	@Test
	public void testUser() throws Exception {
		// 测试UserController
		RequestBuilder request = null;

		// 1、get查一下user列表，应该为空
		mockMvc.perform(MockMvcRequestBuilders.get("/users/")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("[]"));
		// 2、post 一组数据
		mockMvc.perform(MockMvcRequestBuilders.post("/users/").param("id", "1").param("name", "dd").param("age", "34"))
				.andExpect(MockMvcResultMatchers.status().isOk());

		// 3、根据id查询
		mockMvc.perform(MockMvcRequestBuilders.get("/users/1/")).andExpect(MockMvcResultMatchers.status().isOk());
		// 4 、根据id更新
		mockMvc.perform(MockMvcRequestBuilders.put("/users/1/").param("name", "zhangsan").param("age", "19"))
				.andExpect(MockMvcResultMatchers.status().isOk());

		// 5 、根据id删除
		mockMvc.perform(MockMvcRequestBuilders.delete("/users/1/")).andExpect(MockMvcResultMatchers.status().isOk());

		// 6、 重新查询一次，测试删除是否成功
		mockMvc.perform(MockMvcRequestBuilders.get("/users/")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("[]"));

	}

}
