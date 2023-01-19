package com.interview.shoppingbasket;

public class Prom_50 extends Promotion{
    public Prom_50(String productCode) {
        super(productCode);
    }

    @Override
    public double apply_prom(int quantity, double price) {
        return price*0.5;
    }

}

