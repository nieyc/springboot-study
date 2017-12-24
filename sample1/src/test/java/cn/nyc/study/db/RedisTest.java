package cn.nyc.study.db;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=JdbcTest.class)
public class RedisTest {
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Test
	public void test() throws Exception {
         
		
		System.out.println("stringRedisTemplate:"+stringRedisTemplate);
		// 保存字符串
		stringRedisTemplate.opsForValue().set("aaa", "111");
		System.out.println("============>"+stringRedisTemplate.opsForValue().get("aaa"));
		Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));

    }

}
