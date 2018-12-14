package com.example.qis_rnd.neoly.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.qis_rnd.neoly.JSONPlaceHold.JsonPlaceHolderApi;
import com.example.qis_rnd.neoly.ModelRetro.Post;
import com.example.qis_rnd.neoly.R;
import com.example.qis_rnd.neoly.adapter.MemberListAdapter;
import com.example.qis_rnd.neoly.model.Member;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by docotel on 3/7/16.
 */
public class MemberFragment extends Fragment {
    private CardView crd;
    private RecyclerView listMember;
    private LinearLayoutManager linearLayoutManager;
    private MemberListAdapter memberListAdapter;

    protected Context context;

    public static MemberFragment newInstance(){
        return new MemberFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_member, container, false);

        listMember = (RecyclerView) rootView.findViewById(R.id.listMember);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        linearLayoutManager = new LinearLayoutManager(context);
        memberListAdapter = new MemberListAdapter();

        listMember.setLayoutManager(linearLayoutManager);
        listMember.setAdapter(memberListAdapter);

        loadData();
    }

    private void loadData(){
        List<Member> memberList = new ArrayList<>();
     //   List<Post> memberList = new ArrayList<>();
   Member member;
//        Retrofit retrofit= new Retrofit.Builder().baseUrl("http://192.168.90.119/MedinfrasAPI/api/physician/").addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        JsonPlaceHolderApi jason= retrofit.create(JsonPlaceHolderApi.class);
//

//          String consid= "123456" ;
//          String timestamp= "1541486287" ;
//          String signature= "4m+2qQ6WafQpiNmNRH+0t9xNI8CftM6R9+mKmGUjumc=";
//           String authone =Base64.encodeToString(consid.getBytes(),Base64.DEFAULT);
//           String authtwo =Base64.encodeToString(timestamp.getBytes(),Base64.DEFAULT);
//           String authtri =Base64.encodeToString(signature.getBytes(),Base64.DEFAULT);

    //    Call<Post> call= jason.getPosts (  );
// System.out.println(call);
//        call01.enqueue(new Callback<Post>() {
//            @Override
//            public void onResponse(Call<Post> call, Response<Post> response) {
//
//            }
//
//            @Override
//            public void onFailure(Call<Post> call, Throwable t) {
//                tvhasil.setText(t.getMessage());
//            }
//        });
//        call.enqueue(new Callback<Post>() {
//            @Override
//            public void onResponse(Call<Post> call, Response<Post> response) {
//
//                String konten=" ";
//                Post posts = response.body();
//                String text = posts.page;
//                String total =posts.perPage;
//                List<Post.Datum> datumList = posts.data;
//                //konten+=text+"  "+total;
//                for (Post.Datum post: datumList ){
//
//
//                    konten+= "PhysicianID-   "+ post.PhysicianID+"\n";
//                    konten+= "SpecialtyName- "+ post.SpecialtyName+"\n";
//                    konten+= "PhysicianName- "+ post.PhysicianName+"\n\n\n";
//                    // konten+= "Title-         "+ post.Title+"\n";
//                    //  konten+= "Suffix-        "+ post.Suffix+"\n";
//                    //  konten+= "StreetName-    "+ post.StreetName+"\n";
//                    //  konten+= "Salutation-    "+ post.Salutation+"\n";
//                    //  konten+= "Religion-      "+ post.Religion+"\n";
//                    //  konten+= "PrefferedName- "+ post.PrefferedName+"\n";
//                    //  konten+= "PhysicianCode- "+ post.PhysicianCode+"\n";
//                    //  konten+= "Nationality-   "+ post.Nationality+"\n";
//                    //  konten+= "Mobile2-       "+ post.MobileNo2+"\n";
//                    //  konten+= "Mobile1-       "+ post.MobileNo1+"\n";
//                    // konten+= "MiddleName-    "+ post.MiddleName+"\n";
//                    //  konten+= "MaritalStatus- "+ post.MaritalStatus+"\n";
//                    //  konten+= "LastName-      "+ post.LastName+"\n";
//                    //  konten+= "HomeZipCode-   "+ post.HomeZipCode+"\n";
//                    // konten+= "HomePhone2-    "+ post.HomePhoneNo2+"\n";
//                    //  konten+= "homePhone1-    "+ post.HomePhoneNo1+"\n";
//                    //   konten+= "HomeCity-      "+ post.HomeCity+"\n";
//                    //   konten+= "HomeAddress-   "+ post.HomeAddress+"\n";
//                    //  konten+= "Gender-        "+ post.Gender+"\n";
//                    //  konten+= "FullName-      "+ post.FullName+"\n";
//                    //  konten+= "FirstName-     "+ post.FirstName+"\n";
//                    // konten+= "Email2-        "+ post.EmailAddress2+"\n";
//                    //konten+= "Email1-        "+ post.EmailAddress+"\n";
//                    //konten+= "DateofForma1-  "+ post.DateOfBirthFormat1+"\n";
//                    //konten+= "DOB-           "+ post.DateOfBirth+"\n";
//                    //konten+= "COB-           "+ post.CityOfBirth+"\n\n";
//
//
//                }
//               // tvhasil.       append(konten);
//               // memberListAdapter.addAll( konten);
//
//            }
//
//            @Override
//            public void onFailure(Call<Post> call, Throwable t) {
//               //Toast tvhasil.setText(t.getMessage());
//            }
//        });


        int thumb[] = {R.drawable.patient_male, R.drawable.patient_male, R.drawable.patient_male,
                R.drawable.patient_male, R.drawable.patient_male, R.drawable.patient_male,
                R.drawable.patient_male, R.drawable.patient_male, R.drawable.patient_male,
                R.drawable.patient_male, R.drawable.patient_male, R.drawable.patient_male,
                R.drawable.patient_male, R.drawable.patient_male, R.drawable.patient_male,
                R.drawable.patient_male, R.drawable.patient_male, R.drawable.patient_male,
                R.drawable.patient_male, R.drawable.patient_male};

        String name[] = {"PROMOTION-1", "PROMOTION-2", "PROMOTION-3", "PROMOTION-4",
                "PROMOTION-5", "PROMOTION-6", "PROMOTION-7", "PROMOTION-8",
                "PROMOTION-9", "PROMOTION-10", "PROMOTION-11", "PROMOTION-12",
                "PROMOTION-13", "PROMOTION-14", "PROMOTION-15", "PROMOTION-16",
                "PROMOTION-17", "PROMOTION-18", "PROMOTION-19", "PROMOTION-20"};

        String team = "Team J";

        for(int i=0; i < thumb.length; i++){
            member = new Member();

            member.setId(i+1);
            member.setName(name[i]);
            member.setTeam(team);
            member.setThumb(thumb[i]);
            memberList.add(member);

        }

        memberListAdapter.addAll(memberList);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}