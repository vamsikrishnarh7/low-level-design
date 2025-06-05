package com.vamsi.factories;

import com.vamsi.models.*;
import com.vamsi.strategies.PaymentStrategy;

import java.util.List;

public class NowOrderFactory extends OrderFactory {


    @Override
    public Order createOrder(User user, Cart cart, Restaurant restaurant, List<MenuItem> menuItems, PaymentStrategy paymentStrategy, String orderType) {
        Order order = null;
        if(orderType.equalsIgnoreCase("delivery")){
            DeliveryOrder deliveryOrder = new DeliveryOrder();
            deliveryOrder.setUserAddress(user.getAddress());
            order = deliveryOrder;
        }
        else{
            PickUpOrder pickUpOrder = new PickUpOrder();
            pickUpOrder.setRestaurantAddress(restaurant.getLocation());
            order = pickUpOrder;
        }
        order.setUser(user);
        order.setRestaurant(restaurant);
        order.setItems(menuItems);
        order.setPaymentStrategy(paymentStrategy);
        order.setTotal(cart.getTotalCost());
        return order;
    }
}
