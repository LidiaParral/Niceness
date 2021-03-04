package com.limi.niceness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    Button btnExpT;
    Button btnExpTe;
    Button btnExpM;
    Button btnExpF;
    Button btnExpH;
    Button btnExpA;


    ExpandableRelativeLayout mycontext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnExpT = findViewById(R.id.btnViewDetailsT);
        btnExpTe = findViewById(R.id.btnViewDetailsTe);
        btnExpM = findViewById(R.id.btnViewDetailsM);
        btnExpF = findViewById(R.id.btnViewDetailsF);
        btnExpH = findViewById(R.id.btnViewDetailsH);
        btnExpA = findViewById(R.id.btnViewDetailsAnimals);




        BottomNavigationView navigationView = findViewById(R.id.bottom_navigation);

        navigationView.setSelectedItemId(R.id.Home);

        navigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.Chat:
                    startActivity(new Intent(getApplicationContext(),ChatActivity.class));
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

    public void DetailsTrekking(View view) {
        mycontext = findViewById(R.id.expandable);
        mycontext.toggle();

        Intent i = new Intent(this, AdvertsActivity.class);
        startActivity(i);


    }

    public void DetailsTecnology(View view) {
        mycontext = findViewById(R.id.expandable1);
        mycontext.toggle();

        Intent i = new Intent(this, MainActivity3.class);
        startActivity(i);

    }


    public void DetailsMusic(View view) {
        mycontext = findViewById(R.id.expandable2);
        mycontext.toggle();

        Intent i = new Intent(this, MainActivity6.class);
        startActivity(i);
    }

    public void DetailsFood(View view) {
        mycontext = findViewById(R.id.expandable3);
        mycontext.toggle();

        Intent i = new Intent(this, MainActivity4.class);
        startActivity(i);
    }


    public void DetailsHome(View view) {
        mycontext = findViewById(R.id.expandable4);
        mycontext.toggle();

        Intent i = new Intent(this, MainActivity7.class);
        startActivity(i);
    }

    public void DetailsAnimal(View view) {
        mycontext = findViewById(R.id.expandable5);
        mycontext.toggle();

        Intent i = new Intent(this, MainActivity5.class);
        startActivity(i);
    }
}