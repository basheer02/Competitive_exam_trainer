package com.example.competitiveexamtrainer.generalKnowledge.indian_economy;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.competitiveexamtrainer.R;

public class Indian_Economy extends AppCompatActivity {

    Button b1,b2;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indian__economy);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        progressBar = findViewById(R.id.loading);
        b1 = findViewById(R.id.btn_p1);
        b2 = findViewById(R.id.btn_p2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                progressBar.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        Intent i = new Intent(Indian_Economy.this, indian_economy_concept1.class);
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
                        Intent i = new Intent(Indian_Economy.this, indian_economy_concept2.class);
                        startActivity(i);
                    }
                },1000);
            }
        });
    }
}