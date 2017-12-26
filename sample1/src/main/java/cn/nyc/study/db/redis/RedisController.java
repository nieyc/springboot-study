package cn.nyc.study.db.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.redis.connection.RedisClusterConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 30.1.1 Connecting to Redis

 You can inject an auto-configured RedisConnectionFactory, StringRedisTemplate,
 or vanilla RedisTemplate instance as you would any other Spring Bean. By default,
 the instance tries to connect to a Redis server at localhost:6379.
 The following listing shows an example of such a bean:
 *
 *
 */


@Controller
@EnableAutoConfiguration
@RequestMapping("/testRedis")
public class RedisController {

    @Autowired
    private RedisConnectionFactory  redisConnectionFactory;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;


    @RequestMapping("/test1")
    @ResponseBody
    String sayHello() {
        stringRedisTemplate.opsForValue().set("aaa", "111");
        System.out.println(stringRedisTemplate.opsForValue().get("aaa"));
        RedisClusterConnection redOpt=  redisConnectionFactory.getClusterConnection();
        byte[] key="bbbb".getBytes();
        byte[] value="aaaa".getBytes();
        redOpt.set(key, value);
        System.out.println("============:"+new String(redOpt.get(key)));
        redisTemplate.opsForValue().set("name", "liyiwen");
        System.out.println(""+redisTemplate.opsForValue().get("name"));
        return "hello";
    }
}
