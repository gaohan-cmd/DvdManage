package com.ghan.dvdmanager.entity;

import java.util.Date;
import java.util.Objects;

public class Log {
    private int id;
    private int userId;
    private int dvdid;
    private Date dao_time;
    private String dao_content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getDvdid() {
        return dvdid;
    }

    public void setDvdid(int dvdid) {
        this.dvdid = dvdid;
    }

    public Date getDao_time() {
        return dao_time;
    }

    public void setDao_time(Date dao_time) {
        this.dao_time = dao_time;
    }

    public String getDao_content() {
        return dao_content;
    }

    public void setDao_content(String dao_content) {
        this.dao_content = dao_content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Log log = (Log)  o;
        return id == log.id && userId == log.userId && dvdid == log.dvdid && Objects.equals(dao_time, log.dao_time) && Objects.equals(dao_content, log.dao_content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, dvdid, dao_time, dao_content);
    }

    @Override
    public String toString() {
        return "log{" +
                "id=" + id +
                ", userId=" + userId +
                ", dvdid=" + dvdid +
                ", dao_time=" + dao_time +
                ", dao_content='" + dao_content + '\'' +
                '}';
    }
}

