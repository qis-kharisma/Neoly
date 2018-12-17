package com.example.qis_rnd.neoly;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ViewFlipper;



/**
 * A simple {@link Fragment} subclass.
 */
public class one  extends Fragment {
    private ImageButton txt3;
    private ViewFlipper viewflip;
    private ImageButton ibd;
    private CardView cdr1,cdr2,cdr3;

    public one() {
        // Required empty public constructor
    }
TabActivity tab= new TabActivity();

    public void Flipper(int image){
        ImageView imageview =new ImageView(getContext());
        imageview.setBackgroundResource(image);
        viewflip.addView(imageview);
        viewflip.setFlipInterval(4000);
        viewflip.setAutoStart(true);
        viewflip.setInAnimation(getContext(), android.R.anim.slide_in_left);
        viewflip.setOutAnimation(getContext(), android.R.anim.slide_out_right);
    }
    @Override
    public View onCreateView(LayoutInflater inflater,  @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_one, container, false);
        int image []={R.drawable.medinfras_bg_ori,R.drawable.medinfras_logo};
     viewflip=root.findViewById(R.id.viewflip);
     for (int i=0;i<image.length;i++){
            Flipper(image[i]);
//
        }
  cdr1=root.findViewById(R.id.btn_create_event);
  cdr1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          Intent intent=new Intent(one.this.getActivity(), SearchActivity.class);
          one.this.startActivity(intent);
      }
  });
        cdr2=root.findViewById(R.id.btn_create_event0);
        cdr2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getActivity().getIntent().hasExtra("state")){
                    if (getActivity()
                            .getIntent().getStringExtra("state").equals("success")){
                        Intent intent = new Intent(one.this.getActivity(),MainxActivity.class);
                        startActivity(intent);

                    }else{
                        ibd.setEnabled(false);
                    }
                }
            }
        });
        cdr3=root.findViewById(R.id.btn_create_event1);
        cdr3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent igt =new Intent(one.this.getActivity(), CardQueueActivity.class);
                startActivity(igt);
            }
        });
        return root;
    }

}
