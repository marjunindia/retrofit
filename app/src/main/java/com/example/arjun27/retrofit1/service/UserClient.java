package com.example.arjun27.retrofit1.service;

import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by arjun27 on 3/10/2018.
 */

public interface UserClient {

    @FormUrlEncoded
    @POST("feedback/")
    Call<ResponseBody> sendUserFeedback(
            @Field("name") String name,
            @Field("email") String email,
            @Field("age") String age,
            @Field("topics") List<String> topics
    );

    @FormUrlEncoded
    @POST("feedback/")
    Call<ResponseBody> sendUserFeedback(
            @FieldMap Map<String, Object> map,
            @Field("topics") List<String> topics

    );

}