package com.example.nsaxena.imageviewer;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by nsaxena on 5/3/18.
 */

public interface ApiService {
    @GET("/json")
    Observable<List<Country>> getproductdata();
}
