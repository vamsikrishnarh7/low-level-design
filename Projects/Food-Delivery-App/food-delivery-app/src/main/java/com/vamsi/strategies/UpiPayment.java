package com.vamsi.strategies;

public class UpiPayment extends PaymentStrategy{
    private String mobile;
    public UpiPayment(String mobile){
        this.mobile = mobile;
    }
    @Override
    public void pay(double amount) {
        System.out.println("Paid Rupee(s) "+amount+" using UPI ("+mobile.substring(0,6)+"xxxxx)");
    }
}
