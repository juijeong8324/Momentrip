package com.highfive.momentrip.data.repository;

import com.highfive.momentrip.data.model.BookResult;
import com.highfive.momentrip.data.model.MomentResult;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface MomentripService {
    // Moment API
    @POST("moment")
    Call<MomentResult> setBook(@Body MomentResult momentResult); // Create 방식 Body에 전송할 데이터를 담아서 서버에 생성

    @GET("moment")
    Call<MomentResult> getAllMoment();

    @GET("moment/select/{id}") // 나의 모멘트 확인
    Call<MomentResult> getMyMoment(@Path("id") int my_id);

    @GET("moment/user/{user_id}") // 해당 id의 모멘트 확인
    Call<MomentResult> getUserMoment(@Path("user_id") int user_id);

    @GET("moment/book/{book_id}") // 해당 book_id의 모멘트 확인
    Call<MomentResult> getBookMoment(@Path("book_id") int book_id);

    @PATCH("moment/{id}") // 내 모멘트 수정
    Call<MomentResult> patchMyMoment(@Path("id") int my_id, @Body MomentResult momentResult);

    @DELETE("moment/{id}") // 내 모멘트 삭제
    Call<MomentResult> deleteMyMoment(@Path("id") int my_id);

    // Book API
    @POST("book")
    Call<BookResult> setBook(@Body BookResult bookResult); // Create 방식 Body에 전송할 데이터를 담아서 서버에 생성

    @GET("book") // book 전체 데이터 수집
    Call<BookResult> getAllBook();

    @GET("book/select/{id}")  // 해당 book id의 book 데이터 수집
    Call<BookResult> getBook(@Path("id") int bookId);

    @GET("book/select/user/{user_id}") // 해당 user id의 book 데이터 수집
    Call<BookResult> getUserBook(@Path("user_id") int userId);

    @PATCH("book/{id}") // 해당 book id로 book 데이터 수정
    Call<BookResult> patchBook(@Path("id") int bookId, @Body BookResult bookResult );

    @DELETE("book/{id}") // 해당 book id 데이터 삭제
    Call<BookResult> deleteBook(@Path("id") int bookId);
}
