package com.example.nsaxena.imageviewer;

import io.reactivex.Observable;
import retrofit2.Callback;
import retrofit2.http.GET;

/**
 * Created by nsaxena on 5/3/18.
 */

public interface APIService {
    @GET("tutorial/jsonparsetutorial.txt")
    Observable<CountryList> getMyJSON();
}
