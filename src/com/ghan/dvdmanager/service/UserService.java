package com.ghan.dvdmanager.service;

import com.ghan.dvdmanager.entity.Data;
import com.ghan.dvdmanager.entity.User;

import java.util.Scanner;

public interface UserService {
    public User loginDVDService(Scanner sc);
    void UserService(Scanner sc, User u);
    Data findDvdById(String name );
    Data updservice(Scanner sc,Data d);
    Data delservice(Scanner sc,Data d);
    Data addservice(Scanner sc,Data d);

}
