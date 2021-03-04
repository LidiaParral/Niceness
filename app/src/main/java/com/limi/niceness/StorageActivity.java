package com.limi.niceness;

import android.app.ProgressDialog;
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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;

public class StorageActivity extends AppCompatActivity  implements  View.OnClickListener{

    private static final int PICK_NAME_REQUEST = 1;
    EditText etName;
    EditText etDes;
    ImageView ivImage;
    ImageButton btnAdd;
    Button btnSave;

    TextView tvName;
    TextView tvDes;
    ImageView ivImageShow;

    private Uri uri;
    private StorageReference storageReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);

        etName = findViewById(R.id.etName);
        etDes = findViewById(R.id.etLastname);

        storageReference = FirebaseStorage.getInstance().getReference();

        ivImageShow = findViewById(R.id.ivImageShow);

        btnAdd = findViewById(R.id.idAddImage);
        btnSave = findViewById(R.id.btnSave);

        btnAdd.setOnClickListener(StorageActivity.this);
        btnSave.setOnClickListener(StorageActivity.this);



    }

    private void showFileAdd(){
        Intent i = new Intent();
        i.setType("image/jpeg");
        i.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(i,"Selecciona una imagem"), PICK_NAME_REQUEST);
    }

    private void uploadFile(){
        if(uri != null) {

            ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Subiendo....");
            progressDialog.show();

            final StorageReference refer = storageReference.child(uri.getEncodedPath());

            refer.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    progressDialog.dismiss();
                    Toast.makeText(getApplicationContext(),"Archivo subido",Toast.LENGTH_LONG).show();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    progressDialog.dismiss();
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();

                }
            }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onProgress(UploadTask.TaskSnapshot snapshot) {
                    double progress = (100.0 * snapshot.getBytesTransferred())/snapshot.getTotalByteCount();
                    progressDialog.setMessage(((int) progress) + "% Subiendo...");
                }
            });

        }else{

        }
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
            uploadFile();


        }
    }
}