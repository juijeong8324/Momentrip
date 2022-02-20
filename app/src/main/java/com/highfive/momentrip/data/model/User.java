package com.highfive.momentrip.data.model;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("id") // JSON 객체와 해당 변수를 매칭
    private int id;

    @SerializedName("email")
    private String email;

    @SerializedName("nick")
    private String nick;

    @SerializedName("password")
    private String password;

    @SerializedName("name")
    private String name;

    @SerializedName("profile_img")
    private String profile_img;

    // Constructor
    public User(int id, String email, String nick, String password, String name, String profile_img) {
        this.id = id;
        this.email = email;
        this.nick = nick;
        this.password = password;
        this.name = name;
        this.profile_img = profile_img;
    }

    // Getter and Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfile_img() {
        return profile_img;
    }

    public void setProfile_img(String profile_img) {
        this.profile_img = profile_img;
    }
}
