package com.example.qis_rnd.neoly.controller;

import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.example.qis_rnd.neoly.ModelGetRetro.api.RestApiManager;
import com.example.qis_rnd.neoly.ModelGetRetro.pojo.Flower;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


import static android.content.Context.CONNECTIVITY_SERVICE;

/**
 * Created by Filippo-TheAppExpert on 9/2/2015.
 */
public class Controller {

    private static final String TAG = Controller.class.getSimpleName();
    private FlowerCallbackListener mListener;
    private RestApiManager mApiManager;
    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sharedPrefs;
    SharedPreferences.Editor editor;
    public Controller(FlowerCallbackListener listener) {
        mListener = listener;
        mApiManager = new RestApiManager();
    }

    public void startFetching() {
//        realm.init(this);
//        realmConfiguration = new RealmConfiguration.Builder().build();
//        realm = Realm.getInstance(realmConfiguration);
//        RealmResults<Flower> movie = realm.where(Flower.class).findAll();
        mApiManager.getFlowerApi().getFlowers(new Callback<String>() {

            @Override
            public void success(String s, Response response) {
                Log.d(TAG, "JSON :: " + s);
           //  s=  sharedPrefs.getString("list", null);
                try {
                    JSONArray array = new JSONArray(s);

                    for(int i = 0; i < array.length(); i++) {
                        JSONObject object = array.getJSONObject(i);

                        Flower flower = new Flower.Builder()
                               // .setCategory(object.getString("category"))
                                .setPrice(object.getInt("age"))
                                //.setInstructions(object.getString("instructions"))
                              //  .setPhoto(object.getString("photo"))
                                .setName(object.getString("name"))
                                .setProductId(object.getInt("id"))
                                .build();

                        mListener.onFetchProgress(flower);

//                        array.put(object);
//                        editor.putString("list", array.toString());
//                        editor.commit();


                    }

                } catch (JSONException e) {
                    mListener.onFetchFailed();
                }


                mListener.onFetchComplete();
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d(TAG, "Error :: " + error.getMessage());
                mListener.onFetchComplete();
            }
        });
    }

    public interface FlowerCallbackListener {

        void onFetchStart();
        void onFetchProgress(Flower flower);
        void onFetchProgress(List<Flower> flowerList);
        void onFetchComplete();
        void onFetchFailed();
    }

}
