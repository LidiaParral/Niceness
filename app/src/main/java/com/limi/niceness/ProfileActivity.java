package com.limi.niceness;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class ProfileActivity extends AppCompatActivity  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        BottomNavigationView navigationView = findViewById(R.id.bottom_navigation);

        navigationView.setSelectedItemId(R.id.Profile);

        navigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.Chat:
                    startActivity(new Intent(getApplicationContext(), ChatNavActivity.class));
                    overridePendingTransition(0, 0);
                    return true;
                case R.id.Advert:
                    startActivity(new Intent(getApplicationContext(), AdvertsActivity.class));
                    overridePendingTransition(0, 0);
                    return true;
                case R.id.Maps:
                    startActivity(new Intent(getApplicationContext(), MapsActivity.class));
                    overridePendingTransition(0, 0);
                    return true;
                case R.id.Home:
                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                    overridePendingTransition(0, 0);
                    return true;

            }
            return false;
        });
    }


    public void codeqr(View view) {
        Intent i = new Intent(this, CodeActivity.class);
        startActivity(i);
    }
}