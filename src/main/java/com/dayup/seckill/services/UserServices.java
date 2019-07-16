package com.dayup.seckill.services;

import com.dayup.seckill.entity.User;

public interface UserServices {

    // 注册
    User regist(User user);

    // 查找用户
    User findByUsernameAndPassword(String username, String password);

}
