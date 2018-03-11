package com.example.arjun27.retrofit1.service;

import com.example.arjun27.retrofit1.model.User;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by arjun27 on 3/10/2018.
 */

public interface UserClient {

    @POST("user")
    Call<User> createAccount(@Body User user);

    @GET
    Call<ResponseBody> getUSerProfilePhoto(@Url String url);
}
