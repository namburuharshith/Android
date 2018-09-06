package com.example.harshith.multiscreens;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Numbers extends AppCompatActivity {

    private MediaPlayer music;

    private AudioManager mAudioManager;

    AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {

                        music.pause();
                        music.seekTo(0);
                    }else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                        music.start();
                    } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                        releaseMediaPlayer();
                    }
                }
            };


    private MediaPlayer.OnCompletionListener mcomplete = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
          releaseMediaPlayer();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        mAudioManager = (AudioManager) getSystemService(AUDIO_SERVICE);


        final ArrayList<Words> ar = new ArrayList<Words>();

        ar.add(new Words("one", "ekh", R.drawable.number_one, R.raw.number_one));
        ar.add(new Words("two", "dho", R.drawable.number_two, R.raw.number_two));
        ar.add(new Words("three", "theen", R.drawable.number_three, R.raw.number_three));
        ar.add(new Words("four", "char", R.drawable.number_four, R.raw.number_four));
        ar.add(new Words("five", "panch", R.drawable.number_five, R.raw.number_five));
        ar.add(new Words("six", "chey", R.drawable.number_six, R.raw.number_six));
        ar.add(new Words("seven", "sath", R.drawable.number_seven, R.raw.number_seven));
        ar.add(new Words("eight", "aat", R.drawable.number_eight, R.raw.number_eight));
        ar.add(new Words("nine", "now", R.drawable.number_nine, R.raw.number_nine));
        ar.add(new Words("ten", "das", R.drawable.number_ten, R.raw.number_ten));

        WordsAdapter arr = new WordsAdapter(this, ar, R.color.category_numbers);
        ListView list = (ListView) findViewById(R.id.list);
        list.setAdapter(arr);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                releaseMediaPlayer();

                Words w = ar.get(i);

                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        // Use the music stream.
                        AudioManager.STREAM_MUSIC,
                        // Request permanent focus.
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // Start playback

                    music = MediaPlayer.create(Numbers.this, w.getmusic());


                    music.start();
                    music.setOnCompletionListener(mcomplete);
                }
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

            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }

}



