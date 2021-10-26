package com.ghan.dvdmanager.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class DBHelper {
    private static Properties prop;
    private static List<Connection> conn;
    static {
        prop=new Properties();
        conn = Collections
                .synchronizedList(new ArrayList<>());
        try {
            prop.load(DBHelper.class.getClassLoader().getResourceAsStream("config.properties"));
            Class.forName(prop.getProperty("CLASS_DRIVER"));
//            创建一个线程安全的list集合

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection createconn() {
        Connection conn=null;
        try {
            conn= DriverManager.getConnection(prop.getProperty("URL"),prop.getProperty("USERNAME"),prop.getProperty("PASSWORD"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;

    }
    //获取连接
    public static synchronized Connection getConnection(){
        Connection con = null;
        //如果集合是空的，就创建新的连接
        if(conn.isEmpty()){
            con = createconn();
        }else{
            con = conn.remove(conn.size() - 1);
        }
        return con;
    }

    //关闭连接
    public static void closeConnection(Connection con){
        //如果集合连接数少于 最大数量  不用关闭它只要把它放到屋里面就行

        if(conn.size() < Integer.parseInt(prop.getProperty("MAX_SIZE"))){
            conn.add(con);
        }else{
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws SQLException {
        long begin = System.currentTimeMillis();
//        for(int i=0; i<500; i++){
//            Connection con = createconn();
//            con.close();
//        }
        for(int i=0; i<100000; i++){
            Connection con = getConnection();
            closeConnection(con);
        }
        System.out.println(System.currentTimeMillis() - begin);
    }
}
