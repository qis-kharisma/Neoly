package com.example.qis_rnd.neoly.Api;

import com.example.qis_rnd.neoly.ModelPostReq.PostKontak;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
    @FormUrlEncoded
    @POST("Med")
    Call<PostKontak> getPosts(@Field("name") String nama, @Field("age") int usia);
}
