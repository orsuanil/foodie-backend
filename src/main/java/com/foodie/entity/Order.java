package com.foodie.entity;

public class Order {

    private String items;
    private double total;

    public Order() {
    }

    public Order(String items, double total) {
        this.items = items;
        this.total = total;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}