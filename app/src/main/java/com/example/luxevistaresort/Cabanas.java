package com.example.luxevistaresort;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Cabanas extends AppCompatActivity {

    private CardView cacard, cabacard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cabana);

            cacard = findViewById(R.id.ca1);
            cabacard = findViewById(R.id.ca2);
            cacard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Cabanas.this,Gardencabana.class);
                    startActivity(intent);
                }
            });
            cabacard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Cabanas.this, Beachcabana.class);
                    startActivity(intent);
                }
            });
    }
}

