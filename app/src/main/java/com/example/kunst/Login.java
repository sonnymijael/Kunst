package com.example.kunst;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity implements View.OnClickListener {
    Button Ingresar;
    ImageView Logo;
    String logo_url = "https://api.sonnymijael.com/v1/kusnt/resources/logo.png";
    Intent intent;

    EditText email, password;

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

        password = findViewById(R.id.password);
        email = findViewById(R.id.email);

        Logo = findViewById(R.id.logo);
        Picasso.get().load(logo_url).into(Logo);

        Ingresar = findViewById(R.id.ingresar);
        Ingresar.setOnClickListener(this);

        intent = new Intent();

        setTitle("Sign In");
    }

    public void message(String text){
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    public void RealizarPost(String url) {
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener() {
                    @Override
                    public void onResponse(Object response) {
                        message(response.toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        message(error.toString());
                        error.printStackTrace();
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String> params = new HashMap<String, String>();
                // the POST parameters:
                params.put("email", email.getText().toString());
                params.put("password", password.getText().toString());
                return params;
            }
        };
        Volley.newRequestQueue(this).add(postRequest);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ingresar:
                RealizarPost("https://api.sonnymijael.com/v1/kusnt/customer/login");
            break;
        }
    }
}