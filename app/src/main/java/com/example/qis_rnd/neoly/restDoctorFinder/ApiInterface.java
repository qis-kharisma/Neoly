package com.example.qis_rnd.neoly.restDoctorFinder;




import com.example.qis_rnd.neoly.model.DoctorResponse;
import com.example.qis_rnd.neoly.model.SpecialitiesSearchResponse;
import com.example.qis_rnd.neoly.model.models.PreDoctorSearchResponse;

import dimitrovskif.smartcache.SmartCall;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {


    @GET("doctors?")
    SmartCall<PreDoctorSearchResponse> getDoctorList(@Query("query") String query,
                                                     @Query("specialty_uid") String specialtyUid,
                                                     @Query("location") String location,
                                                     @Query("user_location") String userLocation,
                                                     @Query("gender") String gender,
                                                     @Query("skip") String skip,
                                                     @Query("user_key") String userKey);


    @GET("doctors?")
    SmartCall<PreDoctorSearchResponse> getDoctorList(@Query("query") String query,
                                                     @Query("specialty_uid") String specialtyUid,
                                                     @Query("location") String location,
                                                     @Query("user_location") String userLocation,
                                                     @Query("skip") String skip,
                                                     @Query("user_key") String userKey);

    @GET("specialties")
    Call<SpecialitiesSearchResponse> getSpecialities(@Query("user_key") String userKey);


    @GET("doctors/{doctor_uid}")
    Call<DoctorResponse> getDoctorResponse(@Path(value = "doctor_uid", encoded = true) String doctorUid,
                                           @Query("user_key") String userKey);

}
