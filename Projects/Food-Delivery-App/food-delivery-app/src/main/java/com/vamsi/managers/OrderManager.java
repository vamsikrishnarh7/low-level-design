package com.vamsi.managers;

import com.vamsi.models.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderManager { // singleton class
    private List<Order> orders;
    private static OrderManager instace = null;

    private OrderManager(){
        orders = new ArrayList<>();
    }

    public static OrderManager getInstance(){
        if(instace == null){
            instace = new OrderManager();
        }
        return instace;
    }
    public void addOrder(Order order){
        orders.add(order);
    }

    public void listOrders(){
        System.out.println("\n-----All Orders----\n");
//        for(int i = 0; i<orders.size(); i++){
//            System.out.println();
//        }
    }


}
