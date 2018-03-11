package com.example.arjun27.retrofit1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.arjun27.retrofit1.background.BackgroundService;
import com.example.arjun27.retrofit1.model.User;

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
                User user = new User(
                        name.getText().toString(),
                        email.getText().toString(),
                        Integer.parseInt(age.getText().toString()),
                        topics.getText().toString().split(",")
                );
                sendNetworkRequest(user);

            }
        });


    }

    private void sendNetworkRequest(User user) {
        Intent intent=new Intent(MainActivity.this, BackgroundService.class);
        startService(intent);
    }

}
