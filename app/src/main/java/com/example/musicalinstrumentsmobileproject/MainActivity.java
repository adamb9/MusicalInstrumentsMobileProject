package com.example.musicalinstrumentsmobileproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity{

    RecyclerView recyclerView;

    String s1[];
    String s2[];
    String s3[];
    int images[] = {R.drawable.accordion, R.drawable.acousticguitar, R.drawable.banjo,
            R.drawable.drums, R.drawable.elecguitar, R.drawable.flute, R.drawable.harp,
            R.drawable.piano, R.drawable.sax, R.drawable.trumpet};

    int sounds[] = {R.raw.accordionsound, R.raw.acousticsound, R.raw.banjosound, R.raw.drumsound,
            R.raw.electricsound, R.raw.flutesound, R.raw.harpsound, R.raw.pianosound,
            R.raw.saxsound, R.raw.trumpetsound};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        s1 = getResources().getStringArray(R.array.instruments);
        s2 = getResources().getStringArray(R.array.funfacts);
        s3 = getResources().getStringArray(R.array.wikilinks);


        MyRecyclerViewAdapter myRecyclerViewAdapter = new MyRecyclerViewAdapter(this, s1, s2, s3, images, sounds);
        recyclerView.setAdapter(myRecyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void onItemClick(int position){

    }
}