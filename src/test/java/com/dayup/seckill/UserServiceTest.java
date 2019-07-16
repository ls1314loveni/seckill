package com.dayup.seckill;

import com.dayup.seckill.entity.User;
import com.dayup.seckill.services.UserServices;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserServices userServices;

    @Test
    public void test() {
//        User user = new User("王五", "3333");
//        Assert.assertNotNull(userServices.regist(user));
//        System.out.println("haha");

        User user = userServices.findByUsernameAndPassword("张三", "2222");
        System.out.println(user.toString());

    }

}
