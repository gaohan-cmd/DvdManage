package com.ghan.dvdmanager.service;

import com.ghan.dvdmanager.entity.Data;
import com.ghan.dvdmanager.entity.Record;
import com.ghan.dvdmanager.entity.User;

import java.util.Scanner;

public interface RecordService {
    Data lendouts(Scanner sc, Data d, Record r);
    Data lendins(Scanner sc,Data d,Record r);
    void LendService(Scanner sc, User u);
}
