package com.example.competitiveexamtrainer;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class retrievePdf extends AsyncTask<String,Void, InputStream> {


    PDFView pdfView;
    ProgressDialog dialog;
    Context context;

    public retrievePdf(PDFView pdfView,ProgressDialog dialog,Context context) {
        this.pdfView = pdfView;
        this.dialog = dialog;
        this.context = context;

        dialog.setMessage("loading");
        dialog.show();
    }

    @Override
    protected InputStream doInBackground(String... strings) {

        InputStream inputStream = null;
        try {
            URL url = new URL(strings[0]);
            // below is the step where we are
            // creating our connection.
            HttpURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
            if (urlConnection.getResponseCode() == 200) {
                // response is success.
                // we are getting input stream from url
                // and storing it in our variable.
                inputStream = new BufferedInputStream(urlConnection.getInputStream());
            }

        } catch (IOException e) {
            // this is the method
            // to handle errors.
            e.printStackTrace();
            return null;
        }
        return inputStream;
    }
    @Override
    protected void onPostExecute(InputStream inputStream) {
        // after the execution of our async
        // task we are loading our pdf in our pdf view.
        pdfView.fromStream(inputStream).load();
        dialog.dismiss();
    }
}
