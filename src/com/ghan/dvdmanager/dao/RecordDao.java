package com.ghan.dvdmanager.dao;

import com.ghan.dvdmanager.entity.Data;
import com.ghan.dvdmanager.entity.Record;

public interface RecordDao {
    boolean lendout(Data data,Record record);
    boolean lendin(Data data, Record record);
}
