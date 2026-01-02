package com.example.luxevistaresort;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Spa extends AppCompatActivity {
    private CardView aromacard, ayurvediccard, hotstonecard, oceandetoxcard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spa);
        aromacard = findViewById(R.id.sp1);
        hotstonecard = findViewById(R.id.sp2);
        ayurvediccard = findViewById(R.id.sp3);
        oceandetoxcard = findViewById(R.id.sp4);
        aromacard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Spa.this,Aroma.class);
                startActivity(intent);
            }
        });
        hotstonecard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Spa.this, Hotstone.class);
                startActivity(intent);
            }
        });
        ayurvediccard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Spa.this,Ayurvedic.class);
                startActivity(intent);
            }
        });
        oceandetoxcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Spa.this, Oceandetox.class);
                startActivity(intent);
            }
        });

    }
}


