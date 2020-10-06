package cyl.straw.ap.iuser;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.DigestUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class StrawApiUserApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    DataSource dataSource;
    @Test
    void getConnection() throws SQLException {
        System.out.println(dataSource);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

    @Test
    void bcryptEncode(){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String rawPassword = "1234";
        String encodePassword = passwordEncoder.encode(rawPassword);
        System.err.println("encodePassword="+encodePassword);
        //$2a$10$yWO2nQ40YWTg37XIl99M5.bTgK4thHGi7Cv/h1veeCD8otPfvsi1y
    }

    @Test
    void bcryptMatches(){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String rawPassword = "1234";
        String encodePassword = "$2a$10$yWO2nQ40YWTg37XIl99M5.bTgK4thHGi7Cv/h1veeCD8otPfvsi1y";
        boolean result = passwordEncoder.matches(rawPassword,encodePassword);
        System.err.println("rawPassword:"+rawPassword);
        System.err.println("encodePassword:"+encodePassword);
        System.out.println(result);
    }

    @Test
    void md5(){
        String rawPassword = "123456";
        String encodePassword = DigestUtils.md5DigestAsHex(rawPassword.getBytes());
        System.out.println("encodePassword:"+encodePassword);
        //e10adc3949ba59abbe56e057f20f883e

    }
}
