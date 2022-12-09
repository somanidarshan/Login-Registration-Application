package com.example.loginregistration;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
public class HomeActivity2 extends AppCompatActivity {
    Button btnlogout;
    Button btnlogout1;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthstateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
        btnlogout1=findViewById(R.id.logout1);
        btnlogout=findViewById(R.id.logout);
        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intmain=new Intent(HomeActivity2.this,GSMModel.class);
                startActivity(intmain);
            }
        });
        btnlogout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intmain=new Intent(HomeActivity2.this,FirstActivity.class);
                startActivity(intmain);
            }
        });
    }
}
/*
FireBase DataBase :
            Provide Content On FireBase

 */