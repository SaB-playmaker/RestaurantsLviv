package com.restaurants.lviv.restLvivApplication;

public class MyRestaurantData {

    private String RestaurantName;
    private String RestaurantRate;
    private Integer RestaurantImage;

    public MyRestaurantData(String RestaurantName, String RestaurantRate, Integer RestaurantImage) {
        this.RestaurantName = RestaurantName;
        this.RestaurantRate = RestaurantRate;
        this.RestaurantImage = RestaurantImage;
    }

    public String getRestaurantName() {
        return RestaurantName;
    }

    public void setRestaurantName(String RestaurantName) {
        this.RestaurantName = RestaurantName;
    }

    public String getRestaurantRate() {
        return RestaurantRate;
    }

    public void setRestaurantRate(String RestaurantRate) {
        this.RestaurantRate = RestaurantRate;
    }

    public Integer getRestaurantImage() {
        return RestaurantImage;
    }

    public void setRestaurantImage(Integer RestaurantImage) {
        this.RestaurantImage = RestaurantImage;
    }
}
