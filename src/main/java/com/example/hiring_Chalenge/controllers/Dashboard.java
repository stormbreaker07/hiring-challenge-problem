package com.example.hiring_Chalenge.controllers;


import com.example.hiring_Chalenge.models.AddBillModal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class Dashboard {

    @PostMapping("/add-bill")
    public ResponseEntity<String> addBills(@RequestBody AddBillModal addBill)  {
        System.out.println(addBill);

        return  ResponseEntity.ok().body("Bill added to the Database");

    }

}

