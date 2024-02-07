package com.sweetfun.domain;

/**
 * 用户
 */

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;
public class User {
    private int userId;
    private String username;
    private String password;
    private String avatar;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private String location;
    private String sex;
    private String introduce;
    private int role;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", avatar='" + avatar + '\'' +
                ", birthday=" + birthday +
                ", location='" + location + '\'' +
                ", sex='" + sex + '\'' +
                ", introduce='" + introduce + '\'' +
                ", role=" + role +
                '}';
    }

    public User(int userId, String username, String password, String avatar, Date birthday, String location, String sex, String introduce, int role) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.avatar = avatar;
        this.birthday = birthday;
        this.location = location;
        this.sex = sex;
        this.introduce = introduce;
        this.role = role;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

}
