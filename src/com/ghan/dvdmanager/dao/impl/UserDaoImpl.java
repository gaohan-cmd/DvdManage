package com.ghan.dvdmanager.dao.impl;

import com.ghan.dvdmanager.dao.UserDao;
import com.ghan.dvdmanager.entity.User;
import util.DBHelper;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private static  UserDaoImpl userDao;
    Connection conn= null;
    PreparedStatement psta = null;
    ResultSet rs = null;
    private  UserDaoImpl(){

    }
    public  static  UserDao getInstance(){
        if(userDao==null){
            userDao=new UserDaoImpl();
        }
        return userDao;
    }

    @Override
    public User findByld(int id) {
        try{
            conn = DBHelper.getConnection();
            String sql = "select *  from dvd_user where id=?";
            psta = conn.prepareStatement(sql);
            psta.setInt(1,id);
            rs = psta.executeQuery();
            //单挑查询  结果是唯一的
            if(rs.next()){
                User u = new User();
                u.setUserId(rs.getInt("id"));
                u.setUserName(rs.getString("username"));
                u.setUserPwd(rs.getString("password"));
                u.setCreate_time(rs.getDate("create_num"));
                u.setUserId(rs.getInt("status"));
                return u;
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            DBHelper.closeConnection(conn);
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        List list=new ArrayList();
        conn=DBHelper.getConnection();
        try {
            String sql = "select *  from dvd_user";
            psta = conn.prepareStatement(sql);
            rs = psta.executeQuery();
            //结果集转化成对象
            while(rs.next()){
                User u = new User();
                u.setUserId(rs.getInt("id"));
                u.setUserName(rs.getString("username"));
                u.setUserPwd(rs.getString("password"));
                u.setCreate_time(rs.getDate("create_num"));
                u.setUserId(rs.getInt("status"));
                list.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeConnection(conn);
        }
        return list;
    }

    @Override
    public void update(User user) {
        conn=DBHelper.getConnection();
        int flag;
        String sql ="update dvd_user set username=? where id=?";
        try {
            psta = conn.prepareStatement(sql);
            //拼装sql
            psta.setString(1,user.getUserName());
            psta.setInt(2,user.getUserId());
            psta.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void save(User user) {
        conn=DBHelper.getConnection();
        String sql ="insert into dvd_user(username,password,create_time,status) values(?,?,?,?)";
        try {
            psta = conn.prepareStatement(sql);
            //拼装sql
            psta.setString(1,user.getUserName());
            psta.setString(2,user.getUserPwd());
            java.util.Date d=new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
            String time=sdf.format(d);
            psta.setString(3,time);
            psta.setInt(4,user.getStatus());
            psta.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        conn=DBHelper.getConnection();
        String sql ="delete from dvd_user where id=?";
        try {
            psta = conn.prepareStatement(sql);
            //拼装sql
            psta.setInt(1,id);
            psta.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //登录 根据账号密码验证
    @Override
    public User loginUser(String userName,String userPwd){
        try {
            conn=DBHelper.getConnection();
            String sql ="select *  from dvd_user where username=? and password=?";
            psta = conn.prepareStatement(sql);
            //拼装sql
            psta.setString(1,userName);
            psta.setString(2,userPwd);
            rs = psta.executeQuery();
            //登录  我们要求账号唯一，查出结果应该是一条数据
            if(rs.next()){
                User u = new User();
                u.setUserId(rs.getInt("id"));
                u.setUserName(rs.getString("username"));
                u.setUserPwd(rs.getString("password"));
                u.setCreate_time(rs.getDate("create_time"));
                u.setUserId(rs.getInt("status"));
                return u;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            DBHelper.closeConnection(conn);
        }
        return null;
    }
}
