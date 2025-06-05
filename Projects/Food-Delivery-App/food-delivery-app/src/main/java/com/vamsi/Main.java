package com.vamsi;

import com.vamsi.models.Order;
import com.vamsi.models.Restaurant;
import com.vamsi.models.User;
import com.vamsi.strategies.UpiPayment;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FoodDeliveryApp foodDeliveryApp = new FoodDeliveryApp();
        User user = new User(101,"Vamsi","Srikalahasti");
        System.out.println("User "+user.getName()+" is active");
        List<Restaurant> restaurants = foodDeliveryApp.searchRestaurants("srikalahasti");

        if(restaurants.isEmpty()){
            System.out.println("No restaurants found!!");
            return;
        }
        System.out.println("Found restaurants: ");
        for(int i = 0; i< restaurants.size(); i++){
            System.out.println(restaurants.get(i).getName());
        }

        // user selects a restaurant
        foodDeliveryApp.selectRestaurant(user,restaurants.get(0));
        System.out.println("Selected Restaurant: "+restaurants.get(0).getName());

        // user adding items to the cart
        foodDeliveryApp.addToCart(user,"101");
        foodDeliveryApp.addToCart(user,"102");

        foodDeliveryApp.printUserCart(user);

        Order order = foodDeliveryApp.checkOutNow(user,"Delivery", new UpiPayment("1234567890"));

        foodDeliveryApp.payForOrder(user,order);

    }
}