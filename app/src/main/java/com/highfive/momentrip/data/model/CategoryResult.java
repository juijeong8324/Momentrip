package com.highfive.momentrip.data.model;

import com.google.gson.annotations.SerializedName;

public class CategoryResult {
    @SerializedName("id")
    private int category_id;

    @SerializedName("category_value")
    private String category_value;

    //생성자
    public CategoryResult(int category_id, String category_value) {
        this.category_id = category_id;
        this.category_value = category_value;
    }

    // getter and setter

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory_value() {
        return category_value;
    }

    public void setCategory_value(String category_value) {
        this.category_value = category_value;
    }
}
