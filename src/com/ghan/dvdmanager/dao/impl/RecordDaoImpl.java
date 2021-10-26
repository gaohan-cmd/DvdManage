package com.ghan.dvdmanager.dao.impl;

import com.ghan.dvdmanager.dao.RecordDao;
import com.ghan.dvdmanager.entity.Data;
import com.ghan.dvdmanager.entity.Record;
import util.DBHelper;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RecordDaoImpl implements RecordDao {
    private static  RecordDaoImpl recordDao;
    Connection conn= null;
    PreparedStatement psta = null;
    Statement st=null;
    ResultSet rs = null;
    private  RecordDaoImpl(){

    }
    public  static RecordDao getInstance(){
        if(recordDao==null){
            recordDao=new RecordDaoImpl();
        }
        return recordDao;
    }


    @Override
    public boolean lendout(Data data, Record record) {
        int flag;
        conn= DBHelper.getConnection();
        java.util.Date d=new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
            String time=sdf.format(d);
        String sql1 ="update dvd_data set status=0,lend_times=lend_times+1 where id="+data.getId();
        String sql2 ="insert into dvd_record(divdid,dao_time,record_time,status) values("+data.getId()+",'"+time+"','"+time+"',"+0+")";
        try {
//            psta.addBatch(sql1);
//            psta.addBatch(sql2);
//            psta = conn.prepareStatement(sql1);
//            //拼装sq
//            psta.setInt(1,data.getId());
//            flag= psta.executeUpdate();
//            java.util.Date d=new Date();
//            SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
//            String time=sdf.format(d);
//            psta.setString(2,time);
//            psta.setString(3,time);
//            flag= psta.executeUpdate();
            st=conn.createStatement();
            conn.setAutoCommit(false);
            st.addBatch(sql1);
            st.addBatch(sql2);
            st.executeBatch();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean lendin(Data data, Record record) {
        int flag;
        conn= DBHelper.getConnection();
        java.util.Date d=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
        String time=sdf.format(d);
        String sql1 ="update dvd_data set status=0,lend_times=lend_times+1 where id="+data.getId();
        String sql2 ="insert into dvd_record(dao_time,record_time,status) values("+data.getId()+",'"+time+"','"+time+"',"+1+")";
        try {
        st=conn.createStatement();
        conn.setAutoCommit(false);
        st.addBatch(sql1);
        st.addBatch(sql2);
        st.executeBatch();
        conn.commit();
    } catch (SQLException e) {
        e.printStackTrace();
    }
        return true;
    }


}
