package com.example.cafesystem.Models;

import java.util.ArrayList;

public class Customer extends User {
    private boolean isLoyaltyMember;
    private int loyaltyPoints;

    ArrayList<Order> orders = new ArrayList<Order>();

    public boolean isLoyaltyMember() {
        return isLoyaltyMember;
    }

    public void setLoyaltyMember(boolean loyaltyMember) {
        isLoyaltyMember = loyaltyMember;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public void addOrder(Order newOrder) {
        orders.add(newOrder);
    }

    public Order getOrder(int orderID) {
        for (Order order : orders) {
            if (order.getOrderID() == orderID) {
                return order;
            }
        }
        return null;
    }
}
