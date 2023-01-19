package com.interview.shoppingbasket;

import java.util.List;

class CheckoutContext /*mplements PricingService */{
    private Basket basket;
    private double retailPriceTotal = 0.0;
    //list that contains all promotions of a basket
    List<Promotion> prom_list;
    
    public void setRetailPriceTotal(double retailPriceTotal) {
        this.retailPriceTotal = retailPriceTotal;
    }

    CheckoutContext(Basket basket) {
        this.basket = basket;
    }

    public List<Promotion> getPromotions(){
        return prom_list;
    }

    public PaymentSummary paymentSummary() {
        return new PaymentSummary(retailPriceTotal);
    }

    public Basket getBasket() {
        return basket;
    }

    public void add_prom(List<Promotion> promotions){
        this.prom_list = promotions;
    }

}
