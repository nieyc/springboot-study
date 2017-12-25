package cn.nyc.study.db.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

@Configuration
public class AppConfig {

    @Autowired
    RedisClusterConfig clusterProperties;

    @Bean
    public RedisConnectionFactory connectionFactory() {
        System.out.println("0000000000000000000");
        return new JedisConnectionFactory(new RedisClusterConfiguration(clusterProperties.getNodes()));
    }


}
