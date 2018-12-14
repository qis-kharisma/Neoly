package com.example.qis_rnd.neoly.ModelGetRetro.api;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Filippo-TheAppExpert on 9/2/2015.
 */
public interface FlowerApi {

    @GET("/kharismax/api/Med")
    void getFlowers(Callback<String> flowers);
}
