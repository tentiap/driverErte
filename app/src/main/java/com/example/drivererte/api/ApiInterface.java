package com.example.drivererte.api;

import com.example.drivererte.model.loginFeeder.LoginFeeder;
import com.example.drivererte.model.loginSopir.LoginSopir;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("loginSopir")
    Call<LoginSopir> loginSopirResponse(
            @Field("email") String email,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("loginFeeder")
    Call<LoginFeeder> loginFeederResponse(
            @Field("email") String email,
            @Field("password") String password
    );
}
