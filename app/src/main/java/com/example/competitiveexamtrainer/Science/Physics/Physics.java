package com.example.competitiveexamtrainer.Science.Physics;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.competitiveexamtrainer.R;

public class Physics extends AppCompatActivity {

    Button btn_cp1,btn_cp2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physics);

        btn_cp1 = findViewById(R.id.phy_cp1);
        btn_cp2 = findViewById(R.id.phy_cp2);

        btn_cp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Physics.this,Physics_Concept1.class);
                startActivity(i);
            }
        });

        btn_cp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Physics.this,Physics_Concept2.class);
                startActivity(i);
            }
        });

    }
}