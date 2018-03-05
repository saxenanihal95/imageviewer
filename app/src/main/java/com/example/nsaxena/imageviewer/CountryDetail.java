package com.example.nsaxena.imageviewer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class CountryDetail extends AppCompatActivity {

    TextView countryNameDetail,countryRankDetail,countryPopulationDetail;

    ImageView countryFlagImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_country_detail);

        Intent intent = getIntent();
        Country country = (Country) intent.getSerializableExtra("COUNTRY_TRANSFER");

        countryNameDetail=findViewById(R.id.country_name_detail);
        countryRankDetail=findViewById(R.id.country_rank_detail);
        countryPopulationDetail=findViewById(R.id.country_population_detail);
        countryFlagImage=findViewById(R.id.country_flag_image);

        countryNameDetail.setText(country.getCountryName());
        countryRankDetail.setText(Integer.toString(country.getCountryRank()));
        countryPopulationDetail.setText(country.getCountryPopulation());
        Glide.with(getApplicationContext())
                .load(country.getCountryFlagImageUrl())
                .into(countryFlagImage);
    }
}
