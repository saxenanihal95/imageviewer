package com.example.nsaxena.imageviewer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by nsaxena on 5/3/18.
 */

public class Country implements Serializable{

    private static final long serialVersionUID=1L;

    @SerializedName("rank")
    @Expose
    private int countryRank;

    @SerializedName("country")
    @Expose
    private String countryName;

    @SerializedName("population")
    @Expose
    private String countryPopulation;


    @SerializedName("flag")
    @Expose
    private String countryFlagImageUrl;

    public int getCountryRank() {
        return countryRank;
    }

    public void setCountryRank(int countryRank) {
        this.countryRank = countryRank;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryPopulation() {
        return countryPopulation;
    }

    public void setCountryPopulation(String countryPopulation) {
        this.countryPopulation = countryPopulation;
    }

    public String getCountryFlagImageUrl() {
        return countryFlagImageUrl;
    }

    public void setCountryFlagImageUrl(String countryFlagImageUrl) {
        this.countryFlagImageUrl = countryFlagImageUrl;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryRank=" + countryRank +
                ", countryName='" + countryName + '\'' +
                ", countryPopulation='" + countryPopulation + '\'' +
                ", countryFlagImageUrl='" + countryFlagImageUrl + '\'' +
                '}';
    }
}
