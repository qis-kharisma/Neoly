package com.example.qis_rnd.neoly;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
   private EditText edtxt;
   private EditText edtxt1;
   private Button btn,btn4;
   private TextView tvinfo;
   private TextView tvback;
   private int count=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    edtxt=findViewById(R.id.editText);
    edtxt1=findViewById(R.id.editText2);
    btn=findViewById(R.id.button);
    btn4=findViewById(R.id.button4);
    tvinfo=findViewById(R.id.textView2);
        tvinfo.setText("No of attempts remaining : 5");
        tvback=findViewById(R.id.textViewbelum);
        tvback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, RegisterActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,TabActivity.class);

                startActivity(intent);
            }
        });
    btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        validasi(edtxt.getText().toString(),edtxt1.getText().toString());
    }
});

    }
private void validasi (String username,String password){
        if((username.equals("andi@andi.com"))&&(password.equals("zhaoyun"))){
            Intent intent= new Intent(MainActivity.this,TabActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intent.putExtra("state", "success");
            startActivity(intent);
        }else {
            count--;
            tvinfo.setText("No of attempts remaining : "+ String.valueOf(count));
            if (count==0){
               // btn.setEnabled(false);
               Intent intent=new Intent(MainActivity.this,BridgeActivity.class);
               startActivity(intent);

            }
        }
}

}
