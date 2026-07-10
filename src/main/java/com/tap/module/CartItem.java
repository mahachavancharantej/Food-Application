package com.tap.module;

public class CartItem {

    private int cartItemId;
    private int cartId;
    private int productId;
    private int sizeId;
    private int quantity;
    private double totalPrice;
    private String productName;
    private String sizeName;
    private int restaurantId;

    // Default Constructor
    public CartItem() {

    }

    // Constructor without cartItemId
    public CartItem(int cartId, int productId, int sizeId,
                    int quantity, double totalPrice) {

        this.cartId = cartId;
        this.productId = productId;
        this.sizeId = sizeId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    // Constructor with cartItemId
    public CartItem(int cartItemId, int cartId, int productId,
                    int sizeId, int quantity, double totalPrice) {

        this.cartItemId = cartItemId;
        this.cartId = cartId;
        this.productId = productId;
        this.sizeId = sizeId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public int getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(int cartItemId) {
        this.cartItemId = cartItemId;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }
    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    @Override
    public String toString() {
        return "CartItem [cartItemId=" + cartItemId +
                ", cartId=" + cartId +
                ", productId=" + productId +
                ", productName=" + productName +
                ", sizeId=" + sizeId +
                ", sizeName=" + sizeName +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice + "]";
    }
}