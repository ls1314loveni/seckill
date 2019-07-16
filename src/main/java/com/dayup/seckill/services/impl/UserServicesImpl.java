package com.dayup.seckill.services.impl;

import com.dayup.seckill.entity.User;
import com.dayup.seckill.mapper.UserMapper;
import com.dayup.seckill.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServicesImpl implements UserServices {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User regist(User user) {
        return userMapper.saveAndFlush(user);
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return userMapper.findByUsernameAndPassword(username, password);
    }
}
