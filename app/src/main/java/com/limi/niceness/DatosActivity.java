package com.limi.niceness;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.limi.niceness.javabeans.Item;


public class DatosActivity extends AppCompatActivity {

    ImageView iv;
    TextView tvTit;
    TextView tvDes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_);

        iv = findViewById(R.id.ivDatos);
        tvTit = findViewById(R.id.tvTituloD);
        tvDes = findViewById(R.id.tvDescripcionD);

        Item elem = getIntent().getParcelableExtra(AdvertsActivity.CLAVE_DATOS);

        iv.setImageResource(elem.getIdImagen());
        tvTit.setText(elem.getTitulo());
        tvDes.setText(elem.getDecription());
    }
}