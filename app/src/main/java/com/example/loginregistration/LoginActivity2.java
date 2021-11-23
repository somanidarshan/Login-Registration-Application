package com.example.loginregistration;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity2 extends AppCompatActivity {
    public EditText emailid,password;
    Button btnsignin;
    TextView tvsignup;
    FirebaseAuth mfirebaseauth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        mfirebaseauth = FirebaseAuth.getInstance();
        emailid = findViewById(R.id.email);
        password = findViewById(R.id.pass);
        btnsignin = findViewById(R.id.button2);
        tvsignup = findViewById(R.id.tvsign);
        mAuthStateListener = new FirebaseAuth.AuthStateListener() {


            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mfirebaseUser = mfirebaseauth.getCurrentUser();
                if (mfirebaseUser != null) {
                    Toast.makeText(LoginActivity2.this, "You are Logged In", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(LoginActivity2.this, HomeActivity2.class);
                    startActivity(i);
                } else {
                    Toast.makeText(LoginActivity2.this, "Please Login", Toast.LENGTH_SHORT).show();
                }
            }
        };

        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String upemail = emailid.getText().toString();
                String uppassword = password.getText().toString();
                if (upemail.isEmpty()) {
                    emailid.setError("Please Enter the Email id ");
                    emailid.requestFocus();

                } else if (uppassword.isEmpty()) {
                    password.setError("Please Enter the password");
                } else if (upemail.isEmpty() && uppassword.isEmpty()) {
                    Toast.makeText(LoginActivity2.this, "Fields are Empty", Toast.LENGTH_SHORT).show();
                } else if (!(upemail.isEmpty() && uppassword.isEmpty())) {
                    mfirebaseauth.signInWithEmailAndPassword(upemail, uppassword).addOnCompleteListener(LoginActivity2.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(LoginActivity2.this, "Login Error, Please Login Again", Toast.LENGTH_SHORT).show();
                            } else {
                                Intent inthome = new Intent(LoginActivity2.this, HomeActivity2.class);
                                startActivity(inthome);
                            }
                        }
                    });
                } else {
                    Toast.makeText(LoginActivity2.this, "Error Occurred! During Sign UP", Toast.LENGTH_SHORT).show();

                }
            }

        });

        tvsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intsign = new Intent(LoginActivity2.this, MainActivity.class);
                startActivity(intsign);
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        mfirebaseauth.addAuthStateListener(mAuthStateListener);
    }
}