package com.highfive.momentrip.data.model;

import com.google.gson.annotations.SerializedName;

public class MomentResult {
    // 서버로부터 받는 데이터들 밖에 없음
    @SerializedName("id")
    private int moment_id;

    @SerializedName("UserId")
    private int user_id;

    @SerializedName("BookId")
    private int book_id;

    @SerializedName("moment_title")
    private String momentTitle;

    @SerializedName("moment_content")
    private String momentContent;

    @SerializedName("moment_img")
    private String momentImg;

    public int getMoment_id() {
        return moment_id;
    }

    public void setMoment_id(int moment_id) {
        this.moment_id = moment_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getMomentTitle() {
        return momentTitle;
    }

    public void setMomentTitle(String momentTitle) {
        this.momentTitle = momentTitle;
    }

    public String getMomentContent() {
        return momentContent;
    }

    public void setMomentContent(String momentContent) {
        this.momentContent = momentContent;
    }

    public String getMomentImg() {
        return momentImg;
    }

    public void setMomentImg(String momentImg) {
        this.momentImg = momentImg;
    }

}
