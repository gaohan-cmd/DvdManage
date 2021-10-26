package com.ghan.dvdmanager.entity;

import java.util.Date;
import java.util.Objects;

public class User {
    private int userId;
    private String userPwd;
    private String userName;
    private Date create_time;
    private int status;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId && status == user.status && Objects.equals(userPwd, user.userPwd) && Objects.equals(userName, user.userName) && Objects.equals(create_time, user.create_time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userPwd, userName, create_time, status);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userPwd='" + userPwd + '\'' +
                ", userName='" + userName + '\'' +
                ", create_time=" + create_time +
                ", status=" + status +
                '}';
    }

    public User(int userId, String userPwd, String userName, Date create_time, int status) {
        this.userId = userId;
        this.userPwd = userPwd;
        this.userName = userName;
        this.create_time = create_time;
        this.status = status;
    }

    public User() {
    }
}
