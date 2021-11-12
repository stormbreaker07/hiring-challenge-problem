package com.example.hiringChalenge.entities;


import com.example.hiringChalenge.models.AddBillModal;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "bills_data")
public class BillsDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "biil_id")
    @Getter @Setter private Long id;
    @Column(name= "bill_number")
    @Getter @Setter private String billNumber;
    @Column(name= "billed_to")
    @Getter @Setter private String billedTo;
    @Column(name= "billed_price")
    @Getter @Setter private String billedPrice;
    @Column(name= "tax")
    @Getter @Setter private String tax;
    @Column(name= "total_price")
    @Getter @Setter private String totalPrice;
    @Column(name= "due_date")
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

    public BillsDataEntity(AddBillModal billData) {
        this.billNumber = billData.getBillNumber();
        this.billedPrice = billData.getBilledPrice();
        this.billedTo = billData.getBilledTo();
        this.date = billData.getDate();
        this.tax = billData.getTax();
        this.totalPrice = billData.getTotalPrice();
    }

}

