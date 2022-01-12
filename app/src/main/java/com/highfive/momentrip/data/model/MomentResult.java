package com.highfive.momentrip.data.model;

import com.google.gson.annotations.SerializedName;

public class MomentResult {
    @SerializedName("UserId")
    private int user_id;

    @SerializedName("BookId")
    private int book_id;

    @SerializedName("momentTitle")
    private String momentTitle;

    @SerializedName("momentContent")
    private String momentContent;

    @SerializedName("momentImg")
    private String momentImg;

    @SerializedName("momentPublic")
    private boolean momentPublic;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public int getBookId() {
        return book_id;
    }

    public void setBookId(int bookId) {
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

    public boolean isMomentPublic() {
        return momentPublic;
    }

    public void setMomentPublic(boolean momentPublic) {
        this.momentPublic = momentPublic;
    }
}
