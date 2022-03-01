package com.highfive.momentrip.data.repository;

import android.util.Log;

import com.highfive.momentrip.data.model.BookAllResult;
import com.highfive.momentrip.data.model.BookResult;
import com.highfive.momentrip.data.model.CategoryAllResult;
import com.highfive.momentrip.data.model.LoginRequest;
import com.highfive.momentrip.data.model.LoginResponse;
import com.highfive.momentrip.data.model.MomentResult;
import com.highfive.momentrip.data.model.SignupRequest;
import com.highfive.momentrip.data.model.SignupResponse;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
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

    /*Auth API 관련 */
    //회원가입
    public void signup(SignupRequest request, Remote.GetDataCallback<SignupResponse> callback) {
        // 인터페이스 구현
        momentService.signup(request).enqueue(new Callback<SignupResponse>() {
            @Override
            public void onResponse(Call<SignupResponse> call, Response<SignupResponse> response) { // 요청 성공
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                }
            }
            @Override
            public void onFailure(Call<SignupResponse> call, Throwable t) { // 요청 실패
                callback.onFailure(t);
            }
        });
    }

    /*User API 관련*/
    //로그인
    public void login(LoginRequest request, Remote.GetDataCallback<LoginResponse> callback) {
        // 인터페이스 구현
        momentService.login(request).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) { callback.onSuccess(response.body()); }
            }
            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) { callback.onFailure(t); }
        });
    }

    // GET User By id
    public void getUserById(String userId, Remote.GetDataCallback<SignupResponse> callback) {
        // 인터페이스 구현
        momentService.getUserById(userId).enqueue(new Callback<SignupResponse>() {
            @Override
            public void onResponse(Call<SignupResponse> call, Response<SignupResponse> response) {
                if (response.isSuccessful()) { callback.onSuccess(response.body()); }
            }
            @Override
            public void onFailure(Call<SignupResponse> call, Throwable t) { callback.onFailure(t); }
        });
    }


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

    /* Category API 관련 */
    public void getUserCategory(int user_id, Remote.GetDataCallback<CategoryAllResult> callback) {
        momentService.getUserCategory(user_id).enqueue(new Callback<CategoryAllResult>() {
            @Override
            public void onResponse(Call<CategoryAllResult> call, Response<CategoryAllResult> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<CategoryAllResult> call, Throwable t) {
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
