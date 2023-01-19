package com.interview.shoppingbasket;

import lombok.Data;

@Data
public class BasketItem {
    private String productCode;
    private String productName;
    private int quantity;
    private double productRetailPrice;


    public String get_prodCode(){
        return productCode;
    }

    public String get_prodName(){
        return productName;
    }

    public int get_qntt(){
        return quantity;
    }

    public double get_productRetailPrice(){
        return productRetailPrice;
    }

    public void set_prodCode(String prodCode){
        this.productCode = prodCode;
    }

    public void set_prodName(String prodName){
        this.productName = prodName;
    }

    public void set_qntt(int qntt){
        this.quantity = qntt;
    }

    public void set_productRetailPrice(double productRetailPrice_1){
        this.productRetailPrice = productRetailPrice_1;
    }
}
