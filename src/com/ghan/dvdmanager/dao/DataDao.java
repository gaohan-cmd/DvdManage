package com.ghan.dvdmanager.dao;

import com.ghan.dvdmanager.entity.Data;

import java.util.List;

public interface DataDao {
    Data findByName(String name);
    List<Data> findAll();
    boolean update(Data data);
    boolean add(Data data);
    boolean delete(int id);
    Data findById(int id);
}
