package com.example.android.comeback;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] titles = getResources().getStringArray(R.array.stories_titles);
        String[] contents = getResources().getStringArray(R.array.stories_contents);

        rv = findViewById(R.id.storiesListView);
        rv.setLayoutManager(new LinearLayoutManager(this));

        adapter = new Adapter(this,titles,contents);
        rv.setAdapter(adapter);

    }
}