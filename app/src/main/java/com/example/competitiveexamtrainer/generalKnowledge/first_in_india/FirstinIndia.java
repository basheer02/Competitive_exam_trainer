package com.example.competitiveexamtrainer.generalKnowledge.first_in_india;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.competitiveexamtrainer.R;

public class FirstinIndia extends AppCompatActivity {


    Button b1,b2,b3;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstin_india);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        b1 = findViewById(R.id.bt_concept1);
        b2 = findViewById(R.id.bt_concept2);
        b3 = findViewById(R.id.bt_concept3);
        progressBar = findViewById(R.id.loading);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        Intent i = new Intent(FirstinIndia.this, FirstinIndia_concept1.class);
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
                        Intent i = new Intent(FirstinIndia.this, FirstinIndia_concept2.class);
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
                        Intent i = new Intent(FirstinIndia.this, FirstinIndia_concept3.class);
                        startActivity(i);
                    }
                },1000);
            }
        });
    }
}