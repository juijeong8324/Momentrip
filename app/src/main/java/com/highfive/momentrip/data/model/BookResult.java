package com.highfive.momentrip.data.model;

import com.google.gson.annotations.SerializedName;


public class BookResult {
    // 가장 기본이 되는 앨범집 DTO
    // 서버로부터 받는 데이터들 밖에 없음
    @SerializedName("id")
    private int book_id;

    @SerializedName("UserId")
    private int user_id;

    @SerializedName("book_title")
    private String book_title;

    @SerializedName("book_img")
    private String book_img;

    @SerializedName("CategoryId")
    private int categoryId;

    @SerializedName("book_hit")
    private int book_hit;

    @SerializedName("trip_start_date")
    private String trip_start_date;

    @SerializedName("trip_end_date")
    private String trip_end_date;

    // 생성자
    public BookResult(int book_id, int user_id, String book_title, String book_img, int categoryId, int book_hit, String trip_start_date, String trip_end_date) {
        this.book_id = book_id;
        this.user_id = user_id;
        this.book_title = book_title;
        this.book_img = book_img;
        this.categoryId = categoryId;
        this.book_hit = book_hit;
        this.trip_start_date = trip_start_date;
        this.trip_end_date = trip_end_date;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public String getBook_img() {
        return book_img;
    }

    public void setBook_img(String book_img) {
        this.book_img = book_img;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getBook_hit() {
        return book_hit;
    }

    public void setBook_hit(int book_hit) {
        this.book_hit = book_hit;
    }

    public String getTrip_start_date() {
        return trip_start_date;
    }

    public void setTrip_start_date(String trip_start_date) {
        this.trip_start_date = trip_start_date;
    }

    public String getTrip_end_date() {
        return trip_end_date;
    }

    public void setTrip_end_date(String trip_end_date) {
        this.trip_end_date = trip_end_date;
    }
}
