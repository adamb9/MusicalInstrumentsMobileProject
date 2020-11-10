package com.example.musicalinstrumentsmobileproject;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {

    //private final View.OnClickListener myClickListener;

    String instrumentNames[];
    String facts[];
    String wikis[];
    int images[];
    int sounds[];
    Context context;

    public MyRecyclerViewAdapter(Context ct, String s1[],String s2[], String s3[], int img[], int snd[]){
        context = ct;
        instrumentNames = s1;
        facts = s2;
        wikis = s3;
        images = img;
        sounds = snd;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recyclerview_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Item_class item = new Item_class(instrumentNames[position], facts[position], wikis[position], images[position], sounds[position]);

        holder.myText.setText(item.getName());
        holder.myImage.setImageResource(item.getImage());

        holder.mainLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(context, SecondActivity.class);
                intent.putExtra("myTitle", item.getName());
                intent.putExtra("myImage", item.getImage());
                intent.putExtra("myFact", item.getFact());
                intent.putExtra("myLink", item.getLink());
                intent.putExtra("mySound", item.getSound());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return instrumentNames.length;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView myText;
        ImageView myImage;
        ConstraintLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myText = itemView.findViewById(R.id.instrument_txt);
            myImage = itemView.findViewById(R.id.myImageView);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }

    }


}
