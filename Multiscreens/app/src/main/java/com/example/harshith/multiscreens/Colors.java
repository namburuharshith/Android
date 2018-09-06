package com.example.harshith.multiscreens;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Colors extends AppCompatActivity {

    private MediaPlayer music;

    private MediaPlayer.OnCompletionListener mcomplete = new MediaPlayer.OnCompletionListener(){
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

       final ArrayList<Words> co = new ArrayList<Words>();

        co.add(new Words("red","lal",R.drawable.color_red,R.raw.color_red));
        co.add(new Words("green","hara",R.drawable.color_green,R.raw.color_green));
        co.add(new Words("blue","neela",R.drawable.color_black,R.raw.color_black));
        co.add(new Words("yellow","peela",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));
        co.add(new Words("black","kala",R.drawable.color_black,R.raw.color_black));
        co.add(new Words("white","sapheda",R.drawable.color_white,R.raw.color_white));
        co.add(new Words("orange","naarangee",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        co.add(new Words("pink","gulaabee",R.drawable.color_red,R.raw.color_red));
        co.add(new Words("violet","bainganee",R.drawable.color_red,R.raw.color_red));
        co.add(new Words("snuff","sunghanee",R.drawable.color_gray,R.raw.color_gray));
        co.add(new Words("gold","sona",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));
        co.add(new Words("silver","chaandee",R.drawable.color_white,R.raw.color_white));

        WordsAdapter col = new WordsAdapter (this,co,R.color.category_colors);
        ListView list = (ListView)findViewById(R.id.list);
        list.setAdapter(col);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                releaseMediaPlayer();
                Words w =co.get(i);
                music = MediaPlayer.create(Colors.this,w.getmusic());
                music.start();
                music.setOnCompletionListener(mcomplete);
            }
        });
    }
    @Override
    protected void onStop() {
        super.onStop();

        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {

        if (music != null) {

            music.release();

            music = null;
        }
    }

}
