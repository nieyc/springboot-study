package cn.nyc.study.sample1;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import cn.nyc.study.sample1.controller.HelloController;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=HelloWordTest.class)
public class HelloWordTest {
	
	
	private MockMvc mockMvc;

	@Before
	public void setMockMvc() {
		mockMvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();// 设置要mock的Controller类，可以是多个
	}

	@Test
	public void getHello() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/hello")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("hello,spring-boot")); // 测试接口返回内容
	}
}
