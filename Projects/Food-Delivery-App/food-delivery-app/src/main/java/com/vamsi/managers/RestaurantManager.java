package com.vamsi.managers;

import java.util.*;
import com.vamsi.models.Restaurant;

public class RestaurantManager {
    private List<Restaurant> restaurants;
    private static RestaurantManager restaurantManager = null;

    private RestaurantManager(){
        restaurants = new ArrayList<>();
    }

    public static RestaurantManager getInstance(){
        if(restaurantManager == null){
            restaurantManager = new RestaurantManager();
        }
        return restaurantManager;
    }

    public void addRestaurant(Restaurant restaurant){
        restaurants.add(restaurant);
    }
    public List<Restaurant> searchByLocation(String location){
        List<Restaurant> result = new ArrayList<Restaurant>();
        for(int i = 0; i<restaurants.size(); i++){
            if(restaurants.get(i).getLocation().equalsIgnoreCase(location)){
                result.add(restaurants.get(i));
            }
        }
        return result;
    }
}
