package com.example.nsaxena.imageviewer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;

    List<Country> mCountryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView=findViewById(R.id.recyclerview);

        getCountryData();
    }

    public void getCountryData() {



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.androidbegin.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        APIService apiService = retrofit.create(APIService.class);



        Observable observable = apiService.getMyJSON().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());

        observable.subscribe(new Observer<CountryList>() {

            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(CountryList countryList) {
                mCountryList = new ArrayList<>();
                for (int i =0;i<countryList.getContries().size();i++){

                    Country country = new Country();
                    country.setCountryFlagImageUrl(countryList.getContries().get(i).getCountryFlagImageUrl());
                    country.setCountryName(countryList.getContries().get(i).getCountryName());
                    country.setCountryPopulation(countryList.getContries().get(i).getCountryPopulation());
                    country.setCountryRank(countryList.getContries().get(i).getCountryRank());
                    System.out.print(country.toString());
                    mCountryList.add(country);
                }

                RecyclerAdapter recyclerAdapter = new RecyclerAdapter(getApplicationContext(),mCountryList);
                LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getApplicationContext(),
                        mLayoutManager.getOrientation());
                mRecyclerView.addItemDecoration(dividerItemDecoration);
                mRecyclerView.setLayoutManager(mLayoutManager);
                mRecyclerView.setAdapter(recyclerAdapter);
                recyclerAdapter.subject.subscribe(new Observer<Country>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Country country) {
                        Intent intent=new Intent(getApplicationContext(),CountryDetail.class);
                        intent.putExtra("COUNTRY_TRANSFER",country);
                        startActivity(intent);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }


        });


    }
}
