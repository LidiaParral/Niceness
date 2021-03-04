package com.limi.niceness.inicio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.limi.niceness.R;

public class RestPasswordActivity extends AppCompatActivity {

    EditText emailReset;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest_password);

        emailReset = findViewById(R.id.etResetPassword);
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public void reset(View view) {
        String email = emailReset.getText().toString().trim();

        if (email.equals("")){
            Toast.makeText(RestPasswordActivity.this, getString(R.string.msg_data_reset), Toast.LENGTH_LONG).show();
        } else {
            firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {

                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(RestPasswordActivity.this, getString(R.string.msg_revision), Toast.LENGTH_LONG).show();
                        startActivity(new Intent(RestPasswordActivity.this, LoginActivity.class));
                    } else {
                        String error = task.getException().getMessage();
                        Toast.makeText(RestPasswordActivity.this, error, Toast.LENGTH_LONG).show();
                    }
                }
            });

        }
    }
}