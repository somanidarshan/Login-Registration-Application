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

public class CustomerSignup extends AppCompatActivity {
    public EditText emailid,password;
    Button btnsignup;
    TextView tvsignin;
    FirebaseAuth mfirebaseauth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_customer_signup);
        mfirebaseauth=FirebaseAuth.getInstance();
        emailid=findViewById(R.id.email);
        password=findViewById(R.id.pass);
        btnsignup=findViewById(R.id.button2);
        tvsignin=findViewById(R.id.tvsign);
        btnsignup.setOnClickListener(v -> {
            String upemail=emailid.getText().toString();
            String uppassword=password.getText().toString();
            if(upemail.isEmpty()){
                emailid.setError("Please Enter the Email id ");
                emailid.requestFocus();
            }
            else if(uppassword.isEmpty()){
                password.setError("Please Enter the password");
            }
            else if(upemail.isEmpty() && uppassword.isEmpty()){
                Toast.makeText(CustomerSignup.this, "Fields are Empty", Toast.LENGTH_SHORT).show();
            }
            else if(!(upemail.isEmpty() && uppassword.isEmpty())){
                mfirebaseauth.createUserWithEmailAndPassword(upemail,uppassword).addOnCompleteListener(CustomerSignup.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(!task.isSuccessful()){
                            Toast.makeText(CustomerSignup.this, "Something went wrong! try again", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            startActivity(new Intent(CustomerSignup.this,CustomerHomePage.class));
                        }
                    }
                });
            }
            else{
                Toast.makeText(CustomerSignup.this, "Error Occurred! During Sign UP", Toast.LENGTH_SHORT).show();
            }

        });
        tvsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(CustomerSignup.this,CustomerLogin.class);
                startActivity(i);
            }
        });
    }
}