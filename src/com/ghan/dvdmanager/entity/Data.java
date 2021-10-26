package com.ghan.dvdmanager.entity;

import java.util.Date;
import java.util.Objects;

public class Data {
    private int id;
    private String dvd_name;
    private int status;
    private int lend_times;
    private double dvd_rent;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDvd_name() {
        return dvd_name;
    }

    public void setDvd_name(String dvd_name) {
        this.dvd_name = dvd_name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getLend_times() {
        return lend_times;
    }

    public void setLend_times(int lend_times) {
        this.lend_times = lend_times;
    }

    public double getDvd_rent() {
        return dvd_rent;
    }

    public void setDvd_rent(double dvd_rent) {
        this.dvd_rent = dvd_rent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data data = (Data)  o;
        return id == data.id && dvd_name == data.dvd_name && status == data.status && lend_times == data.lend_times && Double.compare(data.dvd_rent, dvd_rent) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dvd_name, status, lend_times, dvd_rent);
    }

    @Override
    public String toString() {
        return "data{" +
                "id=" + id +
                ", dvd_name=" + dvd_name +
                ", status=" + status +
                ", lend_times=" + lend_times +
                ", dvd_rent=" + dvd_rent +
                '}';
    }
}

