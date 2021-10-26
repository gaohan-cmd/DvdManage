package com.ghan.dvdmanager.test;


import com.ghan.dvdmanager.dao.UserDao;
import com.ghan.dvdmanager.entity.User;
import com.ghan.dvdmanager.menu.DVDUserMenu;
import com.ghan.dvdmanager.service.UserService;
import com.ghan.dvdmanager.service.impl.UserServiceImpl;
import com.ghan.dvdmanager.util.MyUtil;

import java.util.Scanner;

public class DVDManageTest {
    public static void main(String[] args) {
       UserDao userDao= (UserDao) MyUtil.get("USER_DAO");
//        UserService uimp= (UserService) util.MyUtil.get("USER_SERVICE");
        DVDUserMenu dm=new DVDUserMenu();
        UserServiceImpl uimp=new UserServiceImpl();
        Scanner sc=new Scanner(System.in);
        while(true){
            int index =  dm.regAndLoginMenu(sc);
           if(index==1){
                //登录  登录成功时，我们得到了一个对象
                User u=uimp.loginDVDService(sc);
                if(u!=null){
                    //整个登录成功后的操作 都在这service方法中
                    uimp.UserService(sc,u);
                }else{
                    System.out.println("登录失败");
                }
            }else{
                //退出
                break;
            }
        }
    }
}
