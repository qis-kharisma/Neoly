package com.example.qis_rnd.neoly;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.qis_rnd.neoly.fragments.MemberFragment;

public class CardQueueActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_queue);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("PROMOTION");
        setSupportActionBar(toolbar);
        Fragment fragment = getSupportFragmentManager().findFragmentById(android.R.id.content);
        if(fragment == null){
            fragment = MemberFragment.newInstance();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(android.R.id.content, fragment, "")
                    .commit();

        } else {

            getSupportFragmentManager()
                    .beginTransaction()
                    .attach(fragment)
                    .commit();

        }
    }
}
