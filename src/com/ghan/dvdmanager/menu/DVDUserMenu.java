package com.ghan.dvdmanager.menu;


import com.ghan.dvdmanager.entity.User;

import java.util.Scanner;

public class DVDUserMenu {
    //登录注册欢迎界面
    public int  regAndLoginMenu(Scanner sc){
        System.out.println("--------------------");
        System.out.println("|    1,登录         |");
        System.out.println("|    2,退出         |");
        System.out.println("--------------------");
        System.out.println("请输入操作序号：");
        int index = sc.nextInt();
        return index;
    }

    //登录的界面
    public User loginMenu(Scanner sc){
        User loginu = new User();
        System.out.println("请输入用户名：");
        String  code = sc.next();
        System.out.println("请输入密码：");
        String  pwd = sc.next();
        loginu.setUserName(code);
        loginu.setUserPwd(pwd);
        return loginu;
    }

    //登录成功界面
    public int  welcomeMarket(Scanner sc,User u){
        System.out.println("--------------------");
        System.out.println("---欢迎"+u.getUserName()+"使用DVD管理系统------");
        System.out.println("|    1,增加         |");
        System.out.println("|    2,删除         |");
        System.out.println("|    3,修改         |");
        System.out.println("|    4,查看信息      |");
        System.out.println("|    5,租借管理      |");
        System.out.println("|    6,退出         |");
        System.out.println("--------------------");
        System.out.println("请输入操作序号：");
        int index = sc.nextInt();
        return index;
    }

    //租借功能界面
    public int  lendmenu(Scanner sc,User u){
        System.out.println("--------------------");
        System.out.println("---欢迎"+u.getUserName()+"使用DVD管理系统------");
        System.out.println("|    1,借出         |");
        System.out.println("|    2,还入         |");
        System.out.println("|    3,退出         |");
        System.out.println("--------------------");
        System.out.println("请输入操作序号：");
        int index = sc.nextInt();
        return index;
    }
}
