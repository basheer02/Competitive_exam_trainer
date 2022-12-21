package com.example.competitiveexamtrainer.English;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.competitiveexamtrainer.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class English_Quiz extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = firebaseDatabase.getReference("Quiz_Questions").child("English");
    DatabaseReference reference;
    FirebaseAuth firebaseAuth;
    ProgressDialog dialog;


    RadioButton r1,r2,r3,r4;
    RadioGroup rg1;
    Button btn_next,btn_rank;
    TextView number,questions;
    ProgressBar progressBar;
    String question,opt1,opt2,opt3,opt4,answer;
    int score = 0;
    int q_number = 1;

    String q_no = "question";
    String user_name = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english__quiz);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        number = findViewById(R.id.number);
        questions = findViewById(R.id.question);
        r1 = findViewById(R.id.rb1);
        r2 = findViewById(R.id.rb2);
        r3 = findViewById(R.id.rb3);
        r4 = findViewById(R.id.rb4);
        rg1 = findViewById(R.id.rg1);
        btn_next = findViewById(R.id.bt_next);
        btn_rank = findViewById(R.id.bt_rank);
        progressBar = findViewById(R.id.loading);

        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        String username = user.getEmail();
        int index = username.lastIndexOf("@");
        for( int i = 0; i < index; i++){
            user_name = user_name + username.charAt(i);
        }
        // for get username
      /*  LayoutInflater layoutInflater = LayoutInflater.from(this);
        View promptView = layoutInflater.inflate(R.layout.user_prompt,null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setView(promptView);
        final EditText user_input = (EditText) promptView.findViewById(R.id.user_name);

        alertDialogBuilder.setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        user_name = user_input.getText().toString();
                        updateQuestions();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();*/

        dialog = new ProgressDialog(this);
        dialog.setMessage("loading");

        updateQuestions();

        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rb1:
                    case R.id.rb2:
                    case R.id.rb3:
                    case R.id.rb4:
                        if(q_number > 9){
                            btn_next.setVisibility(View.INVISIBLE);
                            btn_rank.setVisibility(View.VISIBLE);
                            btn_rank.setEnabled(true);
                        }else{
                            btn_next.setVisibility(View.VISIBLE);
                        }
                        break;
                }
            }
        });
        btn_next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                q_number++;
                int v = rg1.getCheckedRadioButtonId();
                RadioButton r = findViewById(v);
                String a = r.getText().toString();
                if(a.equals(answer)){

                    score = score + 1;
                    r.setChecked(false);
                    btn_next.setVisibility(View.INVISIBLE);
                    updateQuestions();
                    number.setText("Question : "+q_number);
                }
                else {
                    r.setChecked(false);
                    btn_next.setVisibility(View.INVISIBLE);
                    updateQuestions();
                    number.setText(" Question : "+q_number);
                }
            }
        });
        btn_rank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
                int v = rg1.getCheckedRadioButtonId();
                RadioButton r = findViewById(v);
                String a = r.getText().toString();
                if (a.equals(answer)){
                    score = score + 1;
                }
                uploadScore();
            }
        });
    }

    private void uploadScore() {
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put(user_name,score);
        FirebaseDatabase.getInstance().getReference("Quiz Mark")
                .child("English")
                .updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                dialog.dismiss();
                Toast.makeText(getApplicationContext(),"Your Score Updated",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(English_Quiz.this, English_Rank.class);
                startActivity(i);
            }
        });
    }

    public void updateQuestions(){

        dialog.show();

        if (q_no.equals("question")){
            q_no = "question1";
        }
        else if (q_no.equals("question1")){
            q_no = "question2";
        }
        else if(q_no.equals("question2")){
            q_no = "question3";
        }
        else if(q_no.equals("question3")){
            q_no = "question4";
        }
        else if(q_no.equals("question4")){
            q_no = "question5";
        }
        else if(q_no.equals("question5")){
            q_no = "question6";
        }
        else if(q_no.equals("question6")){
            q_no = "question7";
        }
        else if(q_no.equals("question7")){
            q_no = "question8";
        }
        else if(q_no.equals("question8")){
            q_no = "question9";
        }
        else if(q_no.equals("question9")){
            q_no = "question10";
        }
        else if(q_no.equals("question10")){
            q_no = "question1";
        }

        reference = databaseReference.child(q_no);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                question = snapshot.child("question").getValue(String.class);
                opt1 = snapshot.child("op1").getValue(String.class);
                opt2 = snapshot.child("op2").getValue(String.class);
                opt3 = snapshot.child("op3").getValue(String.class);
                opt4 = snapshot.child("op4").getValue(String.class);
                String ans = snapshot.child("answer").getValue(String.class);
                questions.setText(question);
                r1.setText(opt1);
                r2.setText(opt2);
                r3.setText(opt3);
                r4.setText(opt4);
                answer = ans;
                dialog.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                dialog.dismiss();
                Toast.makeText(getApplicationContext(),"Database Error",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
