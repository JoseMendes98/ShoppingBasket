package com.interview.shoppingbasket;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class CheckoutPipelineTest {

    CheckoutPipeline checkoutPipeline;

    @Mock
    Basket basket;

    @Mock
    CheckoutStep checkoutStep1;

    @Mock
    CheckoutStep checkoutStep2;

    @BeforeEach
    void setup() {
        checkoutPipeline = new CheckoutPipeline();
    }

    @Test
    void returnZeroPaymentForEmptyPipeline() {
        PaymentSummary paymentSummary = checkoutPipeline.checkout(basket);

        assertEquals(paymentSummary.getRetailTotal(), 0.0);
    }

    @Test
    void executeAllPassedCheckoutSteps() {
        

        Basket basket = new Basket();
        basket.add("prodCode", "productName",5);
        basket.add("prodCode", "productName",5);
        basket.add("prodCode2", "productName2",5);
        basket.add("prodCode3", "productName3",5);
        basket.add("prodCode3", "productName3",5);
        basket.add("prodCode4", "productName4",5);


        

        basket.consolidateItems();

        List<Promotion> list = new ArrayList<>();

        Promotion p1 = new Prom_21("prodCode2");
        Promotion p = new Prom_50("prodCode");
        Promotion p2 = new Prom_10("prodCode3");

        list.add(p);
        list.add(p1);
        list.add(p2);

        PromotionsService promotionService = mock(PromotionsService.class);
        PricingService pricingService = mock(PricingService.class);

        BasketConsolidationCheckoutStep consolidate = new BasketConsolidationCheckoutStep();
        Adiccional_step_promotion promotionCheckoutStep = new Adiccional_step_promotion(promotionService);
        RetailPriceCheckoutStep retailPriceCheckoutStep = new RetailPriceCheckoutStep(pricingService);

        checkoutPipeline.addStep(consolidate);
        checkoutPipeline.addStep(promotionCheckoutStep);
        checkoutPipeline.addStep(retailPriceCheckoutStep);

        when(promotionService.getPromotions(basket)).thenReturn(list);
        when(pricingService.getPrice("prodCode")).thenReturn(10.0);
        when(pricingService.getPrice("prodCode2")).thenReturn(10.0);
        when(pricingService.getPrice("prodCode3")).thenReturn(10.0);
        when(pricingService.getPrice("prodCode4")).thenReturn(10.0);


        PaymentSummary paymentSummary = checkoutPipeline.checkout(basket);

        double expectedRetailTotal = 220;
        assertEquals(paymentSummary.getRetailTotal(), expectedRetailTotal);
        
    }

}
