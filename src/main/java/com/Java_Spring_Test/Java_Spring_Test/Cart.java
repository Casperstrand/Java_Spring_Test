package com.Java_Spring_Test.Java_Spring_Test;

import java.util.ArrayList;

public class Cart {

    private int CartID;
    private ArrayList<Product> products;
    private int cartTotal;
    private int discountedTotal;
    private int userID;
    private int totalProducts;
    private int totalQuantity;

    public Cart(int id, ArrayList<Product> products, int total, int discountedTotal, int userID, int totalProducts, int totalQuantity) {
        this.CartID = id;
        this.products = products;
        this.cartTotal = total;
        this.discountedTotal = discountedTotal;
        this.userID = userID;
        this.totalProducts = totalProducts;
        this.totalQuantity = totalQuantity;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "CartID=" + CartID +
                ", products=" + products +
                ", cartTotal=" + cartTotal +
                ", discountedTotal=" + discountedTotal +
                ", userID=" + userID +
                ", totalProducts=" + totalProducts +
                ", totalQuantity=" + totalQuantity +
                '}';
    }

    public int getCartID() {
        return CartID;
    }

    public void setCartID(int cartID) {
        this.CartID = cartID;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public int getCartTotal() {
        return cartTotal;
    }

    public void setCartTotal(int cartTotal) {
        this.cartTotal = cartTotal;
    }

    public int getDiscountedTotal() {
        return discountedTotal;
    }

    public void setDiscountedTotal(int discountedTotal) {
        this.discountedTotal = discountedTotal;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getTotalProducts() {
        return totalProducts;
    }

    public void setTotalProducts(int totalProducts) {
        this.totalProducts = totalProducts;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }
}
