package com.example.ECommerceApp.model;

public class Product {
    int product_image;
    String name;
    String description;
    String shop_id;
    String category_id;
    float price;
    public Product(int product_img, String name, String description, String shop_id, String category_id, float price) {
        this.product_image = product_img;
        this.name = name;
        this.description = description;
        this.shop_id = shop_id;
        this.category_id = category_id;
        this.price=price;
    }
    public Product() {

    }

    public int getProduct_image() {
        return product_image;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getShop_id() {
        return shop_id;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setProduct_img(int product_img) {
        this.product_image = product_img;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setShop_id(String shop_id) {
        this.shop_id = shop_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public void setProduct_image(int product_image) {
        this.product_image = product_image;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
