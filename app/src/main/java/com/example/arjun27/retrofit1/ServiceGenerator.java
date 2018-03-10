package com.example.arjun27.retrofit1;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by arjun27 on 3/10/2018.
 */

public class ServiceGenerator {

    private static Retrofit.Builder builder = new Retrofit.Builder().baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = builder.build();

    private static HttpLoggingInterceptor loggingInterceptor=new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    private static OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();

    //    use only in github
    //    public static GitHubClient createService(){
    //         return retrofit.create(GitHubClient.class);
    //    }

    // dynamic use in all class
    public static <S> S createService(Class<S> serviceClass) {

        if (!httpClientBuilder.interceptors().contains(loggingInterceptor)) {
            httpClientBuilder.addInterceptor(loggingInterceptor);
            builder = builder.client(httpClientBuilder.build());
            retrofit = builder.build();
        }
        return retrofit.create(serviceClass);
    }
}
