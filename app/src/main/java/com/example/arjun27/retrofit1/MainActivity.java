package com.example.arjun27.retrofit1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       GitHubClient gitHubClient=ServiceGenerator.createService(GitHubClient.class);

        Call<List<GitHubRepo>> call=gitHubClient.reposforuser("fs-opensource");

        call.enqueue(new Callback<List<GitHubRepo>>() {
            @Override
            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
                   List<GitHubRepo> gitHubRepos=response.body();
                Log.d(TAG, "onResponse: "+ gitHubRepos.toString());
            }

            @Override
            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {

            }
        });

    }
}
