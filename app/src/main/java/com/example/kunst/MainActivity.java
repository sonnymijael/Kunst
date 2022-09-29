package com.example.kunst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button Login;
    ImageView Logo;
    String logo_url = "https://api.sonnymijael.com/v1/kusnt/resources/logo.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Login = (Button) Login.findViewById(R.id.login);
        Logo = (ImageView) Logo.findViewById(R.id.logo);

        Picasso.get().load(logo_url).into(Logo);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login:

                break;
        }
    }

    public String handleDistance(String longitud, String latitud) {
        return longitud + latitud;
    }
}