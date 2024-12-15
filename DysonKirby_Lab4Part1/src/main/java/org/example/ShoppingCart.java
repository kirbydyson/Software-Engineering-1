package org.example;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ShoppingCart {
    private List<Product> prods;
    public ShoppingCart(List<Product> prods) {
        this.prods = prods;
    }
    public double calculateTotal(Map<Product, Double> reduction, double salesTax) {
        double total = prods.stream().mapToDouble(product -> {
            double discount = 0;
            if(reduction.containsKey(product)) {
                discount = reduction.get(product);
            }
            return product.getPrice() - (product.getPrice() * discount/100);
        }).sum();
        return total + (total * salesTax/100);
    }
    public Set<Product> searchSaleItems(Set<Product> items){
        Set<Product> saleItems = new HashSet<>();
        for(Product prod : prods){
            if(items.contains(prod)){
                saleItems.add(prod);
            }
        }
        return saleItems;
    }
}
