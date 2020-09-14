package com.example.android.comeback;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    TextView storyContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        storyContent = findViewById(R.id.contentOfStory);

        Intent i = getIntent();

        if(i.hasExtra("titleOfStory") && i.hasExtra("ContentOfStory")) {
            Log.d("Details","Found Extras !!");
            String title = i.getStringExtra("titleOfStory");
            String content = i.getStringExtra("ContentOfStory");

            getSupportActionBar().setTitle(title);
            storyContent.setText(content);


            storyContent.setMovementMethod(new ScrollingMovementMethod());
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        } else {
            Log.d("Details","!! No Extras Found !!");
        }


    }
}