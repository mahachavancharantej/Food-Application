package com.tap.module;

public class Category {

    private int categoryId;
    private String categoryName;

    // Default Constructor
    public Category() {

    }

    // Constructor without ID
    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    // Constructor with ID
    public Category(int categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    // Getters & Setters

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Category [categoryId=" + categoryId +
                ", categoryName=" + categoryName + "]";
    }
}