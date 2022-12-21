package com.example.competitiveexamtrainer.mainFrames;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.content.pm.ShortcutManagerCompat;
import androidx.core.graphics.drawable.IconCompat;

import com.example.competitiveexamtrainer.R;


public class MainActivity extends AppCompatActivity  {

    final static private String PREF_KEY_SHORTCUT_ADDED = "PREF_KEY_SHORTCUT_ADDED";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        addShortcutToHomeScreen(MainActivity.this);

        new Handler().postDelayed(new Runnable(){
            public void run(){
                Intent i = new Intent(MainActivity.this,SelectLogin.class);
                startActivity(i);
                finish();
            }
        }, 3000);

    /*    SharedPreferences pre = getSharedPreferences("ActivityPREF", Context.MODE_PRIVATE);
        if (pre.getBoolean("activity_executed", false)) {
            new Handler().postDelayed(new Runnable(){
                public void run(){
                    Intent i = new Intent(MainActivity.this,MainActivity2.class);
                    startActivity(i);
                    finish();
                }
            }, 3000);
        } else {
            new Handler().postDelayed(new Runnable(){
                public void run(){
                    Intent i = new Intent(MainActivity.this,LoginActivity.class);
                    startActivity(i);
                }
            }, 3000);
        }*/
    }

    public void addShortcutToHomeScreen(Context context)
    {
        if (ShortcutManagerCompat.isRequestPinShortcutSupported(context))
        {
            SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
            boolean shortCutWasAlreadyAdded = sharedPreferences.getBoolean(PREF_KEY_SHORTCUT_ADDED, false);
            if (shortCutWasAlreadyAdded) return;

            ShortcutInfoCompat shortcutInfo = new ShortcutInfoCompat.Builder(context, "#1")
                    .setIntent(new Intent(context, MainActivity.class).setAction(Intent.ACTION_MAIN)) // !!! intent's action must be set on oreo
                    .setShortLabel("competitive exam trainer")
                    .setIcon(IconCompat.createWithResource(context, R.mipmap.ic_launcher))
                    .build();
            ShortcutManagerCompat.requestPinShortcut(context, shortcutInfo, null);
            Toast.makeText(MainActivity.this,"Shortcut created",Toast.LENGTH_LONG).show();

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(PREF_KEY_SHORTCUT_ADDED, true);
            editor.commit();
        }
        else
        {
            Toast.makeText(MainActivity.this,"Shortcut Doesn't created",Toast.LENGTH_LONG).show();
        }
    }

}