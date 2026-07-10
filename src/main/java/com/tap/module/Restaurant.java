package com.tap.module;

public class Restaurant {

    private int restaurantId;
    private String restaurantName;
    private String ownerName;
    private String phone;
    private String email;
    private String address;
    private String imageUrl;
    private double rating;
    private String status;
    private String cuisine;
    private int deliveryTime;
    private int priceForTwo;

    // Default Constructor
    public Restaurant() {

    }

    // Constructor without restaurantId
    public Restaurant(String restaurantName, String ownerName, String phone,
                      String email, String address, String imageUrl,
                      double rating, String status,
                      String cuisine, int deliveryTime, int priceForTwo) {

        this.restaurantName = restaurantName;
        this.ownerName = ownerName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.imageUrl = imageUrl;
        this.rating = rating;
        this.status = status;
        this.cuisine = cuisine;
        this.deliveryTime = deliveryTime;
        this.priceForTwo = priceForTwo;
    }

    // Constructor with restaurantId
    public Restaurant(int restaurantId, String restaurantName,
                      String ownerName, String phone,
                      String email, String address,
                      String imageUrl, double rating,
                      String status,
                      String cuisine, int deliveryTime, int priceForTwo) {

        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.ownerName = ownerName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.imageUrl = imageUrl;
        this.rating = rating;
        this.status = status;
        this.cuisine = cuisine;
        this.deliveryTime = deliveryTime;
        this.priceForTwo = priceForTwo;
    }

    // Getters and Setters

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public int getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public int getPriceForTwo() {
        return priceForTwo;
    }

    public void setPriceForTwo(int priceForTwo) {
        this.priceForTwo = priceForTwo;
    }

    @Override
    public String toString() {
        return "Restaurant [restaurantId=" + restaurantId
                + ", restaurantName=" + restaurantName
                + ", ownerName=" + ownerName
                + ", phone=" + phone
                + ", email=" + email
                + ", address=" + address
                + ", imageUrl=" + imageUrl
                + ", rating=" + rating
                + ", status=" + status
                + ", cuisine=" + cuisine
                + ", deliveryTime=" + deliveryTime
                + ", priceForTwo=" + priceForTwo
                + "]";
    }
}