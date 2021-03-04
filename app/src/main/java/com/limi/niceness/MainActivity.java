package com.limi.niceness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.limi.niceness.inicio.LoginActivity;
import com.limi.niceness.inicio.SignUpActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void signUpM(View view) {
        Intent i = new Intent(MainActivity.this, SignUpActivity.class);
        startActivity(i);
    }

    public void loginM(View view) {
        Intent i2 = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(i2);
    }
}