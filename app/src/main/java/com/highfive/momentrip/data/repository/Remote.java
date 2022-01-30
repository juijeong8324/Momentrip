package com.highfive.momentrip.data.repository;

import android.util.Log;

import com.highfive.momentrip.data.model.BookAllResult;
import com.highfive.momentrip.data.model.BookResult;
import com.highfive.momentrip.data.model.MomentResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Remote {
    // Retrofit 인스턴스 생성

    Retrofit retrofit  = new Retrofit.Builder()
            .baseUrl("http://52.79.158.158:3000/momentrip/") //baseUrl 등록
            .addConverterFactory(GsonConverterFactory.create()) // JSON을 변환해줄 Gson 변환기 등록
            .build();

    // Request 메소드들을 작성해놓은 인터페이스 객체
    private MomentripService momentService = retrofit.create(MomentripService.class);

    /** Book API 관련 **/
    // 해당 book id의 book 데이터 수집
    public void getBook(int book_id, Remote.GetDataCallback<BookResult> callback){
        // 인터페이스 구현
        momentService.getBook(book_id).enqueue(new Callback<BookResult>() {
            @Override
            public void onResponse(Call<BookResult> call, Response<BookResult> response) { // 서버 통신에 성공했을 때 이때 Response에 서버에 응답 받은 데이터가 있음
                    if(response.isSuccessful()) {callback.onSuccess(response.body());}
            }

            @Override
            public void onFailure(Call<BookResult> call, Throwable t) { // 서버 통신에 실패했을 때
                    callback.onFailure(t);
            }
        });
    }

    // 해당 user id의 book 데이터 수집
    public void getUserBook(int user_id, Remote.GetDataCallback<BookAllResult> callback){
        momentService.getUserBook(user_id).enqueue(new Callback<BookAllResult>() {
            @Override
            public void onResponse(Call<BookAllResult> call, Response<BookAllResult> response) {
                Log.v("뿌꾸뿌꾸","성공");
                if(response.isSuccessful()) {callback.onSuccess(response.body());}
            }

            @Override
            public void onFailure(Call<BookAllResult> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }

    /*Moment API 관련 */
    // 해당 id를 가진 모멘트만 부름
    public void getMoment(int moment_id, Remote.GetDataCallback<MomentResult> callback){
        momentService.getMoment(moment_id).enqueue(new Callback<MomentResult>() {
            @Override
            public void onResponse(Call<MomentResult> call, Response<MomentResult> response) {
                if(response.isSuccessful()) {callback.onSuccess(response.body());}
            }

            @Override
            public void onFailure(Call<MomentResult> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }

    // 해당 user_id의 모멘트 확인
    public void getUserMoment(int user_id, Remote.GetDataCallback<MomentResult> callback){
        momentService.getMoment(user_id).enqueue(new Callback<MomentResult>() {
            @Override
            public void onResponse(Call<MomentResult> call, Response<MomentResult> response) {
                if(response.isSuccessful()) {callback.onSuccess(response.body());}
            }

            @Override
            public void onFailure(Call<MomentResult> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }

    // 해당 book_id의 모멘트 확인
    public void getBookMoment(int book_id, Remote.GetDataCallback<MomentResult> callback){
        momentService.getMoment(book_id).enqueue(new Callback<MomentResult>() {
            @Override
            public void onResponse(Call<MomentResult> call, Response<MomentResult> response) {
                if(response.isSuccessful()) {callback.onSuccess(response.body());}
            }

            @Override
            public void onFailure(Call<MomentResult> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }

    /** 응답 콜백 인터페이스*/
    public interface GetDataCallback<T> {
        void onSuccess(T data);
        void onFailure(Throwable throwable);
    }
}
