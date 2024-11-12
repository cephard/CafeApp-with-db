package com.example.cafesystem.Models;

public class Order {
    private int orderID;
    private double totalPrice;
    private int totalItems;
    private String orderType;

    public Order(int orderID, String orderType){
        this.orderID =  orderID;
        this.orderType = orderType;
    }

    public int getOrderID() {
        return orderID;
    }

}
