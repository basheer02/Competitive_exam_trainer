package com.example.competitiveexamtrainer.Maths;

import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.competitiveexamtrainer.MarkAdapter;
import com.example.competitiveexamtrainer.MarkModel;
import com.example.competitiveexamtrainer.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Maths_Rank extends AppCompatActivity {

    RecyclerView recyclerView;
    MarkAdapter markAdapter;

    DatabaseReference databaseReference;
    ProgressDialog dialog;

    Integer value[];
    String name[];
    String temp_name;
    Integer temp_value;
    int length = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maths__rank);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.recycler_view);

        dialog = new ProgressDialog(this);
        dialog.setMessage("loading");
        dialog.show();

        databaseReference = FirebaseDatabase.getInstance().getReference("Quiz Mark").child("Maths");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                length = (int) snapshot.getChildrenCount();
                name = new String[length];
                value = new Integer[length];
                int x = 0;
                for (DataSnapshot ds : snapshot.getChildren()) {
                    name[x] = ds.getKey();
                    value[x] = ds.getValue(Integer.class);
                    x++;
                }

                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(Maths_Rank.this));


                for (int i = 0; i < length; i++) {

                    for (int j = i+1; j < length; j++) {

                        if ( value[j] > value[i]) {


                            temp_name = name[i];
                            name[i] = name[j];
                            name[j] = temp_name;

                            temp_value = value[i];
                            value[i] = value[j];
                            value[j] = temp_value;

                        }
                    }
                }

                int rank = 1;
                List<MarkModel> mark_list = new ArrayList<>();
                for (int i = 0; i < length; i++) {

                    //   for (int i = 0; i<=length ; i++)
                    mark_list.add(new MarkModel(rank,name[i],value[i]));
                    rank = rank + 1;
                }
                markAdapter = new MarkAdapter(Maths_Rank.this,mark_list);
                recyclerView.setAdapter(markAdapter);
                dialog.dismiss();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                dialog.dismiss();
                Toast.makeText(Maths_Rank.this, "Something Wrong", Toast.LENGTH_SHORT).show();
            }
        });

    }
}