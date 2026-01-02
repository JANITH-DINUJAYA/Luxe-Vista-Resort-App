package com.example.luxevistaresort;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Highlight extends AppCompatActivity {

    private CardView offercard, recommedcard, watercard, guidecard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.highlights);

        offercard= findViewById(R.id.iii1);
        recommedcard = findViewById(R.id.iii2);
        watercard = findViewById(R.id.iii3);
        guidecard= findViewById(R.id.iii4);
        offercard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Highlight.this,Offers.class);
                startActivity(intent);
            }
        });
        recommedcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Highlight.this, Guide.class);
                startActivity(intent);
            }
        });
        watercard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Highlight.this,Water.class);
                startActivity(intent);
            }
        });
        guidecard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Highlight.this, Recommendations.class);
                startActivity(intent);
            }
        });
    }
}
