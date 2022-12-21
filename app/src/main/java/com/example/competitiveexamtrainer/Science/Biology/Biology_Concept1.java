package com.example.competitiveexamtrainer.Science.Biology;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.competitiveexamtrainer.R;
import com.example.competitiveexamtrainer.retrievePdf;
import com.github.barteksc.pdfviewer.PDFView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Biology_Concept1 extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    PDFView pdfView;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biology__concept1);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        pdfView = findViewById(R.id.pdf_view);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Contents").child("biology").child("part1");


        dialog = new ProgressDialog(this);
        dialog.setMessage("loading");
        dialog.show();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String pdf_url = null;
                pdf_url = snapshot.getValue(String.class);
                new retrievePdf(pdfView,dialog,Biology_Concept1.this).execute(pdf_url);
                dialog.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                dialog.dismiss();
            }
        });
    }
}