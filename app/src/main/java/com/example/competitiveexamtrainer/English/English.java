package com.example.competitiveexamtrainer.English;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.competitiveexamtrainer.R;
import com.example.competitiveexamtrainer.Science.Science_QPapers;
import com.example.competitiveexamtrainer.Science.Science_Quiz;
import com.example.competitiveexamtrainer.Science.Science_Rank;

public class English extends AppCompatActivity {

    Button btn_cp1,btn_cp2,btn_quiz,btn_rank,btn_qpaper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english);

        btn_cp1 = findViewById(R.id.eng_cp1);
        btn_cp2= findViewById(R.id.eng_cp2);
        btn_quiz = findViewById(R.id.eng_quiz);
        btn_rank = findViewById(R.id.eng_rank);
        btn_qpaper = findViewById(R.id.eng_qpaper);

        btn_cp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(English.this, English_Concept1.class);
                startActivity(i);
            }
        });

        btn_cp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(English.this, English_Concept2.class);
                startActivity(i);
            }
        });

        btn_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(English.this, English_Quiz.class);
                startActivity(i);
            }
        });

        btn_rank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(English.this, English_Rank.class);
                startActivity(i);
            }
        });

        btn_qpaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(English.this, English_QPapers.class);
                startActivity(i);
            }
        });
    }
}