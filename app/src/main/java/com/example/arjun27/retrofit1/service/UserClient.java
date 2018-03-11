package com.example.arjun27.retrofit1.service;

import com.example.arjun27.retrofit1.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by arjun27 on 3/10/2018.
 */

public interface UserClient {


    @POST("user")
    Call<User> createAccount(
            @Body User user);
}
