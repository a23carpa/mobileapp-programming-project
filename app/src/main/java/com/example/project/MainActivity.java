package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Tillfällig data
        ArrayList<RecyclerItem> items = new ArrayList<>(Arrays.asList(
                new RecyclerItem("Earth", 20,30, 1),
                new RecyclerItem("Marse", 10,33, 2),
                new RecyclerItem("Jupiter", 30, 40, 95),
                new RecyclerItem("Jupiter", 30, 40, 95),
                new RecyclerItem("Jupiter", 30, 40, 95),
                new RecyclerItem("Jupiter", 30, 40, 95),
                new RecyclerItem("Jupiter", 30, 40, 95),
                new RecyclerItem("Jupiter", 30, 40, 95),
                new RecyclerItem("Jupiter", 30, 40, 95),
                new RecyclerItem("Earth", 20,30, 1),
                new RecyclerItem("Marse", 10,33, 2),
                new RecyclerItem("Jupiter", 30, 40, 95),
                new RecyclerItem("Jupiter", 30, 40, 95),
                new RecyclerItem("Jupiter", 30, 40, 95),
                new RecyclerItem("Jupiter", 30, 40, 95),
                new RecyclerItem("Jupiter", 30, 40, 95),
                new RecyclerItem("Jupiter", 30, 40, 95),
                new RecyclerItem("Jupiter", 30, 40, 95)
        ));

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, items, new RecyclerViewAdapter.OnClickListener() {
            @Override
            public void onClick(RecyclerItem item) {
                Intent intent = new Intent(MainActivity.this, PlanetActivity.class);
                intent.putExtra("name", item.getName()); // Optional
                intent.putExtra("distance", item.getDistanceFromSun()); // Optional
                intent.putExtra("size", item.getSize()); // Optional
                intent.putExtra("moons", item.getMoonCount()); // Optional
                startActivity(intent);
            }

        });

        RecyclerView view = findViewById(R.id.recyclerView);
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setAdapter(adapter);

    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.app_bar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menuAbout){

            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
        }
        return true;
    }
}
