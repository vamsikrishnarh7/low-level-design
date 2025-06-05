package com.vamsi.models;

import com.vamsi.strategies.PaymentStrategy;

import java.util.List;

public abstract class Order {
    private int orderId;
    private static int nextOrderId = 0;
    private User user;
    private Restaurant restaurant;
    private List<MenuItem> items;
    private PaymentStrategy paymentStrategy;
    private double total;
    private String scheduled;

    public Order(){
        user = null;
        restaurant = null;
        paymentStrategy = null;
        total = 0.0;
        scheduled = "";
        orderId = ++nextOrderId;
    }

    public boolean processPayment(){
        if(paymentStrategy != null){
            paymentStrategy.pay(total);
            return true;
        }
        else{
            System.out.println("\n\nPlease choose a payment method first");
            return false;
        }
    }
    public abstract String getType();

    public int getOrderId(){
        return orderId;
    }

    public void setUser(User u){
        user = u;
    }
    public User getUser(){
        return user;
    }
    public void setRestaurant(Restaurant r){
        restaurant = r;
    }
    public Restaurant getRestaurant(){
        return restaurant;
    }
    public void setItems(List<MenuItem> i){
        items = i;
        total = 0;
        for(int k = 0; k<items.size(); k++){
            total += items.get(k).getPrice();
        }
    }
    public List<MenuItem> getItems(){
        return items;
    }
    public void setPaymentStrategy(PaymentStrategy p){
        paymentStrategy = p;
    }
    public void setTotal(double t){
        total = t;
    }
    public void setScheduled(String time){
        scheduled = time;
    }
}
