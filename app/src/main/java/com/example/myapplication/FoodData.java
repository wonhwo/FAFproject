package com.example.myapplication;

public class FoodData {
    private int foodImg;
    private String foodName;
    private String foodA;

    public FoodData(int foodImg, String foodName, String foodA) {
        this.foodImg=foodImg;
        this.foodName=foodName;
        this.foodA=foodA;
    }

    public int getFoodImg() {
        return foodImg;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getFoodA() {
        return foodA;
    }

    public void setFoodImg(int foodImg) {
        this.foodImg = foodImg;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setFoodA(String foodA) {
        this.foodA = foodA;
    }
}
