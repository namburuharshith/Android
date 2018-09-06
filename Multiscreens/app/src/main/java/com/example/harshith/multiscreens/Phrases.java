package com.example.harshith.multiscreens;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Phrases extends AppCompatActivity {

    private MediaPlayer music;

    private MediaPlayer.OnCompletionListener mcomplete =(mediaplayer) ->{

        releaseMediaPlayer();
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        ArrayList<Words> ph = new ArrayList<Words>();

        ph.add(new Words("one","ekh",R.raw.phrase_are_you_coming));
        ph.add(new Words("two","dho",R.raw.phrase_come_here));
        ph.add(new Words("three","theen",R.raw.phrase_how_are_you_feeling));
        ph.add(new Words("four","char",R.raw.phrase_im_coming));
        ph.add(new Words("five","panch",R.raw.phrase_lets_go));
        ph.add(new Words("six","chey",R.raw.phrase_im_feeling_good));
        ph.add(new Words("seven","sath",R.raw.phrase_my_name_is));
        ph.add(new Words("eight","aat",R.raw.phrase_what_is_your_name));
        ph.add(new Words("nine","now",R.raw.phrase_where_are_you_going));
        ph.add(new Words("ten","das",R.raw.phrase_yes_im_coming));

        WordsAdapter pha = new WordsAdapter (this,ph,R.color.category_phrases);
        ListView list = (ListView)findViewById(R.id.list);
        list.setAdapter(pha);

        list.setOnItemClickListener((adapterView , view,i,l)->{

            Words w = ph.get(i);
            music = MediaPlayer.create(Phrases.this,w.getmusic());
            music.start();
            music.setOnCompletionListener(mcomplete);
        });

    }

    @Override
    protected void onStop() {
        super.onStop();

        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {

        if(music != null) {
            music.release();
            music = null;
        }
    }
}
