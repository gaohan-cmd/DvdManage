package com.ghan.dvdmanager.service.impl;

import com.ghan.dvdmanager.dao.RecordDao;
import com.ghan.dvdmanager.dao.UserDao;
import com.ghan.dvdmanager.dao.impl.DataDaoImpl;
import com.ghan.dvdmanager.entity.Data;
import com.ghan.dvdmanager.entity.Record;
import com.ghan.dvdmanager.entity.User;
import com.ghan.dvdmanager.menu.DVDUserMenu;
import com.ghan.dvdmanager.service.RecordService;
import util.MyUtil;

import java.util.Scanner;

public class RecordServiceImpl implements RecordService {
    DVDUserMenu ddm=new DVDUserMenu();
    private RecordDao recordDao= (RecordDao) MyUtil.get("RECORD_DAO");
    DataDaoImpl ddim=new DataDaoImpl();

    @Override
    public Data lendouts(Scanner sc, Data d, Record r) {
        //操作对象
        Data data=d;
        System.out.println("请输入要借出的DVD的id：");
        while(true){
            int dvdId = sc.nextInt();
            d.setId(dvdId);
            System.out.println(d.getId());
            //取出我们要判断id
            if(dvdId<0){
                System.out.println("ID必须是正数,请重新输入！！！");
            }else{
                break;
            }
        }
        boolean b = recordDao.lendout(d,r);
        if(b){
            System.out.println("借出成功");
            return data;
        }else{
            System.out.println("借出失败");
            return d;
        }
    }

    @Override
    public Data lendins(Scanner sc,Data d,Record r) {
        //操作对象
        Data data=d;
        System.out.println("请输入要退还的DVD的id：");
        while(true){
            int dvdId = sc.nextInt();
            d.setId(dvdId);
            //取出我们要判断id
            if(dvdId<0){
                System.out.println("ID必须是正数,请重新输入！！！");
            }else{
                break;
            }
        }
        boolean b = recordDao.lendin(d,r);
        if(b){
            System.out.println("退还成功");
            return data;
        }else{
            System.out.println("退还失败");
            return d;
        }

    }

    @Override
    //业务处理
    public void LendService(Scanner sc,User u){
        //为了防止登录对象再操作后发生改变  我们自己定义一个操作对象用于使用
        Data d=new Data();
        Record r=new Record();
        //开始增删改查
        while(true){
            int index = ddm.lendmenu(sc,u);
            if(index==1){
                //增加后，返回商品
                d = lendouts(sc,d,r);
            }else if(index==2){
                //删除
                d = lendins(sc,d,r);
            }else{
                //退出
                return;
            }
        }
    }
}
