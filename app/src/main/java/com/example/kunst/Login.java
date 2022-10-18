package com.example.kunst;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity implements View.OnClickListener {

    EditText email,password;
    Button btnlogin,btnregresar;
    ImageView Logo;
    String logo_url = "https://api.sonnymijael.com/v1/kusnt/resources/logo.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set header color
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.actionbar));

        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#557C83"));
        actionBar.setBackgroundDrawable(colorDrawable);

        Logo = (ImageView) findViewById(R.id.logo);
        Picasso.get().load(logo_url).into(Logo);

        //declaracion de valriables editext
        email=(EditText) findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);
        btnlogin = (Button) findViewById(R.id.ingresar);
        btnregresar=(Button)findViewById(R.id.regresar);
        btnlogin.setOnClickListener(this);
        btnregresar.setOnClickListener(this);
        setTitle("Sign In");
    }
    private void validarUsuario(String URL){
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if(response.isEmpty()){
                            Intent intent = new Intent(getApplicationContext(),
                                    /*ventanarpincipal*/MainActivity.class);
                        }else{
                            Toast.makeText(Login.this,"Usuario o Contraseña incorrecta",Toast.LENGTH_SHORT);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Login.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros=new HashMap<String,String>();
                parametros.put("email",email.getText().toString());//esto viene del php
                parametros.put("password",password.getText().toString());
                return parametros;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ingresar:
                validarUsuario("");//url del php de la base de datos
                break;
            case R.id.regresar:
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                break;
        }
    }
}