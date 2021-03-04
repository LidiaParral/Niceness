package com.limi.niceness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.limi.niceness.javabeans.DatosTrekking;
import com.limi.niceness.javabeans.Item;
import com.limi.niceness.javabeans.RecyclerViewAdapter;

public class AdvertsActivity extends AppCompatActivity {

    public static final String CLAVE_DATOS = "DATOS";
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adverts);


        BottomNavigationView navigationView = findViewById(R.id.bottom_navigation);

        navigationView.setSelectedItemId(R.id.Advert);

        navigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.Chat:
                    startActivity(new Intent(getApplicationContext(),ChatActivity.class));
                    overridePendingTransition(0,0);
                    return true;
                case R.id.Home:
                    startActivity(new Intent(getApplicationContext(),HomeActivity.class));
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


        rv = findViewById(R.id.rvListado);


        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));


        final DatosTrekking datos = new DatosTrekking();
        RecyclerViewAdapter ad = new RecyclerViewAdapter(datos.getDatos());
        ad.setListener(v -> {
            int i = rv.indexOfChild(v);
            Item elemento = datos.getDatos().get(i);

            Intent intentDatos = new Intent(getApplicationContext(), DatosActivity.class);
            intentDatos.putExtra(CLAVE_DATOS,elemento);
            startActivity(intentDatos);
        });
        rv.setAdapter(ad);
    }
}