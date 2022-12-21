package com.example.competitiveexamtrainer.generalKnowledge.culture_history;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.competitiveexamtrainer.R;

public class Culture_History extends AppCompatActivity {

    Button b1,b2,b3;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_culture__history);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        progressBar = findViewById(R.id.loading);
        b1 = findViewById(R.id.bt_p1);
        b2 = findViewById(R.id.bt_p2);
        b3 = findViewById(R.id.bt_p3);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                progressBar.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        Intent i = new Intent(Culture_History.this, culture_history_Concept1.class);
                        startActivity(i);
                    }
                },1000);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressBar.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        Intent i = new Intent(Culture_History.this, culture_history_Concept2.class);
                        startActivity(i);
                    }
                },1000);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        Intent i = new Intent(Culture_History.this, culture_history_Concept3.class);
                        startActivity(i);
                    }
                },1000);
            }
        });


    }
}