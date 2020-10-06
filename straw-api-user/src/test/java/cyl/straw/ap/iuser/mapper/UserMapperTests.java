package cyl.straw.ap.iuser.mapper;


import cyl.straw.commons.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserMapperTests {
    @Autowired
    UserMapper mapper;
    @Test
    void insert(){
        User user = new User();
        user.setUsername("陈玉灵");
        user.setPassword("0907");
        user.setPhone("18605971329");
        int num = mapper.insert(user);
        System.out.println("num:"+num);
        System.out.println(user);
    }

    @Test
    void findUserByUsername(){
        User user = mapper.findUserByUsername("林二狗");
        System.out.println(user);
    }
}
