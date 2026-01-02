package com.example.luxevistaresort;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Dining extends AppCompatActivity {
    private CardView finecard, buffetcard, grillcard, snackcard;


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.dining);
    finecard = findViewById(R.id.dii1);
    buffetcard = findViewById(R.id.dii2);
    grillcard = findViewById(R.id.dii3);
    snackcard = findViewById(R.id.dii4);
    finecard.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Dining.this,FineDining.class);
            startActivity(intent);
        }
    });
    buffetcard.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Dining.this, Buffet.class);
            startActivity(intent);
        }
    });
    grillcard.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Dining.this,Grill.class);
            startActivity(intent);
        }
    });
    snackcard.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Dining.this, Snack.class);
            startActivity(intent);
        }
    });
}
}
