package com.ghan.dvdmanager.dao.impl;

import com.ghan.dvdmanager.dao.LogDao;
import com.ghan.dvdmanager.entity.Data;
import com.ghan.dvdmanager.entity.User;
import util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogDaoImpl implements LogDao {
    Connection conn= null;
    PreparedStatement psta = null;
    ResultSet rs = null;
    @Override
    public boolean add(Data data, User u) {
        int flag;
        conn= DBHelper.getConnection();
        String sql ="insert into dvd_log(userId,dvdid,dao_time,dao_content) values(?,?,?,?)";
        try {
            psta = conn.prepareStatement(sql);
            //拼装sql
            psta.setInt(1,u.getUserId());
            psta.setInt(2,data.getId());
            java.util.Date d=new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
            String time=sdf.format(d);
            psta.setString(3,time);
            psta.setString(4,u.getUserName()+"添加了"+data.getDvd_name());
            flag= psta.executeUpdate();
            if(flag>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(Data data,User u) {
        int flag;
        conn= DBHelper.getConnection();
        String sql ="insert into dvd_log(userId,dvdid,dao_time,dao_content) values(?,?,?,?)";
        try {
            psta = conn.prepareStatement(sql);
            //拼装sql
            psta.setInt(1,data.getId());
            psta.setInt(2,u.getUserId());
            java.util.Date d=new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
            String time=sdf.format(d);
            psta.setString(3,time);
            psta.setString(4,u.getUserName()+"删除了"+data.getDvd_name());
            flag= psta.executeUpdate();
            if(flag>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean upd(Data data,User u) {
        int flag;
        conn= DBHelper.getConnection();
        String sql ="insert into dvd_log(userId,dvdid,dao_time,dao_content) values(?,?,?,?)";
        try {
            psta = conn.prepareStatement(sql);
            //拼装sql
            psta.setInt(1,data.getId());
            psta.setInt(2,u.getUserId());
            java.util.Date d=new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
            String time=sdf.format(d);
            psta.setString(3,time);
            psta.setString(4,u.getUserName()+"更新了"+data.getDvd_name());
            flag= psta.executeUpdate();
            if(flag>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean find(Data data, User u) {
        int flag;
        conn= DBHelper.getConnection();
        String sql ="insert into dvd_log(userId,dvdid,dao_time,dao_content) values(?,?,?,?)";
        try {
            psta = conn.prepareStatement(sql);
            //拼装sql
            psta.setInt(1,data.getId());
            psta.setInt(2,u.getUserId());
            java.util.Date d=new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
            String time=sdf.format(d);
            psta.setString(3,time);
            psta.setString(4,u.getUserName()+"查询了"+data.getDvd_name());
            flag= psta.executeUpdate();
            if(flag>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean lendoutlog(Data data,User u) {
        int flag;
        conn= DBHelper.getConnection();
        String sql ="insert into dvd_log(userId,dvdid,dao_time,dao_content) values(?,?,?,?)";
        try {
            psta = conn.prepareStatement(sql);
            //拼装sql
            psta.setInt(1,data.getId());
            psta.setInt(2,u.getUserId());
            java.util.Date d=new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
            String time=sdf.format(d);
            psta.setString(3,time);
            psta.setString(4,u.getUserName()+"进行借出操作");
            flag= psta.executeUpdate();
            if(flag>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean lendinlog(Data data,User u) {
        int flag;
        conn= DBHelper.getConnection();
        String sql ="insert into dvd_log(userId,dvdid,dao_time,dao_content) values(?,?,?,?)";
        try {
            psta = conn.prepareStatement(sql);
            //拼装sql
            psta.setInt(1,data.getId());
            psta.setInt(2,u.getUserId());
            java.util.Date d=new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
            String time=sdf.format(d);
            psta.setString(3,time);
            psta.setString(4,u.getUserName()+"进行退还操作");
            flag= psta.executeUpdate();
            if(flag>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
