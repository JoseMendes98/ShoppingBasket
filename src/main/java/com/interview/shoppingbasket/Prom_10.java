package com.interview.shoppingbasket;

public class Prom_10 extends Promotion{
    
    public Prom_10(String productCode) {
        super(productCode);
      
    }

    @Override
    public double apply_prom(int quantity, double price) {
        
        return price*0.9;

    }
}

