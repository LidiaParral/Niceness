package com.limi.niceness;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.IOException;

public class StorageActivity extends AppCompatActivity  implements  View.OnClickListener{

    private static final int PICK_NAME_REQUEST = 1;
    EditText etName;
    EditText etLastname;
    ImageView ivImage;
    ImageButton btnAdd;
    Button btnSave;

    TextView tvName;
    TextView tvLastname;
    ImageView ivImageShow;

    private Uri uri;
    private StorageReference storageReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);

        etName = findViewById(R.id.etName);
        etLastname = findViewById(R.id.etLastname);
        ivImage = findViewById(R.id.ivImage);

        storageReference = FirebaseStorage.getInstance().getReference();

        tvName = findViewById(R.id.tvNameShow);
        tvLastname = findViewById(R.id.tvLastnameShow);
        ivImageShow = findViewById(R.id.ivImageShow);

        btnAdd = findViewById(R.id.idAddImage);
        btnSave = findViewById(R.id.btnSave);

        btnAdd.setOnClickListener(StorageActivity.this);
        btnSave.setOnClickListener(StorageActivity.this);



    }

    private void showFileAdd(){
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(i,"Selecciona una imagem"), PICK_NAME_REQUEST);
    }

    private void uploadFile(){
        S
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == PICK_NAME_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            uri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                ivImageShow.setImageBitmap(bitmap);
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onClick(View v) {
        if(v == btnAdd){
            showFileAdd();

        } else if(v == btnSave){

        }
    }
}