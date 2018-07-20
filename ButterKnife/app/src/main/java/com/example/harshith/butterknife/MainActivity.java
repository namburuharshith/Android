package com.example.harshith.butterknife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Fruits> fruitNameList;
    private RecyclerView.Adapter fruitAdapter;


    @BindView(R.id.rv_fruits_list)
    RecyclerView fruitRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        fruitAdapter = new FruitAdapter(createFruits());
        fruitRecyclerView.setAdapter(fruitAdapter);

    }

    public ArrayList<Fruits> createFruits(){

       fruitNameList = new ArrayList<Fruits>();

       fruitNameList.add(new Fruits("apple",R.drawable.apple));
        fruitNameList.add(new Fruits("blueberries",R.drawable.blueberries));
        fruitNameList.add(new Fruits("cherries",R.drawable.cherries));
        fruitNameList.add(new Fruits("lemon",R.drawable.lemon));
        fruitNameList.add(new Fruits("orange",R.drawable.orange));
        fruitNameList.add(new Fruits("peach",R.drawable.peach));
        fruitNameList.add(new Fruits("pear",R.drawable.pear));
        fruitNameList.add(new Fruits("pomegranate",R.drawable.pomegranate));
        fruitNameList.add(new Fruits("Rasberry",R.drawable.raspberry));
        fruitNameList.add(new Fruits("strawberry",R.drawable.strawberry));
        fruitNameList.add(new Fruits("tomato",R.drawable.tomato));
        fruitNameList.add(new Fruits("watermelon",R.drawable.watermelon));
        Log.v("FruitsList",fruitNameList.toString());

        return fruitNameList;
    }

}
