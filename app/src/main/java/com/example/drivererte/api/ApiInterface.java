package com.example.drivererte.api;

import com.example.drivererte.model.changeStatus.ChangeStatus;
import com.example.drivererte.model.detailTripSopir.DetailTripSopir;
import com.example.drivererte.model.historySopir.HistorySopir;
import com.example.drivererte.model.loginFeeder.LoginFeeder;
import com.example.drivererte.model.loginSopir.LoginSopir;
import com.example.drivererte.model.tripFeeder.TripFeeder;
import com.example.drivererte.model.tripSopir.TripSopir;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

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

    @GET("tripSopir/{id_users}")
    Call<TripSopir> tripSopirResponse(
            @Path("id_users") String id_users
    );

    @GET("historySopir/{id_users}")
    Call<HistorySopir> historySopirResponse(
            @Path("id_users") String id_users
    );

    @GET("detailTripSopir/{id_trip}")
    Call<DetailTripSopir> detailTripSopirResponse(
            @Path("id_trip") String id_trip
    );

    @GET("tripFeeder/{id_users_feeder}")
    Call<TripFeeder> tripFeederResponse(
            @Path("id_users_feeder") String id_users_feeder
    );

    @FormUrlEncoded
    @POST("changeStatusFeeder")
    Call<ChangeStatus> changeStatusResponse(
            @Field("id_pesanan") String id_pesanan,
            @Field("id_trip") String id_trip,
            @Field("id_seat") String id_seat,
            @Field("status") Integer status
    );
}
