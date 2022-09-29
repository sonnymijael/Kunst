package com.example.kunst;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button Login;
    ImageView Logo;
    String logo_url = "https://api.sonnymijael.com/v1/kusnt/resources/logo.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // header get color
        ActionBar actionBar;
        actionBar = getSupportActionBar();

        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.actionbar));

        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#557C83"));
        actionBar.setBackgroundDrawable(colorDrawable);

        Button Login = (Button) findViewById(R.id.login);
        ImageView Logo = (ImageView) findViewById(R.id.logo);

        Login.setOnClickListener(this);

        Picasso.get().load(logo_url).into(Logo);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login:
                    Toast.makeText(this, "Inicio session correctamente", Toast.LENGTH_LONG).show();
                break;
        }
    }

    public String handleDistance(String longitud, String latitud) {
        return longitud + latitud;
    }
}