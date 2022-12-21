package com.example.competitiveexamtrainer.generalKnowledge;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.competitiveexamtrainer.DownloadFile;
import com.example.competitiveexamtrainer.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class gk_previousQeustionPapers extends AppCompatActivity {

    Button b1,b2;

    DownloadFile file;

    DatabaseReference databaseReference;

    String filename;
    String part1 = "part1";
    String part2 = "part2";

    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gk_previous_qeustion_papers);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        b1 = findViewById(R.id.gk1);
        b2 = findViewById(R.id.gk2);
      //  b3 = findViewById(R.id.gk3);

        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading");

        file = new DownloadFile(gk_previousQeustionPapers.this,dialog);




        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog.show();
                getFileName(part1);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
                getFileName(part2);
            }
        });
    }

    public void getFileName(String part){

        databaseReference = FirebaseDatabase.getInstance().getReference("Question Papers")
                .child("General Knowledge");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                filename = snapshot.child(part).getValue(String.class);
                file.fileDownload(filename);
                dialog.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}