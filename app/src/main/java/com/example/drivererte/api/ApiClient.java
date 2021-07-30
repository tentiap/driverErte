package com.example.drivererte.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
//    private static final String BASE_URL = "http://172.20.10.11:8000/api/";
//    private static final String BASE_URL = "http://10.44.10.245:8000/api/";
    private static final String BASE_URL = "http://192.168.43.201:8000/api/";
//    private static final String BASE_URL = "http://192.168.100.8:8000/api/";
//    private static final String BASE_URL = "http://192.168.43.201:8000/api/";
//private static final String BASE_URL = "http://10.44.10.229:8000/api/";


    private static Retrofit retrofit;

    public static Retrofit getClient() {
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
