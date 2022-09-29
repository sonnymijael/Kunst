package com.example.kunst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    /// Preguntar al usuario si tiene cuenta
    /// Register => form
    /// Datos a solicitar
    /// Front => save local storage === servidor | se actualiza cada vez que se inicia session
    /// Encriptacion de contraseña

//        if(register_customer()){
//            if(is_doctor()){
//
//            }
//        }
    }

    public boolean register_customer(){
        return false;
    }
}