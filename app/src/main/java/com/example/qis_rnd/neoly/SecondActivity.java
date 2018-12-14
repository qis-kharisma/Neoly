package com.example.qis_rnd.neoly;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.qis_rnd.neoly.Api.ApiService;
import com.example.qis_rnd.neoly.Api.ApiUtils;
import com.example.qis_rnd.neoly.ModelPostReq.PostKontak;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SecondActivity extends AppCompatActivity {
    private ApiService mAPIService;
    public static MainActivity ma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy= new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setContentView(R.layout.activity_second);
        final EditText nama=findViewById(R.id.editTextname);
        final EditText     usia= findViewById(R.id.editTextage);
        Button simpan =findViewById(R.id.buttonsimpan);

        mAPIService = ApiUtils.getAPIService();
        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    sendPost(nama.getText().toString(),Integer.parseInt(usia.getText().toString()));
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }) ;


    }
    public void sendPost (String nama, Integer usia) throws IOException {
        Call<PostKontak> call = mAPIService.getPosts(nama,usia);
        call.enqueue(new Callback<PostKontak>() {
            @Override
            public void onResponse(Call<PostKontak> call, Response<PostKontak> response) {
                Toast.makeText(SecondActivity.this, "Successs",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<PostKontak> call, Throwable t) {
                Toast.makeText(SecondActivity.this, "Failure"+t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

}
