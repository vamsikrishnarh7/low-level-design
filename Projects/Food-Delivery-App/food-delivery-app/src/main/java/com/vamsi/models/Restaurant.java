package com.vamsi.models;

import java.util.*;
public class Restaurant {
    private static int nextId = 0;
    private int id;
    private String name;
    private String location;
    private List<MenuItem> menu;

    public Restaurant(String name, String location) {
        this.name = name;
        this.location = location;
        this.id = ++nextId;
        menu = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<MenuItem> getMenu() {
        return menu;
    }

    public void addMenuItem(MenuItem item) {
        menu.add(item);
    }
}
