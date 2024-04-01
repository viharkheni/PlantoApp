package com.example.plantoapp;

public class Plant  {
    private int imageResourceId;
    private String name;
    private int withoutBgImage;
    private String rating;
    private String description;
    private String size;
    private String plant;
    private String height;
    private String humidity;
    private String price;



    public int getImageResourceId() {
        return imageResourceId;
    }
    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getWithoutBgImage() {
        return withoutBgImage;
    }
    public void setWithoutBgImage(int withoutBgImage) {
        this.withoutBgImage = withoutBgImage;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPlant() {
        return plant;
    }

    public void setPlant(String plant) {
        this.plant = plant;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Plant(int imageResourceId, String name, int withoutBgImage, String rating, String description, String size, String plant, String height, String humidity, String price) {
        this.imageResourceId = imageResourceId;
        this.name = name;
        this.withoutBgImage = withoutBgImage;
        this.rating = rating;
        this.description = description;
        this.size = size;
        this.plant = plant;
        this.height = height;
        this.humidity = humidity;
        this.price = price;
    }
}
