package com.example.barbershop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


public class Homepage extends AppCompatActivity {

    ImageButton appoibtn;ImageButton menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        appoibtn =(ImageButton) findViewById(R.id.appoibtn);
        menu =(ImageButton) findViewById(R.id.menu);

        appoibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Homepage.this, Appointment.class);
                startActivity(i);
            }
        });
        menu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Homepage.this, Menu.class);
                startActivity(i);
            }
        });
    }
}