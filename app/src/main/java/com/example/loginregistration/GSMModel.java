package com.example.loginregistration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GSMModel extends AppCompatActivity {
    private Button gsm;
    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gsmmodel);
        gsm=findViewById(R.id.gsm);
        text=findViewById(R.id.text);
        ActivityCompat.requestPermissions(GSMModel.this,new String[]{Manifest.permission.READ_SMS}, PackageManager.PERMISSION_GRANTED);

        gsm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor=getContentResolver().query(Uri.parse("content://sms"),null,null,null,null);
                cursor.moveToFirst();
                text.setText(cursor.getString(12));

            }
        });


    }


}