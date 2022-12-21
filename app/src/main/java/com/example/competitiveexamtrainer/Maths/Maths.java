package com.example.competitiveexamtrainer.Maths;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.competitiveexamtrainer.R;

public class Maths extends AppCompatActivity {

    Button btn_cp1,btn_cp2,btn_quiz,btn_rank,btn_qpaper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maths);

        btn_cp1 = findViewById(R.id.math_cp1);
        btn_cp2= findViewById(R.id.math_cp2);
        btn_quiz = findViewById(R.id.math_quiz);
        btn_rank = findViewById(R.id.math_rank);
        btn_qpaper = findViewById(R.id.math_qpaper);

        btn_cp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Maths.this, Maths_Concept1.class);
                startActivity(i);
            }
        });

        btn_cp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Maths.this, Maths_Concept2.class);
                startActivity(i);
            }
        });

        btn_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Maths.this, Maths_Quiz.class);
                startActivity(i);
            }
        });

        btn_rank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Maths.this, Maths_Rank.class);
                startActivity(i);
            }
        });

        btn_qpaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Maths.this, Maths_QPapers.class);
                startActivity(i);
            }
        });
    }
}