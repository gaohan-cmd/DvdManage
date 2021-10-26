package com.ghan.dvdmanager.service.impl;

import com.ghan.dvdmanager.dao.UserDao;
import com.ghan.dvdmanager.dao.impl.DataDaoImpl;
import com.ghan.dvdmanager.dao.impl.LogDaoImpl;
import com.ghan.dvdmanager.entity.Data;
import com.ghan.dvdmanager.entity.Record;
import com.ghan.dvdmanager.entity.User;
import com.ghan.dvdmanager.menu.DVDUserMenu;
import com.ghan.dvdmanager.service.UserService;
import util.MyUtil;

import java.util.Scanner;

public class UserServiceImpl implements UserService {

    LogDaoImpl llmp=new LogDaoImpl();
    DVDUserMenu dmeu=new DVDUserMenu();
    DataDaoImpl ddimp=new DataDaoImpl();
    RecordServiceImpl rsimp=new RecordServiceImpl();
    private UserDao userDao= (UserDao) MyUtil.get("USER_DAO");


    @Override
    public User loginDVDService(Scanner sc) {

            //得到登录时输入的值
            User u = dmeu.loginMenu(sc);
            //调用dao  查询信息
            User u1 = userDao.loginUser(u.getUserName(),u.getUserPwd());
            //查询出的对象  存在  登录成功
            return u1;

    }
    @Override
    public Data addservice(Scanner sc,Data d){
        System.out.println("请输入DVD名称：");
        String dvdName=sc.next();
        System.out.println("请输入DVD状态：");
        int dvdStatus=sc.nextInt();
        System.out.println("请输入DVD租金：");
        Double dvdPrice=sc.nextDouble();
        System.out.println("请输入DVD借出次数：");
        int dvdLendTimes=sc.nextInt();
        d.setDvd_name(dvdName);
        d.setStatus(dvdStatus);
        d.setDvd_rent(dvdPrice);
        d.setLend_times(dvdLendTimes);
        boolean b = ddimp.add(d);
        if(b){
            System.out.println("添加成功");
            return d;

        }else{
            System.out.println("添加失败！！！");

        }
        //如果失败 返回操作前的对象
        return d;
    }

    //删除
    @Override
    public Data delservice(Scanner sc,Data d){
        //操作对象
        Data data=d;
        System.out.println("请输入要删除的DVD的id：");
        while(true){
            int dvdId = sc.nextInt();
            d.setId(dvdId);
            //取款我们要判断  金额>0
            if(dvdId<0){
                System.out.println("ID必须是正数,请重新输入！！！");
            }else{
                break;
            }
        }
        boolean b = ddimp.delete(d.getId());
        if(b){
            System.out.println("删除成功");
            return data;
        }else{
            System.out.println("删除失败");
            return d;
        }
    }


    //修改
    @Override
    public Data updservice(Scanner sc,Data d){
        //操作对象
        Data data=d;
        System.out.println("请输入要修改的DVD的id：");
        while(true){
            int dvdId = sc.nextInt();
            d.setId(dvdId);
            //取款我们要判断  金额>0
            if(dvdId<0){
                System.out.println("ID必须是正数,请重新输入！！！");
            }else{
                break;
            }
        }
        System.out.println("请输入要修改成的DVD的名称：");
        String name=sc.next();
        d.setDvd_name(name);
        boolean b = ddimp.update(d);
        if(b){
            System.out.println("修改成功");
            return data;
        }else{
            System.out.println("修改失败");
            return d;
        }
    }

    //查看
    @Override
    public Data findDvdById(String name ){
        Data d = ddimp.findByName(name);
        System.out.println("------当前商品信息-------");
        System.out.println("| DVD名称："+d.getDvd_name()+"  |");
        System.out.println("| DVD状态："+d.getStatus()+" |");
        System.out.println("| 借出次数："+d.getLend_times()+"   |");
        System.out.println("| 租金："+d.getDvd_rent()+"  |");
        System.out.println("--------------------------");
        return d;
    }
    @Override
    public void UserService(Scanner sc, User u){
        //为了防止登录对象再操作后发生改变  我们自己定义一个操作对象用于使用
        Data d=new Data();
        Record r=new Record();
        //开始增删改查
        while(true){
            int index = dmeu.welcomeMarket(sc,u);
            if(index==1){
                //增加后，返回商品
                 d= addservice(sc,d);
                 d=findDvdById(d.getDvd_name() );
                llmp.add(d,u);
            }else if(index==2){
                //删除
                d = delservice(sc,d);
                d=ddimp.findById(d.getId());
                llmp.delete(d,u);
            }else if(index==3){
                //修改信息
                d=updservice(sc,d);
                llmp.upd(d,u);
            }else if(index==4){
                //查询
                System.out.println("请输入您要查询DVD的名称:");
                String name=sc.next();
                d.setDvd_name(name);
                d = findDvdById(d.getDvd_name());
                llmp.find(d,u);
            }else if(index==5){
                int index1= dmeu.lendmenu(sc,u);
                if(index1==1){
                    //借出
                    d = rsimp.lendouts(sc,d,r);
                    llmp.lendoutlog(d,u);
                }else if(index==2){
                    //还入
                    d = rsimp.lendins(sc,d,r);
                    llmp.lendinlog(d,u);
                }else{
                    //退出
                    return;
                }
            } else{
                //退出
                return;
            }
        }
    }
}
