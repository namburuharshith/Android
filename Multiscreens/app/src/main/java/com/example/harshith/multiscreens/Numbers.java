package com.example.harshith.multiscreens;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class Numbers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        ArrayList<String> ar = new ArrayList<String>();

        ar.add("one");
        ar.add("two");
        ar.add("three");
        ar.add("four");
        ar.add("five");
        ar.add("six");
        ar.add("seven");
        ar.add("eight");
        ar.add("nine");
        ar.add("ten");

    }
}
