package com.example.arjun27.retrofit1.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by arjun27 on 3/10/2018.
 */

public  class GitHubRepo {

    @SerializedName("name")
    @Expose
    private String name;

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
