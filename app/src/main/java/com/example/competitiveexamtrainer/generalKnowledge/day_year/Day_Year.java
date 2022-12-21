package com.example.competitiveexamtrainer.generalKnowledge.day_year;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.competitiveexamtrainer.R;

public class Day_Year extends AppCompatActivity {

    Button b1;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_year);

        b1 = findViewById(R.id.bt_concept);
        progressBar = findViewById(R.id.loading);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        Intent i = new Intent(Day_Year.this, Day_Year_Concept.class);
                        startActivity(i);
                    }
                },1000);
            }
        });
    }
}