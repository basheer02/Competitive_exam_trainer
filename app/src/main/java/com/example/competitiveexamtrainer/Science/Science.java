package com.example.competitiveexamtrainer.Science;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.competitiveexamtrainer.R;
import com.example.competitiveexamtrainer.Science.Biology.Biology;
import com.example.competitiveexamtrainer.Science.Chemistry.Chemistry;
import com.example.competitiveexamtrainer.Science.Physics.Physics;

public class Science extends AppCompatActivity {

    Button btn_biology,btn_physics,btn_chemistry,btn_quiz,btn_rank,btn_qpaper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btn_biology = findViewById(R.id.btn_biology);
        btn_physics = findViewById(R.id.btn_physics);
        btn_chemistry = findViewById(R.id.btn_chemistry);
        btn_quiz = findViewById(R.id.btn_quiz);
        btn_rank = findViewById(R.id.btn_rank);
        btn_qpaper = findViewById(R.id.btn_qpaper);

        btn_biology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Science.this, Biology.class);
                startActivity(i);
            }
        });

        btn_physics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Science.this, Physics.class);
                startActivity(i);
            }
        });

        btn_chemistry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Science.this, Chemistry.class);
                startActivity(i);
            }
        });

        btn_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Science.this, Science_Quiz.class);
                startActivity(i);
            }
        });

        btn_rank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Science.this, Science_Rank.class);
                startActivity(i);
            }
        });

        btn_qpaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Science.this, Science_QPapers.class);
                startActivity(i);
            }
        });
    }
}