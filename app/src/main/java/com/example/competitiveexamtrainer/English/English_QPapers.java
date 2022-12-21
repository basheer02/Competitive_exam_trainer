package com.example.competitiveexamtrainer.English;

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

public class English_QPapers extends AppCompatActivity {

    Button bt_eng1,bt_eng2;

    DownloadFile file;

    DatabaseReference databaseReference;

    String filename;
    String part1 = "part1";
    String part2 = "part2";

    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english__q_papers);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bt_eng1 = findViewById(R.id.bt_eng1);
        bt_eng2 = findViewById(R.id.bt_eng2);

        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading");

        file = new DownloadFile(English_QPapers.this,dialog);




        bt_eng1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog.show();
                getFileName(part1);
            }
        });
        bt_eng2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
                getFileName(part2);
            }
        });
    }

    public void getFileName(String part){

        databaseReference = FirebaseDatabase.getInstance().getReference("Question Papers")
                .child("English");

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