package com.dayup.seckill.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class User extends Model<User> implements Serializable {

    private static final long serialVersionUID = 8933688962515794981L;

    private Integer id;

    private String username;

    private String password;

    private String repassword;


}
