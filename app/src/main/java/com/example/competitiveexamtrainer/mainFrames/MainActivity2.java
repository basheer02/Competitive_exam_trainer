package com.example.competitiveexamtrainer.mainFrames;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.competitiveexamtrainer.English.English;
import com.example.competitiveexamtrainer.Maths.Maths;
import com.example.competitiveexamtrainer.R;
import com.example.competitiveexamtrainer.Science.Science;
import com.example.competitiveexamtrainer.generalKnowledge.GeneralKnowledge;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity2 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    Button btn_gk,btn_science,btn_maths,btn_english;
    ProgressBar progressBar;
    NavigationView navigationView;
    TextView email;
    String username;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main2);
        setNavigationViewListener();

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        navigationView = findViewById(R.id.nav_view);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        username = user.getEmail();
        View header = navigationView.getHeaderView(0);
        email = header.findViewById(R.id.email);
        email.setText(username);

        progressBar = findViewById(R.id.loading);
        btn_gk = findViewById(R.id.btn_gk);
        btn_science = findViewById(R.id.btn_science);
        btn_english = findViewById(R.id.btn_english);
        btn_maths = findViewById(R.id.btn_maths);


        btn_gk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        Intent intent = new Intent(MainActivity2.this, GeneralKnowledge.class);
                        startActivity(intent);
                    }
                }, 1000);
            }
        });
        btn_science.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        Intent intent = new Intent(MainActivity2.this, Science.class);
                        startActivity(intent);
                    }
                }, 1000);
            }
        });

        btn_english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        Intent intent = new Intent(MainActivity2.this, English.class);
                        startActivity(intent);
                    }
                }, 1000);
            }
        });

        btn_maths.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        Intent intent = new Intent(MainActivity2.this, Maths.class);
                        startActivity(intent);
                    }
                }, 1000);
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.nav_gk: {
                Intent i = new Intent(MainActivity2.this,GeneralKnowledge.class);
                startActivity(i);
                break;
            }
            case R.id.nav_science: {
                Intent i = new Intent(MainActivity2.this,Science.class);
                startActivity(i);
                break;
            }
            case R.id.nav_english: {
                Intent i = new Intent(MainActivity2.this, English.class);
                startActivity(i);
                break;
            }
            case R.id.nav_maths: {
                Intent i = new Intent(MainActivity2.this, Maths.class);
                startActivity(i);
                break;
            }
            case R.id.nav_logout: {
               // LayoutInflater layoutInflater = LayoutInflater.from(this);
               // View promptView = layoutInflater.inflate(R.layout.user_prompt,null);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this, AlertDialog.THEME_DEVICE_DEFAULT_DARK);
                alertDialogBuilder.setMessage("Are you logout?");
              //  alertDialogBuilder.setView(promptView);

                alertDialogBuilder.setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                SharedPreferences pref = getSharedPreferences("ActivityPREF", Context.MODE_PRIVATE);
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
                break;
            }
        }
        //close navigation drawer
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setNavigationViewListener() {
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
}
