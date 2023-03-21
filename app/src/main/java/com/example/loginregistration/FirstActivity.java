package com.example.loginregistration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstActivity extends AppCompatActivity {
    private CardView customer;
    private CardView driver;
    private Button customer_button;
    private Button driver_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        customer=findViewById(R.id.customer);
        driver=findViewById(R.id.driver);
        customer_button=findViewById(R.id.customer_button);
        driver_button=findViewById(R.id.driver_button);
        customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(FirstActivity.this,CustomerLogin.class);
                startActivity(i);
            }
        });

        driver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(FirstActivity.this,LoginActivity2.class);
                startActivity(i);
            }
        });
        customer_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(FirstActivity.this,CustomerLogin.class);
                startActivity(i);
            }
        });

        driver_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(FirstActivity.this,LoginActivity2.class);
                startActivity(i);
            }
        });



    }
}
