package com.tap.module;

import java.sql.Timestamp;

public class Cart {

    private int cartId;
    private int userId;
    private Timestamp createdAt;

    // Default Constructor
    public Cart() {

    }

    // Constructor without cartId
    public Cart(int userId, Timestamp createdAt) {
        this.userId = userId;
        this.createdAt = createdAt;
    }

    // Constructor with cartId
    public Cart(int cartId, int userId, Timestamp createdAt) {
        this.cartId = cartId;
        this.userId = userId;
        this.createdAt = createdAt;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Cart [cartId=" + cartId +
                ", userId=" + userId +
                ", createdAt=" + createdAt + "]";
    }
}