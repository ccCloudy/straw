package cyl.straw.ap.iuser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import java.io.Serializable;

@SpringBootApplication
@MapperScan("cyl.straw.ap.iuser.mapper")
@EnableWebSecurity
@EnableScheduling
public class StrawApiUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(StrawApiUserApplication.class, args);
    }

    @Bean
    public RedisTemplate<String , Serializable>
    redisTemplate(LettuceConnectionFactory connectionFactory){
        RedisTemplate<String , Serializable> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(connectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return redisTemplate;
    }
}
