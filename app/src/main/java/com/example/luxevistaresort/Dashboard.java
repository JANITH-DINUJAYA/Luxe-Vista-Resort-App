package com.example.luxevistaresort;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Highlights;
import android.view.View;
import androidx.cardview.widget.CardView;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class Dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private ActionBarDrawerToggle toggle;

    private CardView roomCard, cabanaCard, spaCard, diningCard, tourCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);


        roomCard = findViewById(R.id.room);
        cabanaCard = findViewById(R.id.cabana);
        spaCard = findViewById(R.id.spa);
        diningCard = findViewById(R.id.dining);
        tourCard = findViewById(R.id.ttt);

        roomCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, Rooms.class);
                startActivity(intent);
            }
        });

        cabanaCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, Cabanas.class);
                startActivity(intent);
            }
        });

        spaCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, Spa.class);
                startActivity(intent);
            }
        });

        diningCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, Dining.class);
                startActivity(intent);
            }
        });
        tourCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, Tour.class);
                startActivity(intent);
            }
        });
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull android.view.MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.dash) {
            startActivity(new Intent(this, Dashboard.class));
        } else if (id == R.id.my) {
            startActivity(new Intent(this, BookingActivity.class));
        } else if (id == R.id.ser) {
            startActivity(new Intent(this, ServiceReservationActivity.class));

        } else if (id == R.id.hi) {
            startActivity(new Intent(this, Highlight.class));
        } else if (id == R.id.se) {
            startActivity(new Intent(this, SettingsActivity.class));
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
