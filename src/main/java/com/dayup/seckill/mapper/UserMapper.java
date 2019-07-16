package com.dayup.seckill.mapper;

import com.dayup.seckill.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends JpaRepository<User, String> {

    User findByUsernameAndPassword(String username, String password);

}
