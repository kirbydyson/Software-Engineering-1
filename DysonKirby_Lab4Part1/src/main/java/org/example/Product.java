package org.example;

import java.util.Objects;

public class Product {
    private double price;
    private int productID;
    String name;

    public Product(){
        price = 0.0;
        productID = 00000;
        name = "";
    }
    public Product(int productID, double price, String name){
        this.price = price;
        this.productID = productID;
        this.name = name;
    }
    public double getPrice(){
        return price;
    }
    public int getProductID(){
        return productID;
    }
    public String getName(){
        return name;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public void setProductID(int productID){
        this.productID = productID;
    }
    public void setName(String name){
        this.name = name;
    }
    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }
        Product product = (Product) obj;
        return productID == product.productID &&
                Double.compare(product.price, price) == 0 &&
                Objects.equals(name, product.name);

    }
    public int hashCode(){
        return Objects.hash(getPrice(), getProductID(), getName());
    }
}
