package com.limi.niceness;


import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    EditText etLoc;
    private GoogleMap map;
    private Button btnSatelite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        etLoc = findViewById(R.id.etLoc);

        BottomNavigationView navigationView = findViewById(R.id.bottom_navigation);

        navigationView.setSelectedItemId(R.id.Maps);

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
                case R.id.Home:
                    startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                    overridePendingTransition(0,0);
                    return true;
                case R.id.Profile:
                    startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                    overridePendingTransition(0,0);
                    return true;

            }
            return false;
        });


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        btnSatelite = findViewById(R.id.btnSatelite);

        btnSatelite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

            }
        });

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        map = googleMap;

        Antut(googleMap);

    }

    private void Antut(GoogleMap googleMap) {
        map = googleMap;

        final LatLng punto1 = new LatLng(40.4190531, -3.69361943);
        final LatLng punto2 = new LatLng(25.4190531, -3.69361943);
        map.addMarker(new MarkerOptions().position(punto1).title("Madrid-España").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        map.addMarker(new MarkerOptions().position(punto1).title("Punto 2").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));
    }


    public void buscar(View view) {

        LatLng LatLng = new LatLng(40.4190531, -3.69361943);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng,20));
        map.getFocusedBuilding();
        map.setTrafficEnabled(true);
        map.setBuildingsEnabled(true);
    }
}