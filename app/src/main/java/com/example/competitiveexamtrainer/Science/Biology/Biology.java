package com.example.competitiveexamtrainer.Science.Biology;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.competitiveexamtrainer.R;

public class Biology extends AppCompatActivity {


    Button bt_cp1,bt_cp2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biology);

        bt_cp1 = findViewById(R.id.bio_cp1);
        bt_cp2 = findViewById(R.id.bio_cp2);

        bt_cp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Biology.this,Biology_Concept1.class);
                startActivity(i);
            }
        });

        bt_cp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Biology.this,Biology_Concept2.class);
                startActivity(i);
            }
        });

    }

}