package com.example.qis_rnd.neoly;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import gr.net.maroulis.library.EasySplashScreen;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EasySplashScreen config =new EasySplashScreen(SplashActivity.this).withFullScreen().withTargetActivity(MainActivity.class).withSplashTimeOut(5000).withBackgroundColor(Color.parseColor("#074E72")).withLogo(R.mipmap.medinfras_logo)
;
   View view = config.create() ;
   setContentView(view);
    }
}
