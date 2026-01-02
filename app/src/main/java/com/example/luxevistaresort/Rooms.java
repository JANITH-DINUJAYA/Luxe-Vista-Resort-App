package com.example.luxevistaresort;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;



public class Rooms extends AppCompatActivity {

    private CardView deluxeroomcard, oceanroomcard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rooms);



        deluxeroomcard = findViewById(R.id.delux);
        oceanroomcard = findViewById(R.id.ocean);
        deluxeroomcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Rooms.this,Deluxe.class);
                startActivity(intent);
            }
        });
        oceanroomcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Rooms.this, Ocean.class);
                startActivity(intent);
            }
        });
    }
}

