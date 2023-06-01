package com.giutaca.logindbsimple.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.giutaca.logindbsimple.R;

public class Movii extends AppCompatActivity {

    Button btnIniciar;
    Button btnRegistrarme;
    ImageView imgAtras3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movii);
        initComponents();

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iniciar = new Intent(Movii.this,MainActivityLoginVista.class);
                startActivity(iniciar);
            }
        });

        btnRegistrarme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registrarme = new Intent(Movii.this,MainActivityRegistroVista.class);
                startActivity(registrarme);
            }
        });

        imgAtras3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void initComponents() {
        btnIniciar = findViewById(R.id.btnIniciar);
        btnRegistrarme = findViewById(R.id.btnRegistrarme);
        imgAtras3 = findViewById(R.id.imgAtras3);
    }
}