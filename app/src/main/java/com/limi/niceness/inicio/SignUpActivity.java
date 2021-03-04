package com.limi.niceness.inicio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.limi.niceness.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class SignUpActivity extends AppCompatActivity {

    TextInputEditText etNombe;
    TextInputEditText etEmail;
    TextInputEditText etPassword;


    private FirebaseAuth  fba;
    private FirebaseUser firebaseUser;

    MaterialButton btnSignUp;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etNombe = findViewById(R.id.etNombre);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnSignUp = findViewById(R.id.btnSignS);

        fba = FirebaseAuth.getInstance();
    }

    public void loginS(View view) {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }

    public void signUpS(View view) {

        String user = etNombe.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        if (email.isEmpty() || password.isEmpty() || user.isEmpty()) {
            Toast.makeText(this, getString(R.string.msg_no_data),
                    Toast.LENGTH_LONG).show();
        } else if (password.length()< 6){
            Toast.makeText(this, getString(R.string.msg_pass), Toast.LENGTH_LONG).show();
        } else {
            registroUser(user, email, password);
        }
    }

    private void registroUser(final String username, String emails, String pass) {

        fba.signInWithEmailAndPassword(emails, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){

                            firebaseUser = fba.getCurrentUser();

                            Intent intent = new Intent(SignUpActivity.this, LoginActivity.class); //Reedireccionar a la pagina que haya que enviar los datos
                            //esto es para que cuando le demos al boton de volver desaparezca el login y no vuelva nos aparezca nunca más
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                            finish();
                            etPassword.setText("");
                            etNombe.setText("");
                            etEmail.setText("");
                            Toast.makeText(SignUpActivity.this, getString(R.string.msj_registrado), Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(SignUpActivity.this, getString(R.string.msj_no_registrado) + "\n" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();// el getString se usa para cuando queramos concatenar más cosas
                        }
                    }
                });
    }
}