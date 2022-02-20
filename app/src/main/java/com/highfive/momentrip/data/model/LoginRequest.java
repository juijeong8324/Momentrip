package com.highfive.momentrip.data.model;

import com.google.gson.annotations.SerializedName;

public class LoginRequest { // 로그인 요청을 위한 객체
    @SerializedName("email")
    public String email;

    @SerializedName("password")
    public String password;

    // Constructor
    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Getter and Setter
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
