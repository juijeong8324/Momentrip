package com.highfive.momentrip.data.model;

import com.google.gson.annotations.SerializedName;

public class BookResult {

    // 모멘트립 앨범집 DTO 모델 Class
    @SerializedName("UserId")
    private int userId;

    @SerializedName("book_title")
    private String book_title;

    @SerializedName("book_public")
    private boolean book_public;

    @SerializedName("book_img")
    private String book_img;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public boolean isBook_public() {
        return book_public;
    }

    public void setBook_public(boolean book_public) {
        this.book_public = book_public;
    }

    public String getBook_img() {
        return book_img;
    }

    public void setBook_img(String book_img) {
        this.book_img = book_img;
    }
}
