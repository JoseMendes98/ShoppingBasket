package com.interview.shoppingbasket;

public class Prom_21 extends Promotion {

    public Prom_21(String productCode) {
        super(productCode);
    }


    
    @Override
    public double apply_prom(int quantity, double price) {
        if(quantity>=2){
            return price*0.5;
        }
        else return price;
    }

}
