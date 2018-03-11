package com.example.arjun27.retrofit1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit.Builder builder = new Retrofit.Builder().baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        GitHubClient gitHubClient = retrofit.create(GitHubClient.class);

        Call<List<GitHubRepo>> call = gitHubClient.reposforuser("fs-opensource");

        call.enqueue(new Callback<List<GitHubRepo>>() {
            @Override
            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
                List<GitHubRepo> gitHubRepos = response.body();
                Log.d(TAG, "onResponse: " + response.body());


                if (response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "" + response.body(), Toast.LENGTH_SHORT).show();
                } else {
                    // calls when somethiing wrong in the response
                    Toast.makeText(MainActivity.this, ""+response.errorBody().toString(), Toast.LENGTH_SHORT).show();

                   /* switch (response.code()) {
                        case 404:
                            Toast.makeText(MainActivity.this, "user  not found", Toast.LENGTH_SHORT).show();
                            break;
                        case 500:
                            Toast.makeText(MainActivity.this, "server is broken", Toast.LENGTH_SHORT).show();

                            break;
                        default:
                            Toast.makeText(MainActivity.this, "unknown error", Toast.LENGTH_SHORT).show();

                    }*/

                    
                }
            }

            @Override
            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {

                // calls when no internet

                Toast.makeText(MainActivity.this, "No internet", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
