package com.example.qis_rnd.neoly;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.qis_rnd.neoly.model.Medicine;
import com.example.qis_rnd.neoly.model.Movie;


import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

    private List<Medicine> movies;
    private int rowLayout;
    private Context context;

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        LinearLayout moviesLayout;
        TextView movieTitle;
        TextView data;
        TextView movieDescription;
        TextView rating;


        public MovieViewHolder(View v) {
            super(v);
           // moviesLayout = (LinearLayout) v.findViewById(R.id.movies_layout);
            movieTitle = (TextView) v.findViewById(R.id.flowerName);
           // data = (TextView) v.findViewById(R.id.flowerCategory);
           // movieDescription = (TextView) v.findViewById(R.id.flowerInstruction);
            rating = (TextView) v.findViewById(R.id.flowerCategory);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    v.getContext().startActivity(new Intent(v.getContext(),MainxActivity.class));
                }
            });
        }
    }

    public MoviesAdapter(List<Medicine> movies, int rowLayout, Context context) {
        this.movies = movies;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public MoviesAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieViewHolder(view);
    }


    @Override
    public void onBindViewHolder(MovieViewHolder holder, final int position) {
        holder.movieTitle.setText(movies.get(position).getPhysicianName());
     //   holder.data.setText(movies.get(position).getReleaseDate());
       // holder.movieDescription.setText(movies.get(position).getOverview());
        holder.rating.setText(movies.get(position).getSpecialtyName());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}