package com.Java_Spring_Test.Java_Spring_Test;

public class Product {

    private int id;
    private String title;
    private int price;
    private int quantity;
    private int total;
    private float discountedPercentage;
    private int discountedPrice;

    public Product(int id, String title, int price, int quantity, int total, float discountedPercentage, int discountedPrice) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
        this.discountedPercentage = discountedPercentage;
        this.discountedPrice = discountedPrice;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", total=" + total +
                ", discountedPercentage=" + discountedPercentage +
                ", discountedPrice=" + discountedPrice +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public float getDiscountedPercentage() {
        return discountedPercentage;
    }

    public void setDiscountedPercentage(float discountedPercentage) {
        this.discountedPercentage = discountedPercentage;
    }

    public int getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(int discountedPrice) {
        this.discountedPrice = discountedPrice;
    }
}
