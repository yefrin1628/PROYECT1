package com.giutaca.logindbsimple.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.giutaca.logindbsimple.R;

public class Tarjeta extends AppCompatActivity {

    private ImageView imgAtras5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarjeta);
        initComponents();

        imgAtras5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent img5 = new Intent(Tarjeta.this,Principal.class);
                startActivity(img5);
            }
        });
    }

    private void initComponents() {
        imgAtras5 = findViewById(R.id.imgAtras5);
    }
}