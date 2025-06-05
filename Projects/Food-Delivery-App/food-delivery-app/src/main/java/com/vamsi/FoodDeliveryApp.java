package com.vamsi;

import com.vamsi.factories.NowOrderFactory;
import com.vamsi.factories.OrderFactory;
import com.vamsi.factories.ScheduledOrderFactory;
import com.vamsi.managers.OrderManager;
import com.vamsi.managers.RestaurantManager;
import com.vamsi.models.*;
import com.vamsi.services.NotificationService;
import com.vamsi.strategies.PaymentStrategy;

import java.util.List;

public class FoodDeliveryApp {
    FoodDeliveryApp(){
        initializeRestaurants();
    }
    void initializeRestaurants(){
        Restaurant restaurant1 = new Restaurant("Swamy Hotel","Srikalahasti");
        restaurant1.addMenuItem(new MenuItem("101","Karam Dosa",40));
        restaurant1.addMenuItem(new MenuItem("102", "Podi dosa", 40));
        restaurant1.addMenuItem(new MenuItem("103","Sambar Idly",30));

        Restaurant restaurant2 = new Restaurant("MGM","Srikalahasti");
        restaurant1.addMenuItem(new MenuItem("101","Plain Dosa",70));
        restaurant1.addMenuItem(new MenuItem("102", "Podi dosa", 90));
        restaurant1.addMenuItem(new MenuItem("103","Sambar Idly",60));

        Restaurant restaurant3 = new Restaurant("Saravana Bhavan","Srikalahasti");
        restaurant1.addMenuItem(new MenuItem("101","Dosa",50));
        restaurant1.addMenuItem(new MenuItem("102", "Masala dosa", 60));
        restaurant1.addMenuItem(new MenuItem("103","Sambar Idly",40));

        RestaurantManager restaurantManager = RestaurantManager.getInstance();
        restaurantManager.addRestaurant(restaurant1);
        restaurantManager.addRestaurant(restaurant2);
        restaurantManager.addRestaurant(restaurant3);

    }
    List<Restaurant> searchRestaurants(String location){
        return RestaurantManager.getInstance().searchByLocation(location);
    }

    void selectRestaurant(User user, Restaurant restaurant){
        Cart cart = user.getCart();
        cart.setRestaurant(restaurant);
    }

    void addToCart(User user, String itemCode){
        Restaurant restaurant = user.getCart().getRestaurant();
        if(restaurant == null){
            System.out.println("Please select a restaurant first");
            return;
        }
        for(int i = 0; i<restaurant.getMenu().size(); i++){
            if(restaurant.getMenu().get(i).getCode().equalsIgnoreCase(itemCode)){
                user.getCart().addItem(restaurant.getMenu().get(i));
                break;
            }
        }
    }

    Order checkOutNow(User user, String orderType, PaymentStrategy paymentStrategy){
        return checkOut(user,orderType,paymentStrategy, new NowOrderFactory());
    }
    Order checkOutScheduled(User user, String orderType, PaymentStrategy paymentStrategy, String scheduledTime){
        return checkOut(user,orderType,paymentStrategy, new ScheduledOrderFactory(scheduledTime));
    }
    private Order checkOut(User user, String orderType, PaymentStrategy paymentStrategy, OrderFactory orderFactory){
        if(user.getCart().isEmpty()) return null;

        Cart userCart = user.getCart();
        Restaurant orderedRestaurant = userCart.getRestaurant();
        List<MenuItem> itemsOrdered = userCart.getItems();
        double totalCost = userCart.getTotalCost();

        Order order = orderFactory.createOrder(user,userCart,orderedRestaurant,itemsOrdered,paymentStrategy,orderType);
        OrderManager.getInstance().addOrder(order);
        return order;
    }

    void payForOrder(User user, Order order){
        boolean isPaymentSuccess = order.processPayment();
        if(isPaymentSuccess){
            NotificationService notificationService = new NotificationService();
            notificationService.notify(order);
            user.getCart().clear();
        }
    }
    void printUserCart(User user){
        System.out.println("\n    Items in cart");
        System.out.println("-----------------------");
        for(int i = 0; i<user.getCart().getItems().size(); i++){
            System.out.println((i+1)+". "+user.getCart().getItems().get(i).getName()+" - Rs."+user.getCart().getItems().get(i).getPrice());
        }
        System.out.println("\n\n");
    }
}
