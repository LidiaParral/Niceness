package com.limi.niceness;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.limi.niceness.inicio.LoginActivity;
import com.limi.niceness.javabeans.Item;


public class DatosActivity extends AppCompatActivity {

    ImageView iv;
    TextView tvTit;
    TextView tvDes;
    FirebaseUser user;
    EditText etEmail;
    EditText etPassword;


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

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);

    }

    public void add(View view) {
        Intent i = new Intent(DatosActivity.this, StorageActivity.class);
        startActivity(i);

    }

}