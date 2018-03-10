package com.example.arjun27.retrofit1.service;

import com.example.arjun27.retrofit1.model.GitHubRepo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by arjun27 on 3/10/2018.
 */

public interface GitHubClient {

    @GET("/users/{user}/repos")
    Call<List<GitHubRepo>> reposforuser(@Path("user") String user);

}
