package com.example.harshith.multiscreens;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        TextView numbers = (TextView)findViewById(R.id.numbers);

        numbers.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent numbersIntent = new Intent(MainActivity.this, Numbers.class);

                startActivity(numbersIntent);

                Toast.makeText(view.getContext(),"Open the list of numbers",Toast.LENGTH_SHORT).show();
            }

        });



        TextView members = (TextView)findViewById(R.id.family);

        members.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent membersIntent = new Intent(MainActivity.this, FamilyMembers.class);

                startActivity(membersIntent);

                Toast.makeText(view.getContext(),"Open the list of family members",Toast.LENGTH_SHORT).show();
            }

        });


        TextView colors = (TextView)findViewById(R.id.colors);

        colors.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent colorsIntent = new Intent(MainActivity.this, Colors.class);

                startActivity(colorsIntent);

                Toast.makeText(view.getContext(),"Open the list of colors",Toast.LENGTH_SHORT).show();
            }

        });


        TextView pharases = (TextView)findViewById(R.id.phrases);

        pharases.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent phrasesIntent = new Intent(MainActivity.this, Phrases.class);

                startActivity(phrasesIntent);

                Toast.makeText(view.getContext(),"Open the list of phrases",Toast.LENGTH_SHORT).show();
            }

        });
    }

}
