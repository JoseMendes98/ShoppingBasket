package com.interview.shoppingbasket;
import java.util.List;

public class Adiccional_step_promotion implements CheckoutStep{
    //Adicional CheckoutStep mentioned in problem2
    //second CheckoutStep, after Consolidation, before RetailPrice
    private PromotionsService PromotionsService;
    private List<Promotion> prom_list;

    public Adiccional_step_promotion(PromotionsService PromotionsService) {
        this.PromotionsService = PromotionsService;
    }

    //Criation of the list that contains all Promotions in the basket inside the checkoutContext
    @Override
    public void execute(CheckoutContext checkoutContext) {
        Basket basket = checkoutContext.getBasket();
        prom_list = PromotionsService.getPromotions(basket);
        checkoutContext.add_prom(prom_list);
    }

    }
    

