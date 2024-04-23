package com.example.project;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PlanetActivity extends AppCompatActivity {

    private String name;
    private int distance;
    private int size;
    private int moons;
    private String category;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            name = extras.getString("name");
            distance = extras.getInt("distance");
            size = extras.getInt("size");
            moons = extras.getInt("moons");
            category = extras.getString("category");
        }

        setTitle(name + ": Facts");

        TextView nameView = findViewById(R.id.nameView);
        nameView.setText(name);
        TextView distanceView = findViewById(R.id.locationView);
        distanceView.setText("Distance from sun: " + distance);
        TextView sizeView = findViewById(R.id.sizeView);
        sizeView.setText("Planet size: " + size);
        TextView moonView = findViewById(R.id.moonView);
        moonView.setText("Number of moons: " + moons);
        TextView category = findViewById(R.id.categoryView);
        category.setText("Part of: " + category);



    }
}