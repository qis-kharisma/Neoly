package com.example.qis_rnd.neoly.rest;

import com.example.qis_rnd.neoly.model.MedicineResponse;
import com.example.qis_rnd.neoly.model.Movie;


import java.util.List;

import dimitrovskif.smartcache.SmartCall;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("list")
    SmartCall<MedicineResponse> getTopRatedMovies();


}
