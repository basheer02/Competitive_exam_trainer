package com.example.competitiveexamtrainer.Admin;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.OpenableColumns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.competitiveexamtrainer.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.HashMap;

public class Admin_Upload_QPapers extends AppCompatActivity {

    Spinner spin_sub,spin_part;
    String[] subjects = {"select subject","General Knowledge","Science","English","Maths"};
    String[] parts = {"select part","part1","part2"};
    String sub_name,part_no;

    TextView tv_name;
    ImageButton btn_select;
    Button btn_upload;
    ProgressDialog dialog;
    Uri pdf_url;
    String path_name;
    String filename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__upload__q_papers);

        tv_name = findViewById(R.id.pdf_name);
        btn_select = findViewById(R.id.select_pdf);
        btn_upload = findViewById(R.id.btn_upload);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        spin_sub = findViewById(R.id.list_sub);
        ArrayAdapter sub_list = new ArrayAdapter(this,android.R.layout.simple_spinner_item,subjects);
        sub_list.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_sub.setAdapter(sub_list);
        spin_sub.setOnItemSelectedListener(new SubjectSpinnerClass());

        spin_part = findViewById(R.id.list_part);
        ArrayAdapter part_list = new ArrayAdapter(this,android.R.layout.simple_spinner_item,parts);
        part_list.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_part.setAdapter(part_list);
        spin_part.setOnItemSelectedListener(new PartSpinnerClass());

        btn_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
                // for choose pdf
                galleryIntent.setType("*/*");
                startActivityForResult(galleryIntent, 1);
            }
        });

        btn_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                HashMap<String ,Object> hashMap = new HashMap<>();
                hashMap.put(part_no,filename);
                dialog = new ProgressDialog(Admin_Upload_QPapers.this);
                dialog.setMessage("Uploading");
                dialog.show();

                StorageReference storageReference = FirebaseStorage.getInstance().getReference();
                final StorageReference filepath = storageReference.child(path_name);

                filepath.putFile(pdf_url).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                        if(task.isSuccessful()){
                            FirebaseDatabase.getInstance().getReference("Question Papers")
                                    .child(sub_name)
                                    .updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    dialog.dismiss();

                                    Toast.makeText(getApplicationContext(),"Upload Successfull",Toast.LENGTH_SHORT).show();
                                }
                            });

                        }
                        else {
                            dialog.dismiss();
                            Toast.makeText(getApplicationContext(),"Upload Failed",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            pdf_url = data.getData();
            path_name = getFilename(this,pdf_url);
            int index = path_name.lastIndexOf('.');
            if( index == -1){
                filename = path_name;
            }
            else {
                filename = path_name.substring(0,index);
            }
            tv_name.setText(path_name);
        }
    }

    private String getFilename(Context context, Uri uri) {
        String name = null;
        if (uri != null && context != null) {
            Cursor returnCursor =
                    context.getContentResolver().query(uri, null, null, null, null);
            if (returnCursor != null) {
                int nameIndex = returnCursor.getColumnIndex(OpenableColumns.DISPLAY_NAME);
                returnCursor.moveToFirst();
                if (nameIndex >= 0) {
                     name = returnCursor.getString(nameIndex);
                }
                }
            }
        return name;
    }

    private class SubjectSpinnerClass implements android.widget.AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                sub_name = subjects[i];
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }

    private class PartSpinnerClass implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            part_no = parts[i];
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }
}
