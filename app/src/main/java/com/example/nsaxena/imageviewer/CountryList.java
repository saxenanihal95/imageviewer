package com.example.nsaxena.imageviewer;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nsaxena on 5/3/18.
 */

public class CountryList {
    @SerializedName("worldpopulation")
    @Expose
    private List<Country> contacts = new ArrayList<>();

    /**
     * @return The contacts
     */
    public List<Country> getContries() {
        return contacts;
    }

    /**
     * @param contacts The contacts
     */
    public void setContries(List<Country> contacts) {
        this.contacts = contacts;
    }
}
