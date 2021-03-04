package com.limi.niceness;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ProfileActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView scannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        BottomNavigationView navigationView = findViewById(R.id.bottom_navigation);

        navigationView.setSelectedItemId(R.id.Profile);

        navigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.Chat:
                    startActivity(new Intent(getApplicationContext(), ChatActivity.class));
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


    public void escanear(View view) {

        scannerView = new ZXingScannerView(this);
        setContentView(scannerView);
        scannerView.setResultHandler(this);
        scannerView.startCamera();

    }

    @Override
    public void handleResult(Result result) {

        Log.v("HandleResult", result.getText());
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Resultado del scan");
        builder.setMessage(result.getText());
        AlertDialog alertDialog = builder.create();
        alertDialog.show();


        scannerView.resumeCameraPreview(this);
    }

    public void codeqr(View view) {
        Intent i = new Intent(this, CodeActivity.class);
        startActivity(i);
    }
}