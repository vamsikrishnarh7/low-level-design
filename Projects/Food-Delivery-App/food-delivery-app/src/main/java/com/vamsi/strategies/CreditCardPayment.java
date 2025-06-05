package com.vamsi.strategies;

public class CreditCardPayment extends PaymentStrategy{
    private String creditCardNumber;

    public CreditCardPayment(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid Rs."+amount+" using credit card "+creditCardNumber);
    }
}
