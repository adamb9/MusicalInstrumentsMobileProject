package com.example.musicalinstrumentsmobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    ImageView mainImageView;
    TextView instrumentTitle, instrumentFact;
    Button wikiButton, soundButton;

    String myTitle, myFact, myLink;
    int myImage, mySound;

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

        wikiButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse(myLink));
                startActivity(intent);
            }
        });

        final MediaPlayer mp = MediaPlayer.create(this, mySound);
        soundButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                mp.start();
            }
        });

    }

    private void getData(){
        if(getIntent().hasExtra("myTitle") && getIntent().hasExtra("myImage") &&
        getIntent().hasExtra("myFact") && getIntent().hasExtra("myLink")){
            myTitle = getIntent().getStringExtra("myTitle");
            myFact = getIntent().getStringExtra("myFact");
            myLink = getIntent().getStringExtra("myLink");
            myImage = getIntent().getIntExtra("myImage", 1);
            mySound = getIntent().getIntExtra("mySound", 2);
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