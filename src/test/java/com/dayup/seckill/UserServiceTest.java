package com.dayup.seckill;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dayup.seckill.dao.UserMapper;
import com.dayup.seckill.entity.User;
import com.dayup.seckill.redis.UserReids;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserReids userReids;

    @Test
    public void test() {
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.isNotNull("repassword");

        Page<User> page = new Page<User>(1,3);
//
//        IPage<User> iPage = userMapper.selectPage(page, null);
//        System.out.println("总页数：" + iPage.getPages());
//        System.out.println("总记录数：" + iPage.getTotal());
//        List<User> records = iPage.getRecords();
//        records.forEach(System.out::println);

//        IPage<Map<String, Object>> iPage1 = userMapper.selectMapsPage(page, null);
//        System.out.println("总页数：" + iPage1.getPages());
//        System.out.println("总记录数：" + iPage1.getTotal());
//        List<Map<String, Object>> records = iPage1.getRecords();
//        records.forEach(System.out::println);

        IPage<User> iPage2 = userMapper.selectUserPage(page, queryWrapper);
        System.out.println("总页数：" + iPage2.getPages());
        System.out.println("总记录数：" + iPage2.getTotal());
        List<User> records = iPage2.getRecords();
        records.forEach(System.out::println);

    }

    @Test
    public void Test1() {
//        User user = new User();
//        user.setId(1);
//        user.setUsername("zhangsan");

        UpdateWrapper<User> wrapper = new UpdateWrapper<User>();
        wrapper.eq("id", 1).set("password", "1qaz");
        int i = userMapper.update(null, wrapper);
        System.out.println("影响记录数：" + i);
    }

    @Test
    public void Test2() {
        UpdateWrapper<User> wrapper = new UpdateWrapper<User>();

        LambdaUpdateWrapper<User> wrapper1 = new LambdaUpdateWrapper<>();
        wrapper1.eq(User::getId, "1").set(User::getRepassword, "1qaz");
        int i = userMapper.update(null, wrapper1);
        System.out.println("影响记录数：" + i);
    }

    @Test
    public void Test3() {
        User user = new User();
//        user.setId(7);
//        user.setUsername("好啊好啊");
//        user.setPassword("12324");
//        boolean insert = user.insert();

        user.setId(0);
        User user1 = user.selectById();
        System.out.println(user1);
    }


//    @Test
//    public void testPutRedis() {
//        User user = new User("12", "1234");
//        userReids.put(user.getUsername(), user, -1);
//    }

}
