package com.example.ECommerceApp.Model;

public class Category {
    int category_image;
    String category_name;
    String quantity;

    public Category(int category_image, String category_name, String quantity) {
        this.category_image = category_image;
        this.category_name = category_name;
        this.quantity = quantity;
    }

    public int getCategory_image() {
        return category_image;
    }

    public void setCategory_image(int category_image) {
        this.category_image = category_image;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}

