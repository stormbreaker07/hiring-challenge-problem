package com.example.hiringChalenge.services;


import com.example.hiringChalenge.entities.BillsDataEntity;
import com.example.hiringChalenge.models.AddBillModal;
import com.example.hiringChalenge.repositories.BillsData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddBill {

    @Autowired
    private BillsData billsDataRepository;


    public boolean addBillInDatabase(AddBillModal BillInfo) {

        try {
            System.out.println("its inside this");
            BillsDataEntity billsData = new BillsDataEntity(BillInfo);
            billsDataRepository.save(billsData);
            return true;
        }
        catch(Exception e) {
            return false;
        }

    }


}
