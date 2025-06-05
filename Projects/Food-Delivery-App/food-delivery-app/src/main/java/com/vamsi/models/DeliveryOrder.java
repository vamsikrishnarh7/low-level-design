package com.vamsi.models;

public class DeliveryOrder extends Order{
    private String userAddress;
    public DeliveryOrder(){
        userAddress = "";
    }
    @Override
    public String getType(){
        return "Delivery";
    }
    public void setUserAddress(String adr){
        userAddress = adr;
    }
    public String getUserAddress(){
        return userAddress;
    }
}
