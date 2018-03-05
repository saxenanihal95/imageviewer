package com.example.nsaxena.imageviewer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by nsaxena on 5/3/18.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    public List<Country> mCountryList;

    Context mContext;

    public RecyclerAdapter(Context context, List<Country> countryList)
    {
        mCountryList = countryList;
        mContext=context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_image_item,parent,false);
        MyViewHolder myHolder = new MyViewHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Country country = mCountryList.get(position);
        holder.mCountryName.setText(country.getCountryName());
        holder.mPopulation.setText(country.getCountryPopulation());
        holder.mRank.setText(Integer.toString(country.getCountryRank()));
        Glide.with(mContext)
                .load(country.getCountryFlagImageUrl())
                .into(holder.mFlagImage);
    }

    @Override
    public int getItemCount() {
        return mCountryList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView mFlagImage;

        TextView mRank,mPopulation, mCountryName;

        public MyViewHolder(View itemView) {
            super(itemView);

            mFlagImage=itemView.findViewById(R.id.country_flag_image);
            mRank=itemView.findViewById(R.id.country_rank);
            mPopulation=itemView.findViewById(R.id.country_population);
            mCountryName=itemView.findViewById(R.id.country_name);
        }
    }
}
