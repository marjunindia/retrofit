package com.example.arjun27.retrofit1.service;

import com.example.arjun27.retrofit1.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by arjun27 on 3/10/2018.
 */

public interface UserClient {

    @Headers({"Cache-Control:max-age=3000",   // static header
    "User-Agent:Android"})
    @POST("user")
    Call<User> createAccount(
            @Header("UserName") String userName,
            @Body User user);
}
