package com.example.hiring_Chalenge.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bills-data")
public class BillsDataEntity {

    @Id
    @Column(name = "biil-id")
    @Getter @Setter private Long id;
    @Column(name= "bill-number")
    @Getter @Setter private String billNumber;
    @Column(name= "billed-to")
    @Getter @Setter private String billedTo;
    @Column(name= "billed-price")
    @Getter @Setter private String billedPrice;
    @Column(name= "tax")
    @Getter @Setter private String tax;
    @Column(name= "total-price")
    @Getter @Setter private String totalPrice;
    @Column(name= "due-date")
    @Getter @Setter private String date;

    public BillsDataEntity() {
    }

    public BillsDataEntity(String billNumber , String billedTo , String date , String billedPrice , String tax , String totalPrice) {
        this.billNumber = billNumber;
        this.billedPrice = billedPrice;
        this.billedTo =  billedTo;
        this.date = date;
        this.tax = tax;
        this.totalPrice = totalPrice;
    }

}

