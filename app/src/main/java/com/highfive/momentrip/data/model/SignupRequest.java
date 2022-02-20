package com.highfive.momentrip.data.model;

import com.google.gson.annotations.SerializedName;

public class SignupRequest {
    @SerializedName("email")
    public String email;

    @SerializedName("password")
    public String password;

    @SerializedName("nick")
    public String nick;

    @SerializedName("name")
    public String name;

    @SerializedName("snsId")
    public String snsId;

    @SerializedName("profile_img")
    public String profile_img;

    // Constructor
    public SignupRequest(String email, String password, String nick, String name, String snsId, String profile_img) {
        this.email = email;
        this.password = password;
        this.nick = nick;
        this.name = name;
        this.snsId = snsId;
        this.profile_img = profile_img;
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

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getString() {
        return name;
    }

    public void setString(String name) {
        this.name = name;
    }

    public String getSnsId() {
        return snsId;
    }

    public void setSnsId(String snsId) {
        this.snsId = snsId;
    }

    public String getProfile_img() {
        return profile_img;
    }

    public void setProfile_img(String profile_img) {
        this.profile_img = profile_img;
    }
}
