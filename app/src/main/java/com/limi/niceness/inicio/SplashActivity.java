package com.limi.niceness.inicio;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.limi.niceness.MainActivity;
import com.limi.niceness.R;

public class SplashActivity extends AppCompatActivity {
    ImageView imgSaludo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        imgSaludo = findViewById(R.id.imgLogo);

        openApp(true);

        Animation animacion1 = AnimationUtils.loadAnimation(this, R.anim.saludo);

        imgSaludo.setAnimation(animacion1);
    }

    private void openApp(boolean b) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity
                        .this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}