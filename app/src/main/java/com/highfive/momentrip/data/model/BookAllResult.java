package com.highfive.momentrip.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class BookAllResult{

    @SerializedName("data")
    public List<BookResult> books;

    // Getter and Setter
    public List<BookResult> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<BookResult> books) {
        this.books = books;
    }

    public int getBookCount() {
        return books.size();
    }
}
