package com.example.qis_rnd.neoly.JSONPlaceHold;

import com.example.qis_rnd.neoly.ModelRetro.Post;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface JsonPlaceHolderApi {
    @Headers({
             "Content-Type: application/json",
             "X-cons-id: 123456",
             "X-timestamp: 1541486287",
             "X-signature: 4m+2qQ6WafQpiNmNRH+0t9xNI8CftM6R9+mKmGUjumc="
    })
    @GET("list")
    Call<Post> getPosts();
    @GET("list/sid/002")
    Call<Post> getPosts01();
    @GET("list/hsu/21")
    Call<Post> getPosts02();
    @GET("list/pid/30")
    Call<Post> getPosts03();
    @GET("list/apm/60")
    Call<Post> getPosts04();


}
