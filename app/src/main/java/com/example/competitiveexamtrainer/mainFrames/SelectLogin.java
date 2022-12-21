package com.example.competitiveexamtrainer.mainFrames;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.competitiveexamtrainer.Admin.Admin_Home;
import com.example.competitiveexamtrainer.Admin.Admin_login;
import com.example.competitiveexamtrainer.R;

public class SelectLogin extends AppCompatActivity {

    Button bt_admin,bt_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        setContentView(R.layout.activity_select_login);

        bt_user = findViewById(R.id.btn_user);
        bt_admin = findViewById(R.id.btn_admin);

        bt_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pre = getSharedPreferences("ActivityPREFER", Context.MODE_PRIVATE);
                if (pre.getBoolean("activity_executed", false)) {
                    Intent i = new Intent(SelectLogin.this, Admin_Home.class);
                    startActivity(i);
                    finish();
                } else {
                    Intent i = new Intent(SelectLogin.this, Admin_login.class);
                    startActivity(i);
                }
            }
        });

        bt_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pre = getSharedPreferences("ActivityPREF", Context.MODE_PRIVATE);
                if (pre.getBoolean("activity_executed", false)) {
                    Intent i = new Intent(SelectLogin.this,MainActivity2.class);
                    startActivity(i);
                    finish();
                } else {
                    Intent i = new Intent(SelectLogin.this,LoginActivity.class);
                    startActivity(i);
                }
            }
        });

    }
}