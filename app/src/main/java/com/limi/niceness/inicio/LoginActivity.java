package com.limi.niceness.inicio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.limi.niceness.HomeActivity;
import com.limi.niceness.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText etEmail;
    TextInputEditText etPassword;
    TextView tvResetPass;

    private FirebaseAuth fba;

    MaterialButton btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvResetPass = findViewById(R.id.tvResetPassword);

        fba = FirebaseAuth.getInstance();
    }

    public void signUp(View view) {
        Intent i = new Intent(this, SignUpActivity.class);
        startActivity(i);
    }

    public void login(View view) {
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, getString(R.string.msg_no_data),
                    Toast.LENGTH_LONG).show();
        } else {
            fba.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Intent intent = new Intent(LoginActivity.this, HomeActivity.class); //Reedireccionar a la pagina que haya que enviar los datos
                                //esto es para que cuando le demos al boton de volver desaparezca el login y no vuelva nos aparezca nunca más
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(LoginActivity.this,  getString(R.string.msj_no_accede), Toast.LENGTH_LONG).show();
                            }
                        }
                    });
            }
        }


    public void restablecer(View view) {
        Intent i = new Intent(this, RestPasswordActivity.class);
        startActivity(i);
    }
}