package com.dayup.seckill.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dayup.seckill.dao.UserMapper;
import com.dayup.seckill.entity.User;
import com.dayup.seckill.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserServicesImpl implements UserServices {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int regist(User user) {
        return userMapper.insert(user);
    }

    @Override
    public User findUser(User user) {
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("username", user.getUsername());
        qw.eq("password", user.getPassword());
        user = userMapper.selectOne(qw);
        return user;
    }

}
