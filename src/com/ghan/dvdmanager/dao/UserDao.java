package com.ghan.dvdmanager.dao;

import com.ghan.dvdmanager.entity.User;

import java.util.List;

public interface UserDao {
    User findByld(int id);
    List<User> findAll();
    void update(User user);
    void save(User user);
    void delete(int id);
    User loginUser(String userName,String userPwd);

}
