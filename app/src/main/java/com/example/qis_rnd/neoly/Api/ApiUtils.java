package com.example.qis_rnd.neoly.Api;

import com.example.qis_rnd.neoly.RetrofitClient.RetrofitClient;

public class ApiUtils {
    private ApiUtils() {}

    public static final String BASE_URL = "http://192.168.90.132/kharismax/api/";

    public static ApiService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(ApiService.class);
    }
}
