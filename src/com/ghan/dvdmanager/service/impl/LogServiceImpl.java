package com.ghan.dvdmanager.service.impl;

import com.ghan.dvdmanager.dao.UserDao;
import util.MyUtil;

public class LogServiceImpl {
    private UserDao userDao= (UserDao) MyUtil.get("LOG_DAO");
}
