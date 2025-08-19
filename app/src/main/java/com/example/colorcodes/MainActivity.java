package com.example.colorcodes;

import android.os.Bundle;
import android.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ColorAdapter adapter;
    ArrayList<ColorModel> colorList;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        searchView = findViewById(R.id.searchView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        colorList = new ArrayList<>();
        colorList.add(new ColorModel("Red", "#FF0000"));
        colorList.add(new ColorModel("Green", "#00FF00"));
        colorList.add(new ColorModel("Blue", "#0000FF"));
        colorList.add(new ColorModel("Yellow", "#FFFF00"));
        colorList.add(new ColorModel("Black", "#000000"));
        colorList.add(new ColorModel("White", "#FFFFFF"));
        colorList.add(new ColorModel("Purple", "#800080"));
        colorList.add(new ColorModel("Cyan", "#00FFFF"));
        colorList.add(new ColorModel("Orange", "#FFA500"));
        colorList.add(new ColorModel("Pink", "#FFC0CB"));

        adapter = new ColorAdapter(this, colorList);
        recyclerView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) { return false; }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
    }
}
