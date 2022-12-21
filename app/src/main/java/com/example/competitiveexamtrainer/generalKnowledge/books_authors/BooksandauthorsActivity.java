package com.example.competitiveexamtrainer.generalKnowledge.books_authors;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.competitiveexamtrainer.R;

public class BooksandauthorsActivity extends AppCompatActivity {

    Button b1,b2,b3;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booksandauthors);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        progressBar = findViewById(R.id.loading);
        b1 = findViewById(R.id.bt_part1);
        b2 = findViewById(R.id.bt_part2);
        b3 = findViewById(R.id.bt_part3);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                progressBar.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        Intent i = new Intent(BooksandauthorsActivity.this, Concept_Part1.class);
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
                        Intent i = new Intent(BooksandauthorsActivity.this, Concept_part2.class);
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
                        Intent i = new Intent(BooksandauthorsActivity.this, Concept_part3.class);
                        startActivity(i);
                    }
                },1000);
            }
        });

    }
}