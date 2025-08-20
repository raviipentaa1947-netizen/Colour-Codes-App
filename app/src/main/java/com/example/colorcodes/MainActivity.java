package com.example.colorscodes;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ColorAdapter adapter;
    private List<ColorModel> colorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        colorList = new ArrayList<>();
        colorList.add(new ColorModel("Red", "#F44336"));
        colorList.add(new ColorModel("Pink", "#E91E63"));
        colorList.add(new ColorModel("Purple", "#9C27B0"));
        colorList.add(new ColorModel("Deep Purple", "#673AB7"));
        colorList.add(new ColorModel("Indigo", "#3F51B5"));
        colorList.add(new ColorModel("Blue", "#2196F3"));
        colorList.add(new ColorModel("Light Blue", "#03A9F4"));
        colorList.add(new ColorModel("Cyan", "#00BCD4"));
        colorList.add(new ColorModel("Teal", "#009688"));
        colorList.add(new ColorModel("Green", "#4CAF50"));
        colorList.add(new ColorModel("Lime", "#CDDC39"));
        colorList.add(new ColorModel("Yellow", "#FFEB3B"));
        colorList.add(new ColorModel("Orange", "#FF9800"));
        colorList.add(new ColorModel("Deep Orange", "#FF5722"));
        colorList.add(new ColorModel("Brown", "#795548"));
        colorList.add(new ColorModel("Gray", "#9E9E9E"));
        colorList.add(new ColorModel("Black", "#000000"));
        colorList.add(new ColorModel("White", "#FFFFFF"));

        adapter = new ColorAdapter(colorList);
        recyclerView.setAdapter(adapter);

        SearchView searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.filter(newText);
                return false;
            }
        });
    }
}
