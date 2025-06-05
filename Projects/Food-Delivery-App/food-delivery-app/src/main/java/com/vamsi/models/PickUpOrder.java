package com.vamsi.models;

public class PickUpOrder extends Order{
    private String restaurantAddress;
    public PickUpOrder(){
        restaurantAddress = "";

    }
    @Override
    public String getType(){
        return "Pickup";
    }
    public void setRestaurantAddress(String adr){
        restaurantAddress = adr;
    }
    public String getRestaurantAddress(){
        return restaurantAddress;
    }
}
