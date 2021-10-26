package com.ghan.dvdmanager.dao.impl;

import com.ghan.dvdmanager.dao.DataDao;
import com.ghan.dvdmanager.entity.Data;
import util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataDaoImpl implements DataDao {
    private static  UserDaoImpl userDao;
    Connection conn= null;
    PreparedStatement psta = null;
    ResultSet rs = null;

    @Override
    public Data findByName(String name) {
        try{
            conn = DBHelper.getConnection();
            String sql = "select *  from dvd_data where dvd_name=?";
            psta = conn.prepareStatement(sql);
            psta.setString(1,name);
            rs = psta.executeQuery();
            //单挑查询  结果是唯一的
            if(rs.next()){
                Data d=new Data();
                d.setId(rs.getInt("id"));
                d.setDvd_name(rs.getString("dvd_name"));
                d.setLend_times(rs.getInt("create_time"));
                d.setStatus(rs.getInt("status"));
                d.setDvd_rent(rs.getDouble("dvd_rent"));
                return d;
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            DBHelper.closeConnection(conn);
        }
        return null;
    }

    @Override
    public List<Data> findAll() {
        List list=new ArrayList();
        conn=DBHelper.getConnection();
        try {
            String sql = "select *  from dvd_data";
            psta = conn.prepareStatement(sql);
            rs = psta.executeQuery();
            //结果集转化成对象
            while(rs.next()){
                Data d=new Data();
                d.setId(rs.getInt("id"));
                d.setDvd_name(rs.getString("dvd_name"));
                d.setLend_times(rs.getInt("create_time"));
                d.setStatus(rs.getInt("status"));
                d.setDvd_rent(rs.getDouble("dvd_rent"));
                list.add(d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeConnection(conn);
        }
        return list;
    }

    @Override
    public boolean update(Data data) {
        conn=DBHelper.getConnection();
        int flag;
        String sql ="update dvd_user set dvd_name=? where id=?";
        try {
            psta = conn.prepareStatement(sql);
            //拼装sql
            psta.setString(1,data.getDvd_name());
            psta.setInt(2,data.getId());
            flag=psta.executeUpdate();
            if(flag>0){
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  false;

    }

    @Override
    public boolean add(Data data) {
        int flag;
        conn=DBHelper.getConnection();
        String sql ="insert into dvd_data(dvd_name,status,lend_times,dvd_rent) values(?,?,?,?)";
        try {
            psta = conn.prepareStatement(sql);
            //拼装sql
            psta.setString(1,data.getDvd_name());
            psta.setInt(2,data.getStatus());
            psta.setInt(3,data.getLend_times());
            psta.setDouble(4,data.getDvd_rent());
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
    public boolean delete(int id) {
        int flag;
        conn=DBHelper.getConnection();
        String sql ="delete from dvd_data where id=?";
        try {
            psta = conn.prepareStatement(sql);
            //拼装sql
            psta.setInt(1,id);
            flag=psta.executeUpdate();
            if(flag>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public Data findById(int id) {
        try{
            conn = DBHelper.getConnection();
            String sql = "select *  from dvd_data where dvd_name=?";
            psta = conn.prepareStatement(sql);
            psta.setInt(1,id);
            rs = psta.executeQuery();
            //单挑查询  结果是唯一的
            if(rs.next()){
                Data d=new Data();
                d.setId(rs.getInt("id"));
                d.setDvd_name(rs.getString("dvd_name"));
                d.setLend_times(rs.getInt("create_time"));
                d.setStatus(rs.getInt("status"));
                d.setDvd_rent(rs.getDouble("dvd_rent"));
                return d;
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            DBHelper.closeConnection(conn);
        }
        return null;
    }
}
