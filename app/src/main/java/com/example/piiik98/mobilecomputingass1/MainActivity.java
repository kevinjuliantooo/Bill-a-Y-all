package com.example.piiik98.mobilecomputingass1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton pressPerson, pressPeople;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        pressPeople = findViewById(R.id.peopleButton);
        pressPerson = findViewById(R.id.personButton);

        pressPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent personIntent = new Intent(MainActivity.this, PersonActivity.class);
                startActivity(personIntent);
            }
        });

        pressPeople.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent peopleIntent = new Intent(MainActivity.this, PeopleActivity.class);
                startActivity(peopleIntent);
            }
        });
    }

}

