package com.limi.niceness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);


        BottomNavigationView navigationView = findViewById(R.id.bottom_navigation);

        navigationView.setSelectedItemId(R.id.Chat);

        navigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.Home:
                    startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                    overridePendingTransition(0,0);
                    return true;
                case R.id.Advert:
                    startActivity(new Intent(getApplicationContext(),AdvertsActivity.class));
                    overridePendingTransition(0,0);
                    return true;
                case R.id.Maps:
                    startActivity(new Intent(getApplicationContext(),MapsActivity.class));
                    overridePendingTransition(0,0);
                    return true;
                case R.id.Profile:
                    startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                    overridePendingTransition(0,0);
                    return true;

            }
            return false;
        });
    }
}