package com.example.hiringChalenge.controllers;


import com.example.hiringChalenge.entities.BillsDataEntity;
import com.example.hiringChalenge.models.AddBillModal;
import com.example.hiringChalenge.services.AddBill;
import com.example.hiringChalenge.services.BillInfoRetrievalService;
import javassist.tools.web.BadHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.http.HTTPException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
public class Dashboard {

    @Autowired
    private AddBill addBillService;
    @Autowired
    private BillInfoRetrievalService billInfoRetrievalService;


    @PostMapping("/add-bill")
    public ResponseEntity<String> addBills(@RequestBody AddBillModal addBill)  {

        try {
            System.out.println(addBill);
            if(addBillService.addBillInDatabase(addBill)) {
                return ResponseEntity.ok().body("Bill added to the Database");
            }
            else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("cant able to store bill info in database");
            }
        }catch(Exception e)  {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Operation Failed Due to error = " + e.getMessage());
        }

    }

    @GetMapping("/")
    public ResponseEntity<List<BillsDataEntity>> getAllBills() {
            try {
                return ResponseEntity.ok().body(billInfoRetrievalService.getAllBillsInfo());
            }
            catch(Exception e) {
                List<BillsDataEntity> list = new ArrayList<>();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(list);
            }
    }

    @GetMapping("/{id}")
    public ResponseEntity<BillsDataEntity> getBiilById(@PathVariable String id) throws BadHttpRequest {

        try {
                List<BillsDataEntity> billsInfoList = billInfoRetrievalService.getBillsById(id);
                if(!billsInfoList.isEmpty()) {
                    return ResponseEntity.ok().body(billsInfoList.get(0));
                }
                else {
                    throw new Exception("bill data with id = " + id + " is not present in the database.");
                }
            }
            catch(Exception e) {
                throw new BadHttpRequest();
            }
    }

    @GetMapping("/due/{date}")
    public ResponseEntity<List<BillsDataEntity>> getBillByDueDate(@PathVariable String date) throws HTTPException {
        try {
            List<BillsDataEntity> billsInfo = billInfoRetrievalService.getBillByDueDate(date);
            if(!billsInfo.isEmpty()) {
                return ResponseEntity.ok().body(billsInfo);
            }
            throw new Exception("data list is empty");
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ArrayList<BillsDataEntity>());
        }

    }

}

