package com.example.project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener{
    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=a23carpa";
    RecyclerViewAdapter adapter;
    List<RecyclerItem> jsonPlanets;
    List<RecyclerItem> solarPlanets;
    List<RecyclerItem> externalPlanets;
    private Gson gson;
    SharedPreferences myPreferenceRef;
    SharedPreferences.Editor myPreferenceEditor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Tillfällig data
        ArrayList<RecyclerItem> items = new ArrayList<>();


        adapter = new RecyclerViewAdapter(this, items, new RecyclerViewAdapter.OnClickListener() {
            @Override
            public void onClick(RecyclerItem item) {
                Intent intent = new Intent(MainActivity.this, PlanetActivity.class);
                intent.putExtra("name", item.getName());
                intent.putExtra("distance", item.getDistanceFromSun());
                intent.putExtra("size", item.getSize());
                intent.putExtra("moons", item.getMoonCount());
                intent.putExtra("category", item.getCategory());
                intent.putExtra("image", item.getAuxdata().getImg());

                startActivity(intent);
            }

        });

        myPreferenceRef = getSharedPreferences("pref", MODE_PRIVATE);
        myPreferenceEditor = myPreferenceRef.edit();

        RecyclerView view = findViewById(R.id.recyclerView);
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setAdapter(adapter);

        gson = new Gson();
        new JsonTask(this).execute(JSON_URL);

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
        } else if (item.getItemId() == R.id.menuSortAll){
            sortAll();

        } else if (item.getItemId() == R.id.menuSortSolar){
            sortSolar();

        } else if (item.getItemId() == R.id.menuSortExternal){
            sortExternal();
        }
        return true;
    }

    @Override
    public void onPostExecute(String json) {

        String sort = (myPreferenceRef.getString("Sort", "No Pref"));

        Type type = new TypeToken<List<RecyclerItem>>() {}.getType();
        jsonPlanets = gson.fromJson(json, type);

         if(sort.equals("Solar")){
            sortSolar();
        } else if(sort.equals("External")){
            sortExternal();
        } else {
             jsonPlanets = gson.fromJson(json, type);
             adapter.update(jsonPlanets);
             adapter.notifyDataSetChanged();
         }
    }

    public void sortAll(){
        adapter.update(jsonPlanets);
        adapter.notifyDataSetChanged();
        myPreferenceEditor.putString("Sort", "All");
        myPreferenceEditor.apply();
    }
    public void sortSolar(){
        solarPlanets = new ArrayList<>();
        for(RecyclerItem planet : jsonPlanets){
            if(planet.getCategory().equals("Solar system")){
                solarPlanets.add(planet);
            }
        }
        adapter.update(solarPlanets);
        adapter.notifyDataSetChanged();
        myPreferenceEditor.putString("Sort", "Solar");
        myPreferenceEditor.apply();
    }

    public void sortExternal(){
        externalPlanets = new ArrayList<>();
        for(RecyclerItem planet : jsonPlanets){
            if(planet.getCategory().equals("External")){
                externalPlanets.add(planet);
            }
        }
        adapter.update(externalPlanets);
        adapter.notifyDataSetChanged();
        myPreferenceEditor.putString("Sort", "External");
        myPreferenceEditor.apply();
    }
}
