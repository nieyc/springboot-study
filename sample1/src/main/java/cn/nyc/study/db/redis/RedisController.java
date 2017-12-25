package cn.nyc.study.db.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.redis.connection.ClusterInfo;
import org.springframework.data.redis.connection.RedisClusterConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisKeyValueTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.types.RedisClientInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.JedisCluster;

import java.util.List;

@Controller
@EnableAutoConfiguration
@RequestMapping("/testRedis")
public class RedisController {

    @Autowired
    private RedisConnectionFactory  redisConnectionFactory;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

   



    @RequestMapping("/test1")
    @ResponseBody
    String sayHello() {

        System.out.println("jedisCluster:"+stringRedisTemplate);
        stringRedisTemplate.opsForValue().set("aaa", "111");
        System.out.println(stringRedisTemplate.opsForValue().get("aaa"));
        System.out.println("redisConnectionFactory:"+redisConnectionFactory);
        RedisClusterConnection c=  redisConnectionFactory.getClusterConnection();
       byte[] key="bbbb".getBytes();
       byte[] value="aaaa".getBytes();
        c.set(key, value);
      
       System.out.println("============:"+new String(c.get(key)));
        
      









        return "hello";
    }
}
