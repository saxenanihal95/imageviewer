package com.example.nsaxena.imageviewer;

/**
 * Created by nsaxena on 5/3/18.
 */

public class Country {
    private int countryRank;
    private String countryName;
    private int countryPopulation;
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

    public int getCountryPopulation() {
        return countryPopulation;
    }

    public void setCountryPopulation(int countryPopulation) {
        this.countryPopulation = countryPopulation;
    }

    public String getCountryFlagImageUrl() {
        return countryFlagImageUrl;
    }

    public void setCountryFlagImageUrl(String countryFlagImageUrl) {
        this.countryFlagImageUrl = countryFlagImageUrl;
    }
}
