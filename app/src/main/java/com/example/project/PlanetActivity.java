package com.example.project;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PlanetActivity extends AppCompatActivity {

    private String name;
    private int distance;
    private int size;
    private int moons;



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
        }

        setTitle(name + ": Facts");

        TextView nameView = findViewById(R.id.textView5);
        nameView.setText(name);
        TextView distanceView = findViewById(R.id.textView6);
        distanceView.setText("Distance from sun: " + distance);
        TextView sizeView = findViewById(R.id.textView7);
        sizeView.setText("Planet size: " + size);
        TextView moonView = findViewById(R.id.textView8);
        moonView.setText("Number of moons: " + moons);



    }
}