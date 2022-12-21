package com.example.competitiveexamtrainer.mainFrames;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.competitiveexamtrainer.Admin.Admin_login;
import com.example.competitiveexamtrainer.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener {

    GestureDetector gestureDetector;

    Button btn_login;
    TextView txt_reg;
    EditText txt_email,txt_pass;
    ProgressBar progressBar;
    String email,password;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        setContentView(R.layout.activity_login);

        gestureDetector = new GestureDetector(LoginActivity.this,LoginActivity.this);

       progressBar = findViewById(R.id.loading);
        btn_login = findViewById(R.id.login);
        txt_reg = findViewById(R.id.textViewRegister);
        txt_email = findViewById(R.id.username);
        txt_pass = findViewById(R.id.password);
        firebaseAuth = FirebaseAuth.getInstance();

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txt_email.setEnabled(false);
                txt_pass.setEnabled(false);
                txt_reg.setEnabled(false);
                 email = txt_email.getText().toString().trim();
                 password = txt_pass.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    txt_email.setEnabled(true);
                    txt_pass.setEnabled(true);
                    txt_reg.setEnabled(true);
                    txt_email.setError("Email is Required.");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    txt_email.setEnabled(true);
                    txt_pass.setEnabled(true);
                    txt_reg.setEnabled(true);
                    txt_pass.setError("Password is Required.");
                    return;
                }

                if(password.length() < 6){
                    txt_email.setEnabled(true);
                    txt_pass.setEnabled(true);
                    txt_reg.setEnabled(true);

                    txt_pass.setError("Password Must be >= 6 Characters");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                // authenticate the user

                firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            new Handler().postDelayed(new Runnable() {
                                public void run() {
                                    Toast.makeText(LoginActivity.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();

                                    Intent i = new Intent(LoginActivity.this, MainActivity2.class);
                                    startActivity(i);
                                    SharedPreferences pref = getSharedPreferences("ActivityPREF", Context.MODE_PRIVATE);
                                    SharedPreferences.Editor edt = pref.edit();
                                    edt.putBoolean("activity_executed", true);
                                    edt.commit();
                                }
                            },2000);
                        }else {
                            txt_email.setEnabled(true);
                            txt_pass.setEnabled(true);
                            txt_reg.setEnabled(true);
                            Toast.makeText(LoginActivity.this, "Invalid Username and Password ", Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }

                    }
                });

            }
        });
        txt_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_email.setEnabled(false);
                txt_pass.setEnabled(false);
                progressBar.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable(){
                    public void run() {
                        Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
                        startActivity(intent);
                    }
                },3000);
            }
        });
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {
        Intent i = new Intent(LoginActivity.this, Admin_login.class);
        startActivity(i);
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        Intent i = new Intent(LoginActivity.this, Admin_login.class);
        startActivity(i);
        return true;
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }
}