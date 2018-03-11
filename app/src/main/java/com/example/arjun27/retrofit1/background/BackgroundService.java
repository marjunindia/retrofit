package com.example.arjun27.retrofit1.background;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.example.arjun27.retrofit1.model.User;
import com.example.arjun27.retrofit1.service.UserClient;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by arjun27 on 3/11/2018.
 */

public class BackgroundService extends IntentService {
    public BackgroundService(String name) {
        super("BackgroundService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        User user = new User(
                "arjun","gmail.com",27,null
        );

        OkHttpClient.Builder okhttpBuilder = new OkHttpClient.Builder();
        // create retrofit instance

        Retrofit.Builder builder = new Retrofit.Builder().baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create()).client(okhttpBuilder.build());

        Retrofit retrofit = builder.build();

        // get client & call object for the request
        UserClient client = retrofit.create(UserClient.class);

        Call<User> call=client.createAccount(user);

        try {
            Response<User> result=call.execute(); // syncronous thread work in background thread not in ui thread
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
