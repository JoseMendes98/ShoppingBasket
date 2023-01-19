package com.interview.shoppingbasket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Basket {
    private List<BasketItem> items = new ArrayList<>();

    public void add(String productCode, String productName, int quantity) {
        BasketItem basketItem = new BasketItem();
        basketItem.setProductCode(productCode);
        basketItem.setProductName(productName);
        basketItem.setQuantity(quantity);

        items.add(basketItem);
    }

    public List<BasketItem> getItems() {
        return items;
    }
    //implementation of consolidateItems(), uses a map that cointais the (productCode(key),BasketItem(value))
    //Iterates through list of BasketItems and add to the Map
    public void consolidateItems() {
        Map<String, BasketItem> itemsMap = new HashMap<>();
        for (BasketItem item : items) {
            String productCode = item.getProductCode();
            if (itemsMap.containsKey(productCode)) {
                BasketItem existingItem = itemsMap.get(productCode);
                existingItem.setQuantity(existingItem.getQuantity() + item.getQuantity());
            } else {
                itemsMap.put(productCode, item);
            }
        }
        items.clear();
        items.addAll(itemsMap.values());
    }
}
