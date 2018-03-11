package com.example.arjun27.retrofit1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.arjun27.retrofit1.service.UserClient;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    EditText name, email, age, topics;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.editText);
        email = (EditText) findViewById(R.id.editText2);
        age = (EditText) findViewById(R.id.editText3);
        topics = (EditText) findViewById(R.id.editText4);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendNetworkRequest(
                        name.getText().toString(),
                        email.getText().toString(),
                        age.getText().toString(),
                        topics.getText().toString()
                );


            }
        });


    }

    private void sendNetworkRequest(String name, String email, String age, String topics) {

        Retrofit.Builder builder = new Retrofit.Builder().baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        // get client & call object for the request
        UserClient client = retrofit.create(UserClient.class);


        // send separate field
        // Call<ResponseBody> call=client.sendUserFeedback(name,email,age, Arrays.asList(topics.split(",")));

        Map<String, Object> map = new HashMap<>();
        map.put("name", name);

        if (TextUtils.isEmpty(email)) {
            map.put("email", email);
        }

        map.put("age", age);

        // send objects
        Call<ResponseBody> call = client.sendUserFeedback(map, Arrays.asList(topics.split(",")));


        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Toast.makeText(MainActivity.this, "success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
            }
        });


    }

}
