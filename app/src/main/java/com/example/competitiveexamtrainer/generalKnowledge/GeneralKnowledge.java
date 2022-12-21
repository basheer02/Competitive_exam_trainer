package com.example.competitiveexamtrainer.generalKnowledge;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.competitiveexamtrainer.R;
import com.example.competitiveexamtrainer.generalKnowledge.books_authors.BooksandauthorsActivity;
import com.example.competitiveexamtrainer.generalKnowledge.culture_history.Culture_History;
import com.example.competitiveexamtrainer.generalKnowledge.day_year.Day_Year;
import com.example.competitiveexamtrainer.generalKnowledge.first_in_india.FirstinIndia;
import com.example.competitiveexamtrainer.generalKnowledge.indian_economy.Indian_Economy;
import com.example.competitiveexamtrainer.generalKnowledge.indian_politics.Indian_Politics;

public class GeneralKnowledge extends AppCompatActivity {

    Button b1,b2,b3,b4,b5,b6,b7,b8,b9;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_knowledge);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        progressBar = findViewById(R.id.loading);
        b1 = findViewById(R.id.bt_books);
        b2 = findViewById(R.id.bt_days);
        b3 = findViewById(R.id.bt_history);
        b4 = findViewById(R.id.bt_politics);
        b5 = findViewById(R.id.bt_economy);
        b6 = findViewById(R.id.bt_first);
        b7 = findViewById(R.id.bt_quiz);
        b8 = findViewById(R.id.bt_rank);
        b9 = findViewById(R.id.bt_papers);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressBar.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        Intent i = new Intent(GeneralKnowledge.this, BooksandauthorsActivity.class);
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
                        Intent i = new Intent(GeneralKnowledge.this, Day_Year.class);
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
                        Intent i = new Intent(GeneralKnowledge.this, Culture_History.class);
                        startActivity(i);
                    }
                },1000);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressBar.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        Intent i = new Intent(GeneralKnowledge.this, Indian_Politics.class);
                        startActivity(i);
                    }
                },1000);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressBar.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        Intent i = new Intent(GeneralKnowledge.this, Indian_Economy.class);
                        startActivity(i);
                    }
                },1000);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressBar.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        Intent i = new Intent(GeneralKnowledge.this, FirstinIndia.class);
                        startActivity(i);
                    }
                },1000);
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(GeneralKnowledge.this, gk_quiz.class);
                startActivity(i);
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressBar.setVisibility(View.VISIBLE);
                Intent i = new Intent(GeneralKnowledge.this, GK_Rank.class);
                startActivity(i);

            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressBar.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        Intent i = new Intent(GeneralKnowledge.this, gk_previousQeustionPapers.class);
                        startActivity(i);
                    }
                },1000);
            }
        });
    }
}