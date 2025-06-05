package com.vamsi.models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private Restaurant restaurant;
    private List<MenuItem> items;

    public Cart(){
        restaurant = null;
        items = new ArrayList<>();
    }

    public void addItem(MenuItem item){
        if(restaurant == null){
            System.out.println("\n\n\nSET A RESTAURANT BEFORE ADDING ITEMS\n\n");
            return;
        }
        items.add(item);
    }

    public List<MenuItem> getItems(){
        return items;
    }

    public double getTotalCost(){
        double total = 0;
        for(int i = 0; i<items.size(); i++){
            total += items.get(i).getPrice();
        }
        return total;
    }

    public boolean isEmpty(){
        return ((restaurant==null) || (items.isEmpty()));
    }

    public void clear(){
        items.clear();
        restaurant = null;
    }

    public void setRestaurant(Restaurant r){
        restaurant = r;
    }
    public Restaurant getRestaurant(){
        return restaurant;
    }

}
