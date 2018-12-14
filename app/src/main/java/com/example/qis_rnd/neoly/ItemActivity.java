package com.example.qis_rnd.neoly;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemActivity extends AppCompatActivity {
    TextView listdata;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        listdata = findViewById(R.id.listdata);
        imageView = findViewById(R.id.imageView);
        Intent intent = getIntent();
        String receivedName =  intent.getStringExtra("name");
        int receivedImage = intent.getIntExtra("image",0);

        listdata.setText(receivedName);
        imageView.setImageResource(receivedImage);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
