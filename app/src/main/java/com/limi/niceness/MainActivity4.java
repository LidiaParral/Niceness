package com.limi.niceness;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.limi.niceness.javabeans.DatosFood;
import com.limi.niceness.javabeans.Item;
import com.limi.niceness.javabeans.RecyclerViewAdapter;

public class MainActivity4 extends AppCompatActivity {

    public static final String CLAVE_DATOS = "DATOS";
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adverts);

        rv = findViewById(R.id.rvListado);


        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));

        final DatosFood datos = new DatosFood();
        RecyclerViewAdapter ad = new RecyclerViewAdapter(datos.getDatos());
        ad.setListener(v -> {
            int i = rv.indexOfChild(v);
            Item elemento = datos.getDatos().get(i);

            Intent intentDatos = new Intent(getApplicationContext(), DatosActivity.class);
            intentDatos.putExtra(CLAVE_DATOS, elemento);
            startActivity(intentDatos);
        });
        rv.setAdapter(ad);

    }
}