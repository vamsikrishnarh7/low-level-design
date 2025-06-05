package com.vamsi.factories;

import com.vamsi.models.*;
import com.vamsi.strategies.PaymentStrategy;

import java.util.List;

public abstract class OrderFactory {
    public abstract Order createOrder(User user, Cart cart, Restaurant restaurant,
                                      List<MenuItem> menuItems, PaymentStrategy paymentStrategy, String orderType);

}
