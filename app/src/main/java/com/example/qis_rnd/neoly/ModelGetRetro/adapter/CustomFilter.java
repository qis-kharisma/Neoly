package com.example.qis_rnd.neoly.ModelGetRetro.adapter;

import android.widget.Filter;

import com.example.qis_rnd.neoly.ModelGetRetro.adapter.FlowersAdapter;
import com.example.qis_rnd.neoly.ModelGetRetro.pojo.Flower;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hp on 3/17/2016.
 */
public class CustomFilter extends Filter{

    FlowersAdapter adapter;
    List<Flower> filterList;


    public CustomFilter(List<Flower> filterList, FlowersAdapter adapter)
    {
        this.adapter=adapter;
        this.filterList=filterList;

    }

    //FILTERING OCURS
    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results=new FilterResults();

        //CHECK CONSTRAINT VALIDITY
        if(constraint != null && constraint.length() > 0)
        {
            //CHANGE TO UPPER
            constraint=constraint.toString().toUpperCase();
            //STORE OUR FILTERED PLAYERS
            ArrayList<Flower> filteredPlayers=new ArrayList<>();

            for (int i=0;i<filterList.size();i++)
            {
                //CHECK
                if(filterList.get(i).mName.toUpperCase().contains(constraint))
                {
                    //ADD PLAYER TO FILTERED PLAYERS
                    filteredPlayers.add(filterList.get(i));
                }
            }

            results.count=filteredPlayers.size();
            results.values=filteredPlayers;
        }else
        {
            results.count=filterList.size();
            results.values=filterList;

        }


        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {

       adapter.mFlowers= (List<Flower>) results.values;

        //REFRESH
        adapter.notifyDataSetChanged();
    }
}
