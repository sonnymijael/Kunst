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

import com.squareup.picasso.Picasso;

public class Login extends AppCompatActivity implements View.OnClickListener {
    Button Ingresar;
    ImageView Logo;
    String logo_url = "https://api.sonnymijael.com/v1/kusnt/resources/logo.png";
    Intent intent;

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

        Ingresar = (Button) findViewById(R.id.ingresar);
        Ingresar.setOnClickListener(this);

        intent = new Intent();

        setTitle("Sign In");
    }

    public boolean register_customer(){
        return false;
    }

    @Override
    public void onClick(View view) {

    }
}