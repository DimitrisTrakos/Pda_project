package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button btnSignIn;
    ImageView logoPablo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSignIn =(Button)findViewById(R.id.btnSignIn);
        logoPablo=(ImageView)findViewById(R.id.logoPablo);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

            }


        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signIn =new Intent(MainActivity.this,LoginActivity.class);
                startActivity(signIn);

            }
        });



    }
}