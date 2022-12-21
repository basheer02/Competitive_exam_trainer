package com.example.competitiveexamtrainer;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

public class DownloadFile {

    static StorageReference storageReference = FirebaseStorage.getInstance().getReference();
    static StorageReference reference;
    ProgressDialog dialog;


   static Context cont;
    public DownloadFile(Context context, ProgressDialog dialog){
        cont = context;
        this.dialog = dialog;
    }

//    ProgressDialog dialog = new ProgressDialog(cont);


    public void fileDownload(String filename){

        dialog.setMessage("Loading");
        dialog.show();
        reference = storageReference.child(filename+".pdf");

        reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {

                String url = uri.toString();
                Download(cont, filename, ".pdf",DIRECTORY_DOWNLOADS,url);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                dialog.dismiss();
                Toast.makeText(cont,"Something Wrong",Toast.LENGTH_LONG).show();
            }
        });
    }
    public void Download(Context context, String fileName, String fileExtension, String destinationDirectory, String url){

        DownloadManager downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);

        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context, destinationDirectory,fileName + fileExtension);

        downloadManager.enqueue(request);
        dialog.dismiss();
        Toast.makeText(cont,"Downloading on Progress",Toast.LENGTH_LONG).show();
        Toast.makeText(cont,"Downloaded file in Android/data/com.example....trainer",Toast.LENGTH_LONG).show();
    }
}
