package com.interview.shoppingbasket;

public class RetailPriceCheckoutStep implements CheckoutStep {
    private PricingService pricingService;
    private double retailTotal;

    public RetailPriceCheckoutStep(PricingService pricingService) {
        this.pricingService = pricingService;
    }

    @Override
    public void execute(CheckoutContext checkoutContext) {
        Basket basket = checkoutContext.getBasket();
        retailTotal = 0.0;

        for (BasketItem basketItem: basket.getItems()) {
            int quantity = basketItem.getQuantity();
            double price = pricingService.getPrice(basketItem.getProductCode());

            for(Promotion promotion: checkoutContext.getPromotions()) {
                price = applyPromotion(promotion, basketItem, price);
            }

            basketItem.setProductRetailPrice(price);
            retailTotal += quantity*price;
        }

        checkoutContext.setRetailPriceTotal(retailTotal);
    }


    public double applyPromotion(Promotion promotion, BasketItem item, double price) {
        
        if (promotion.getProductCode().equals(item.getProductCode())) {

            return promotion.apply_prom(item.getQuantity(),price);
        }
        
        else return price;
    }
}


