package com.dayup.seckill.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

    @Column(name="id")
    private Integer id;

    @Id
    @Column(name="username", nullable = false)
//    @NotBlank(message = "用户名不能为空")
    private String username;

    @Column(name="password", nullable = false)
//    @Size(min=4, max=6, message = "密码长度在4~6之间")
    private String password;

    @Column(name="repassword", nullable = false)
//    @Size(min=4, max=6, message = "密码长度在4~6之间")
    private String repassword;

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
