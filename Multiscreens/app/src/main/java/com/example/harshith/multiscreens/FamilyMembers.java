package com.example.harshith.multiscreens;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyMembers extends AppCompatActivity {

    private MediaPlayer music;

    private MediaPlayer.OnCompletionListener mcomplete= new MediaPlayer.OnCompletionListener(){
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        final ArrayList<Words> fa = new ArrayList<Words>();

        fa.add(new Words("mom","maa",R.drawable.family_mother,R.raw.family_mother));
        fa.add(new Words("dad","papa",R.drawable.family_father,R.raw.family_father));
        fa.add(new Words("grandfather","daada",R.drawable.family_grandfather,R.raw.family_grandfather));
        fa.add(new Words("grandmother","daadee maa",R.drawable.family_grandmother,R.raw.family_grandmother));
        fa.add(new Words("uncle","chaacha",R.drawable.family_father,R.raw.family_father));
        fa.add(new Words("aunt","chaachee",R.drawable.family_mother,R.raw.family_mother));
        fa.add(new Words("cousin","chachera bhaee",R.drawable.family_younger_brother,R.raw.family_younger_brother));
        fa.add(new Words("son","beta",R.drawable.family_son,R.raw.family_son));
        fa.add(new Words("daughter","beti",R.drawable.family_daughter,R.raw.family_daughter));
        fa.add(new Words("husband","pathi",R.drawable.family_older_brother,R.raw.family_younger_brother));
        fa.add(new Words("wife","pathnee",R.drawable.family_mother,R.raw.family_older_sister));

        WordsAdapter fam = new WordsAdapter (this,fa,R.color.category_family);
        ListView list = (ListView)findViewById(R.id.list);
        list.setAdapter(fam);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                releaseMediaPlayer();
                Words w = fa.get(i);
                music = MediaPlayer.create(FamilyMembers.this,w.getmusic());
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
