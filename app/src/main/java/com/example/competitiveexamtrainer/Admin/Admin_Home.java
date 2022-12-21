package com.example.competitiveexamtrainer.Admin;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.competitiveexamtrainer.R;
import com.example.competitiveexamtrainer.mainFrames.MainActivity2;

public class Admin_Home extends AppCompatActivity {

    Button btn_content,btn_quiz,btn_qpaper,btn_home,btn_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        setContentView(R.layout.activity_admin__home);

        btn_content = findViewById(R.id.upload_content);
        btn_quiz = findViewById(R.id.upload_quiz);
        btn_qpaper = findViewById(R.id.upload_qpapers);
        btn_home = findViewById(R.id.bt_home);
        btn_logout = findViewById(R.id.btn_logout);

        btn_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Admin_Home.this, Admin_Upload_Contents.class);
                startActivity(i);
            }
        });

        btn_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Admin_Home.this,Admin_Upload_Quiz.class);
                startActivity(i);
            }
        });

        btn_qpaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Admin_Home.this,Admin_Upload_QPapers.class);
                startActivity(i);
            }
        });

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Admin_Home.this, MainActivity2.class);
                startActivity(i);
            }
        });

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
               // LayoutInflater layoutInflater = LayoutInflater.from(Admin_Home.this);
              //  View promptView = layoutInflater.inflate(R.layout.user_prompt,null);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Admin_Home.this, AlertDialog.THEME_DEVICE_DEFAULT_DARK);
                alertDialogBuilder.setMessage("Are you logout?");

             //   alertDialogBuilder.setView(promptView);

                alertDialogBuilder.setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                SharedPreferences pref = getSharedPreferences("ActivityPREFER", Context.MODE_PRIVATE);
                                SharedPreferences.Editor edt = pref.edit();
                                edt.putBoolean("activity_executed", false);
                                edt.commit();

                                moveTaskToBack(true);
                                android.os.Process.killProcess(android.os.Process.myPid());
                                System.exit(1);
                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });
    }
}