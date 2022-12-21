package com.example.competitiveexamtrainer.Admin;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.competitiveexamtrainer.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Admin_Upload_Quiz extends AppCompatActivity {

    EditText editText_question,editText_opt1,editText_opt2,editText_opt3,editText_opt4,editText_answer;
    Button button_upload;
    Spinner spinner_qno;
    ProgressDialog dialog;

    String qno[] = {"Select Question number","question1","question2","question3","question4","question5","question6","question7",
            "question8","question9","question10"};
    String sub[] = {"Select subject","General Knowledge","Science","English","Maths"};
    String qnumber,subject;


    String question,option1,option2,option3,option4,answer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__upload__quiz);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        editText_question = findViewById(R.id.text_question);
        editText_opt1 = findViewById(R.id.text_opt1);
        editText_opt2 = findViewById(R.id.text_opt2);
        editText_opt3 = findViewById(R.id.text_opt3);
        editText_opt4 = findViewById(R.id.text_opt4);
        editText_answer = findViewById(R.id.text_answer);
        button_upload = findViewById(R.id.bt_upload);

        spinner_qno = findViewById(R.id.list_qno);
        ArrayAdapter qno_list = new ArrayAdapter(this,android.R.layout.simple_spinner_item,qno);
        qno_list.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_qno.setAdapter(qno_list);
        spinner_qno.setOnItemSelectedListener(new QnoSpinnerClass());

        spinner_qno = findViewById(R.id.list_subject);
        ArrayAdapter sub_list = new ArrayAdapter(this,android.R.layout.simple_spinner_item,sub);
        sub_list.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_qno.setAdapter(sub_list);
        spinner_qno.setOnItemSelectedListener(new SubjectSpinnerClass());

        button_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new ProgressDialog(Admin_Upload_Quiz.this);
                dialog.setMessage("Uploading");
                dialog.show();
                upload();
            }
        });
    }

    public void upload(){

        question = editText_question.getText().toString();
        option1 = editText_opt1.getText().toString();
        option2 = editText_opt2.getText().toString();
        option3 = editText_opt3.getText().toString();
        option4 = editText_opt4.getText().toString();
        answer = editText_answer.getText().toString();

        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("question",question);
        hashMap.put("op1",option1);
        hashMap.put("op2",option2);
        hashMap.put("op3",option3);
        hashMap.put("op4",option4);
        hashMap.put("answer",answer);

        Task<Void> reference = FirebaseDatabase.getInstance().getReference("Quiz_Questions")
                .child(subject)
                .child(qnumber)
                .updateChildren(hashMap);

        reference.addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                dialog.dismiss();
                editText_question.setText("");
                editText_opt1.setText("");
                editText_opt2.setText("");
                editText_opt3.setText("");
                editText_opt4.setText("");
                editText_answer.setText("");
                Toast.makeText(getApplicationContext(),"Successfully  uploaded",Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                dialog.dismiss();
                Toast.makeText(getApplicationContext(),"uploaded Failed",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private class QnoSpinnerClass implements android.widget.AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            qnumber = qno[i];
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }

    private class SubjectSpinnerClass implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                subject = sub[i];
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }
}