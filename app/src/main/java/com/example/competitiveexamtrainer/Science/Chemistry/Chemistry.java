package com.example.competitiveexamtrainer.Science.Chemistry;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.competitiveexamtrainer.R;

public class Chemistry extends AppCompatActivity {

    Button bt_cp1,bt_cp2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chemistry);

        bt_cp1 = findViewById(R.id.chem_cp1);
        bt_cp2 = findViewById(R.id.chem_cp2);

        bt_cp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Chemistry.this, Chemistry_Concept1.class);
                startActivity(i);
            }
        });

        bt_cp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Chemistry.this, Chemistry_Concept2.class);
                startActivity(i);
            }
        });

    }
}