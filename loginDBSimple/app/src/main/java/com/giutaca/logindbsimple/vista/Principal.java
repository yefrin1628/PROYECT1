package com.giutaca.logindbsimple.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.giutaca.logindbsimple.R;

public class Principal extends AppCompatActivity {

    ImageView tarjeta;
    ImageView transferirDinero;
    ImageView historial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        initComponets();

        tarjeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tarjeta = new Intent(Principal.this,Tarjeta.class);
                startActivity(tarjeta);
            }
        });

        transferirDinero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent transferir = new Intent(Principal.this,Transferir.class);
                startActivity(transferir);
            }
        });


        historial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //pantalla para ver el historial
            }
        });

    }

    private void initComponets() {
        tarjeta = findViewById(R.id.imgTarjeta);
        transferirDinero = findViewById(R.id.imgTransferir);
        historial = findViewById(R.id.imgHistorial);
    }
}