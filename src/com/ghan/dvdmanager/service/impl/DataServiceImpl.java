package com.ghan.dvdmanager.service.impl;

import com.ghan.dvdmanager.dao.UserDao;
import com.ghan.dvdmanager.dao.impl.DataDaoImpl;
import com.ghan.dvdmanager.entity.Data;
import com.ghan.dvdmanager.entity.User;
import com.ghan.dvdmanager.menu.DVDUserMenu;
import util.MyUtil;

import java.util.Scanner;


public class DataServiceImpl {
    DVDUserMenu ddm=new DVDUserMenu();
    private UserDao userDao= (UserDao) MyUtil.get("DATA_DAO");
    DataDaoImpl ddim=new DataDaoImpl();
    RecordServiceImpl rsimp=new RecordServiceImpl();

    public Data addservice(Scanner sc, Data d){
        Data data=d;

        System.out.println("请输入DVD名称：");
        String dvdName=sc.next();
        System.out.println("请输入DVD状态：");
        int status=sc.nextInt();
        System.out.println("请输入DVD租金：");
        Double dvdPrice=sc.nextDouble();
        System.out.println("请输入DVD借出次数：");
        int renttimes=sc.nextInt();
        d.setDvd_name(dvdName);
        d.setStatus(status);
        d.setDvd_rent(dvdPrice);
        d.setLend_times(renttimes);

        //现在这个对象中的月就是存款后的金额  我们只需要持久化即可  存储在数据库中
        boolean b = ddim.add(d);
        if(b){
            System.out.println("添加成功");
            return data;
        }else{
            System.out.println("添加失败！！！");
            //如果失败 返回操作前的对象
            return d;
        }

    }
    //删除
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
        boolean b = ddim.delete(d.getId());
        if(b){
            System.out.println("删除成功");
            return data;
        }else{
            System.out.println("删除失败");
            return d;
        }
    }

    //修改
    public Data updservice(Scanner sc,Data d){
        //操作对象
        Data data=d;
        System.out.println("请输入要修改的商品的id：");
        while(true){
            int Id = sc.nextInt();
            d.setId(Id);
            //取款我们要判断  金额>0
            if(Id<0){
                System.out.println("ID必须是正数,请重新输入！！！");
            }else{
                break;
            }
        }
        System.out.println("请输入要修改成的商品的名称：");
        String name=sc.next();
        d.setDvd_name(name);
        boolean b = ddim.update(d);
        if(b){
            System.out.println("修改成功");
            return data;
        }else{
            System.out.println("修改失败");
            return d;
        }
    }
    //查看
    public Data findDvdByName(String name){
        Data d = ddim.findByName(name);
        System.out.println("------当前商品信息-------");
        System.out.println("| 商品名称："+d.getDvd_name()+"  |");
        System.out.println("| 借出次数："+d.getLend_times()+" |");
        System.out.println("| DVD租金："+d.getDvd_rent()+"   |");
        System.out.println("| 状态："+d.getStatus()+"  |");
        System.out.println("--------------------------");
        return d;
    }
    //业务处理
    public void UserService(Scanner sc, User u){
        //为了防止登录对象再操作后发生改变  我们自己定义一个操作对象用于使用
        Data d=new Data();
        //开始增删改查
        while(true){
            int index = ddm.welcomeMarket(sc,u);
            if(index==1){
                //增加后，返回商品
                d = addservice(sc,d);
            }else if(index==2){
                //删除
                d = delservice(sc,d);
            }else if(index==3){
                //修改信息
                d=updservice(sc,d);
            }else if(index==4){
                //查询
                System.out.println("请输入您要查询DVD的id:");
                int dvdId=sc.nextInt();
                d.setId(dvdId);
                d = findDvdByName(d.getDvd_name());
            }else if(index==5){
               int index1= ddm.lendmenu(sc,u);
                rsimp.LendService(sc,u);
            }else{
                //退出
                return;
            }
        }
    }
}
