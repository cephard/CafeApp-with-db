package com.example.cafesystem.Models;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderID;
    private double totalPrice;
    private int totalItems;
    private String orderType;

    private List<MenuItem> orderItems;

    public Order(int orderID, String orderType) {
        this.orderID = orderID;
        this.orderType = orderType;
        orderItems = new ArrayList<>();
    }

    public int getOrderID() {
        return orderID;
    }

    public List<MenuItem> getOrder(){
        return orderItems;
    }

    public void addItem(MenuItem item) {

    }
}
