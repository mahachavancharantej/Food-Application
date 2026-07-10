package com.tap.module;

public class Productsize {

    private int sizeId;
    private int productId;
    private String sizeName;
    private double price;

    public Productsize() {
    }

    public Productsize(int productId, String sizeName, double price) {
        this.productId = productId;
        this.sizeName = sizeName;
        this.price = price;
    }

    public Productsize(int sizeId, int productId, String sizeName, double price) {
        this.sizeId = sizeId;
        this.productId = productId;
        this.sizeName = sizeName;
        this.price = price;
    }

    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductSize [sizeId=" + sizeId +
                ", productId=" + productId +
                ", sizeName=" + sizeName +
                ", price=" + price + "]";
    }
}