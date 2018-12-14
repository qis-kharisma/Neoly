package com.example.qis_rnd.neoly.ModelGetRetro.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.qis_rnd.neoly.MainxActivity;
import com.example.qis_rnd.neoly.ModelGetRetro.pojo.Flower;
import com.example.qis_rnd.neoly.R;

import java.util.List;

public class FlowersAdapter extends RecyclerView.Adapter<FlowersAdapter.Holder> implements Filterable {

    public static String TAG = FlowersAdapter.class.getSimpleName();
   //Context ctx;
   List<Flower> mFlowers,filterList;
 CustomFilter flowers;
    public FlowersAdapter(List<Flower> tflowers) {
        mFlowers = tflowers;
        filterList=tflowers;
    }
//    public static final String mypreference = "mypref";
//    SharedPreferences sharedpreferences;
//    public static final String Name = "nameKey";
//    public static final String Email = "emailKey";
//    Context c;
//    ArrayList<Player> players,filterList;
//    CustomFilter filter;
//
//
//    public MyAdapter(Context ctx,ArrayList<Player> players)
//    {
//        this.c=ctx;
//        this.players=players;
//        this.filterList=players;
//    }


   public void addFlower(Flower flower) {
        mFlowers.add(flower);
        notifyDataSetChanged();
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);

        return new Holder(row);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

        Flower currentFlower = mFlowers.get(position);
        holder.mName.setText(currentFlower.mName);
     //   holder.mCategory.setText(currentFlower.mCategory);
        holder.mPrice.setText(Integer.toString(currentFlower.mPrice));
       // holder.mInstructions.setText(currentFlower.mInstructions);

      //  Picasso.with(holder.itemView.getContext()).load(Constants.PHOTO_URL + currentFlower.mPhoto).into(holder.mImage);
    }

    @Override
    public int getItemCount() {
        return mFlowers.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        public TextView mName, mCategory, mPrice, mInstructions;
        public ImageView mImage;

        public Holder(View itemView) {
            super(itemView);
            // mImage = (ImageView) itemView.findViewById(R.id.flowerImage);
            mName = (TextView) itemView.findViewById(R.id.flowerName);
            // mCategory = (TextView) itemView.findViewById(R.id.flowerCategory);
            mPrice = (TextView) itemView.findViewById(R.id.flowerPrice)
            ;         // mInstructions = (TextView) itemView.findViewById(R.id.flowerInstruction);
            //sharePreference.
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    v.getContext().startActivity(new Intent(v.getContext(),MainxActivity.class));
                }
            });
//            sharedpreferences = getSharedPreferences(mypreference,
//                    Context.MODE_PRIVATE);
//            if (sharedpreferences.contains(Name)) {
//                mName.setText(sharedpreferences.getString(Name, ""));
//            }
//            if (sharedpreferences.contains(Email)) {
//                mPrice.setText(sharedpreferences.getString(Email, ""));
//            }

        }
    }
    @Override
    public Filter getFilter() {
        if(flowers==null)
        {
            flowers=new  CustomFilter(filterList,this);
        }

        return flowers;
    }
    public SharedPreferences getSharedPreferences(String mypreference, int modePrivate) {
        throw new RuntimeException("Stub!");
    }

}
