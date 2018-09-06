package com.example.harshith.multiscreens;

import android.app.Activity;
import java.lang.*;
import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordsAdapter extends ArrayAdapter<Words>{

    private int color;

    public WordsAdapter(Activity context, ArrayList<Words> wd,int color) {
        super(context,0,wd);
        this.color=color;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        View listView = convertView;
        if(listView == null){
            listView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Words listwords = getItem(position);

        TextView text1 = listView.findViewById(R.id.normal);
        text1.setText(listwords.getLang());

        TextView text2 = listView.findViewById(R.id.miwak);
        text2.setText(listwords.getEnglish());


        ImageView image = listView.findViewById(R.id.image);

        if(listwords.hasImage()) {
            image.setImageResource(listwords.getImage());
            image.setVisibility(View.VISIBLE);
        }
        else{
            image.setVisibility(View.GONE);
        }

        View subView = listView.findViewById(R.id.sub_view);
        int colors = ContextCompat.getColor(getContext(),color);
        subView.setBackgroundColor(colors);

        return listView;

    }
}
