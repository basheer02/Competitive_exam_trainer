package com.example.competitiveexamtrainer.Admin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.competitiveexamtrainer.R;

public class Admin_login extends AppCompatActivity {

    EditText password;
    Button button_login;
    String pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        setContentView(R.layout.activity_admin_login);

        password = findViewById(R.id.bt_password);
        button_login = findViewById(R.id.bt_login);

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pass = password.getText().toString();
                if(pass.equals("2002")){
                    Intent i = new Intent(Admin_login.this,Admin_Home.class);
                    startActivity(i);
                    SharedPreferences pref = getSharedPreferences("ActivityPREFER", Context.MODE_PRIVATE);
                    SharedPreferences.Editor edt = pref.edit();
                    edt.putBoolean("activity_executed", true);
                    edt.commit();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Please enter correct password",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}