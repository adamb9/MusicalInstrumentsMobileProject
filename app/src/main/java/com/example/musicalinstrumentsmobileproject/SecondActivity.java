package com.example.musicalinstrumentsmobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    ImageView mainImageView;
    TextView instrumentTitle, instrumentFact;
    Button wikiButton, soundButton;

    String myTitle, myFact, myLink;
    int myImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mainImageView = findViewById(R.id.secondActivityImageView);
        instrumentTitle = findViewById(R.id.secondActivityTitleText);
        instrumentFact = findViewById(R.id.secondActivityFactText);
        wikiButton = findViewById(R.id.wikiButton);
        soundButton = findViewById(R.id.soundButton);

        getData();
        setData();
    }

    private void getData(){
        if(getIntent().hasExtra("myTitle") && getIntent().hasExtra("myImage") &&
        getIntent().hasExtra("myFact") && getIntent().hasExtra("myLink")){
            myTitle = getIntent().getStringExtra("myTitle");
            myFact = getIntent().getStringExtra("myFact");
            myLink = getIntent().getStringExtra("myLink");
            myImage = getIntent().getIntExtra("myImage", 1);
        }
        else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData(){
        instrumentTitle.setText(myTitle);
        instrumentFact.setText(myFact);
        mainImageView.setImageResource(myImage);
    }
}