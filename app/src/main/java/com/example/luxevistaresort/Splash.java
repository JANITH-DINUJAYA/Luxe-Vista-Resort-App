package com.example.luxevistaresort;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ImageView splashImage = new ImageView(this);
        splashImage.setImageResource(R.drawable.luxevista);
        splashImage.setScaleType(ImageView.ScaleType.CENTER_CROP);

        setContentView(splashImage);


        new Handler().postDelayed(() -> {
            startActivity(new Intent(Splash.this, LoginActivity.class));
            finish();
        }, 2000);
    }
}

