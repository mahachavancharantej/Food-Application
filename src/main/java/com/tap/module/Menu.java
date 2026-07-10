package com.tap.module;

public class Menu {

    private int productId;
    private int restaurantId;
    private int categoryId;
    private String productName;
    private String description;
    private String imageUrl;
    private double basePrice;
    private boolean isAvailable;

    // Default Constructor
    public Menu() {

    }

    // Constructor without productId
    public Menu(int restaurantId, int categoryId, String productName,
                String description, String imageUrl,
                double basePrice, boolean isAvailable) {

        this.restaurantId = restaurantId;
        this.categoryId = categoryId;
        this.productName = productName;
        this.description = description;
        this.imageUrl = imageUrl;
        this.basePrice = basePrice;
        this.isAvailable = isAvailable;
    }

    // Constructor with productId
    public Menu(int productId, int restaurantId, int categoryId,
                String productName, String description,
                String imageUrl, double basePrice,
                boolean isAvailable) {

        this.productId = productId;
        this.restaurantId = restaurantId;
        this.categoryId = categoryId;
        this.productName = productName;
        this.description = description;
        this.imageUrl = imageUrl;
        this.basePrice = basePrice;
        this.isAvailable = isAvailable;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "Menu [productId=" + productId +
                ", restaurantId=" + restaurantId +
                ", categoryId=" + categoryId +
                ", productName=" + productName +
                ", description=" + description +
                ", imageUrl=" + imageUrl +
                ", basePrice=" + basePrice +
                ", isAvailable=" + isAvailable + "]";
    }
}