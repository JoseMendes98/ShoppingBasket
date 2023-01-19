package com.interview.shoppingbasket;

public abstract class Promotion {
    //implementation of class Promotion
    //criation of 3 extended classes that implement different Promotions betwen each other
    private String productCode;
    public abstract double apply_prom(int quantity, double price);

    public Promotion(String productCode) {
        this.productCode = productCode;
    }

    public String getProductCode() {
        return productCode;
    }

}

