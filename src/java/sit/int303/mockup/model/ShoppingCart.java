/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sit.int303.mockup.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author INT303
 */
public class ShoppingCart implements Serializable {

    private Map<String, LineItem> cart;

    public ShoppingCart() {
        cart = new HashMap();
    }

    public void add(Product p) {
        LineItem line = cart.get(p.getProductCode());
        if (line == null) {
            cart.put(p.getProductCode(), new LineItem(p));
        } else {
            line.setQuantity(line.getQuantity() + 1);
        }
    }

    public void remove(Product p) {
        this.remove(p.getProductCode());
    }

    public void remove(String productCode) {
        cart.remove(productCode);
    }

    public double getTotalPrice() {
        double sum = 0;
        Collection<LineItem> lineItems = cart.values();
        for (LineItem lineItemT : lineItems) {
            sum += lineItemT.getTotalPrice();
        }
        return sum;
    }

    public int getTotalQuantity() {
        int sum = 0;
        Collection<LineItem> lineItem = cart.values();
        for (LineItem lineItemQ : lineItem) {
            sum += lineItemQ.getQuantity();
        }
        return sum;
    }

    public List<LineItem> getLineItem() {
        return new ArrayList(cart.values());

    }
}
