package com.example.hiringChalenge.services;


import com.example.hiringChalenge.entities.BillsDataEntity;
import com.example.hiringChalenge.repositories.BillsData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@Service
public class BillInfoRetrievalService {

    @Autowired
    private BillsData billsDataRepository;

    public List<BillsDataEntity> getAllBillsInfo() throws Exception {
        try {
            return billsDataRepository.findAll();
        }
        catch(Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<BillsDataEntity> getBillsById(String id) throws Exception{
        try {
            return billsDataRepository.findAllById(Collections.singleton(Long.parseLong(id)));
        }
        catch(Exception e) {
            e.getStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    public List<BillsDataEntity> getBillByDueDate(String date) throws Exception {
        try {
            return billsDataRepository.findAllByDate(date);
        }
        catch(Exception e) {
            throw new Exception("data not present ! some error happen !");
        }
    }

}
