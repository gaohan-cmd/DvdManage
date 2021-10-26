package com.ghan.dvdmanager.entity;

import java.util.Date;
import java.util.Objects;

public class Record {
    private int id;
    private int dvdid;
    private Date dao_time;
    private int status;
    private Date record_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getRecord_time() {
        return record_time;
    }

    public void setRecord_time(Date record_time) {
        this.record_time = record_time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return id == record.id && dvdid == record.dvdid && status == record.status && Objects.equals(dao_time, record.dao_time) && Objects.equals(record_time, record.record_time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dvdid, dao_time, status, record_time);
    }

    @Override
    public String toString() {
        return "record{" +
                "id=" + id +
                ", dvdid=" + dvdid +
                ", dao_time=" + dao_time +
                ", status=" + status +
                ", record_time=" + record_time +
                '}';
    }
}

