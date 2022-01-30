package com.highfive.momentrip.data.repository;

import com.highfive.momentrip.data.model.BookAllResult;
import com.highfive.momentrip.data.model.BookResult;
import com.highfive.momentrip.data.model.MomentResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MomentripService {
    // Moment API
    @GET("moment/select/{id}") // 해당 id를 가진 모멘트만 부름
    Call<MomentResult> getMoment(@Path("id") int my_id);

    @GET("moment/user/{user_id}") // 해당 user_id의 모멘트 확인
    Call<MomentResult> getUserMoment(@Path("user_id") int user_id);

    @GET("moment/book/{book_id}") // 해당 book_id의 모멘트 확인
    Call<MomentResult> getBookMoment(@Path("book_id") int book_id);


    // Book API

    @GET("book/select/{id}")  // 해당 book id의 book 데이터 수집
    Call<BookResult> getBook(@Path("id") int bookId);

    @GET("book/select/user/{user_id}") // 해당 user id의 book 데이터 수집
    Call<BookAllResult> getUserBook(@Path("user_id") int userId);

}
