package com.example.qis_rnd.neoly;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class three extends Fragment {
private ImageButton img;
private String num="+62222552080" ;
    public three() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_three, container, false);
        // Inflate the layout for this fragment
        img =root.findViewById(R.id.imageButton);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"+num));
                if(ActivityCompat.checkSelfPermission(getContext(),Manifest.permission.CALL_PHONE)!=PackageManager.PERMISSION_GRANTED){
                    return;
                }
                three.this.startActivity(intent);
            }
        });
        return root;
    }

}
