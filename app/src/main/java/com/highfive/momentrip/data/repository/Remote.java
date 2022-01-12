package com.highfive.momentrip.data.repository;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Remote {
    // Retrofit 인스턴스 생성

    Retrofit retrofit  = new Retrofit.Builder()
            .baseUrl("http://52.79.158.158:3000/momentrip/") //baseUrl 등록
            .addConverterFactory(GsonConverterFactory.create()) // JSON을 변환해줄 Gson 변환기 등록
            .build();

    // Retrofit 인스턴스로 인터페이스 객체 구현
    private MomentripService momentService = retrofit.create(MomentripService.class);

    /** Book 반환 **/

}
