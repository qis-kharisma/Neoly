package com.example.qis_rnd.neoly.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
   public static final String BASE_URL = "http://192.168.90.66/medinfrasAPI/api/physician/";
   private static Retrofit retrofit = null;
////MovieActivity ma= new MovieActivity();

public static Retrofit getClient() {

    if (retrofit==null){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)//.addCallAdapterFactory(smartFactory)
                .addConverterFactory(GsonConverterFactory.create())
                .build();}
    return retrofit;
}
}
