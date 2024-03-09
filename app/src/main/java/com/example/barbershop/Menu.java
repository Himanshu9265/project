package com.example.barbershop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Menu extends AppCompatActivity {

    TextView home,profile,ConandLoc,about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        home=(TextView) findViewById(R.id.home);
        profile=(TextView) findViewById(R.id.profile);
        ConandLoc=(TextView) findViewById(R.id.ConandLoc);
        about=(TextView) findViewById(R.id.about);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i=new Intent(Menu.this, Homepage.class);
                startActivity(i);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i=new Intent(Menu.this, Profile.class);
                startActivity(i);
            }
        });

        ConandLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i=new Intent(Menu.this, Aboutus.class);
                startActivity(i);
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i=new Intent(Menu.this, Aboutus.class);
                startActivity(i);
            }
        });
    }
}