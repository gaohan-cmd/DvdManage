package com.ghan.dvdmanager.dao;

import com.ghan.dvdmanager.entity.Data;
import com.ghan.dvdmanager.entity.User;

public interface LogDao {
    boolean add(Data data, User user);
    boolean delete(Data data,User user);
    boolean upd(Data data,User user);
    boolean find(Data data,User user);
    boolean lendoutlog(Data data,User user);
    boolean lendinlog(Data data,User user);
}
