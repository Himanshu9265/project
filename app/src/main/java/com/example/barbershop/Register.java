package com.example.barbershop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {

    TextView loginpg;
    Button register;
    EditText username , email , phone_no , password;
    String unm,em,pno,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        phone_no = findViewById(R.id.phone_no);
        password = findViewById(R.id.password);
        loginpg = findViewById(R.id.loginpg);
        register = findViewById(R.id.register);

//        loginpg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v){
//                Intent i=new Intent(Register.this, MainActivity.class);
//                startActivity(i);
//            }
//        });
        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
//                Intent i=new Intent(Register.this, Homepage.class);
//                startActivity(i);
                unm=username.getText().toString();
                em=email.getText().toString();
                pno=phone_no.getText().toString();
                pass=password.getText().toString();

                RequestQueue requestQueue = Volley.newRequestQueue(Register.this);
                String url = "http://192.168.163.114/project/API/reg.php";
                StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.equals("success")){
                            Toast.makeText(Register.this, "Registration successfully", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(Register.this, MainActivity.class);
                            startActivity(i);
                            finish();
                        }else{
                            Toast.makeText(Register.this, "something is wrong", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Register.this, "Error in registration ", Toast.LENGTH_LONG).show();
                    }
                }){
                    protected Map<String, String> getParams() {
                        Map<String, String> paramV = new HashMap<>();

                        paramV.put("username", unm);
                        paramV.put("email", em);
                        paramV.put("pass", pass);
                        paramV.put("phone_no",pno);

                        return paramV;
                    }
                };
                requestQueue.add(request);
            }
        });
        }
}