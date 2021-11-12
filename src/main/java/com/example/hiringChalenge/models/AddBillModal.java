package com.example.hiringChalenge.models;


import lombok.Getter;
import lombok.Setter;

public class AddBillModal {

    @Getter @Setter private String billNumber;
    @Getter @Setter private String billedTo;
    @Getter @Setter private String billedPrice;
    @Getter @Setter private String tax;
    @Getter @Setter private String totalPrice;
    @Getter @Setter private String date;


    public AddBillModal(String billNumber , String billedTo , String date , String billedPrice , String tax , String totalPrice) {
        this.billNumber = billNumber;
        this.billedPrice = billedPrice;
        this.billedTo =  billedTo;
        this.date = date;
        this.tax = tax;
        this.totalPrice = totalPrice;
    }


    @Override
    public String toString() {
        return "AddBillModal{" +
                "billNumber='" + billNumber + '\'' +
                ", billedTo='" + billedTo + '\'' +
                ", billedPrice='" + billedPrice + '\'' +
                ", tax='" + tax + '\'' +
                ", totalPrice='" + totalPrice + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}

