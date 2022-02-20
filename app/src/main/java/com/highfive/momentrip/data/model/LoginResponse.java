package com.highfive.momentrip.data.model;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("user")
    public User user;

    @SerializedName("token")
    public String token;

    // Getter and Setter
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
