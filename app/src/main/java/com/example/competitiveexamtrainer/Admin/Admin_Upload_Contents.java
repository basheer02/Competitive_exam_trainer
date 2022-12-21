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
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.competitiveexamtrainer.R;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.HashMap;


public class Admin_Upload_Contents extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView text;
    ImageView select_pdf;
    Button upload_pdf;
    Spinner spin_sub,spin_part;
    Uri uri_pdf = null;
    String sub_name,part_no,filename;

    ProgressDialog dialog;

    String[] subjects = {"select subject","biology","physics","chemistry","english","maths"};
    String[] parts = {"select part","part1","part2"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__upload__contents);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        upload_pdf = findViewById(R.id.upload);
        select_pdf = findViewById(R.id.selectpdf);
        text = findViewById(R.id.pdfname);

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


        select_pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
                // for choose pdf
                galleryIntent.setType("*/*");
                startActivityForResult(galleryIntent, 1);
            }
        });

        upload_pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog = new ProgressDialog(Admin_Upload_Contents.this);
                dialog.setMessage("Uploading");
                dialog.show();

                StorageReference storageReference = FirebaseStorage.getInstance().getReference();
                final StorageReference filepath = storageReference.child(filename);
                filepath.putFile(uri_pdf).continueWithTask(new Continuation() {
                    @Override
                    public Object then(@NonNull Task task) throws Exception {
                        if (!task.isSuccessful()) {
                            throw task.getException();
                        }
                        return filepath.getDownloadUrl();
                    }
                }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                    @Override
                    public void onComplete(@NonNull Task<Uri> task) {
                        if (task.isSuccessful()) {

                            Uri uri = task.getResult();
                            String myurl;
                            myurl = uri.toString();
                            addUri(myurl);
                        } else {
                            dialog.dismiss();
                            Toast.makeText(getApplicationContext(), "Upload Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {

            uri_pdf = data.getData();
            filename = getFilename(this,uri_pdf);
            text.setText(filename);

        }
    }
    private void addUri(String uri){

        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put(part_no,uri);

      //  firebaseDatabase = FirebaseDatabase.getInstance();
        FirebaseDatabase.getInstance().getReference("Contents")
                                      .child(sub_name)
                                      .updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                dialog.dismiss();
                text.setText("select pdf file");
                Toast.makeText(getApplicationContext(), "Upload Success", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private class SubjectSpinnerClass implements AdapterView.OnItemSelectedListener {
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
}