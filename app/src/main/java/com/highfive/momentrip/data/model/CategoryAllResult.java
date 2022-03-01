package com.highfive.momentrip.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class CategoryAllResult {
    @SerializedName("data")
    public List<CategoryResult> categorys;

    // getter and setter
    public List<CategoryResult> getCategorys() {return categorys;}

    public void setCategorys(List<CategoryResult> categorys) {
        this.categorys = categorys;
    }

    public int getCategoryCount() {
        return categorys.size();
    }
}
