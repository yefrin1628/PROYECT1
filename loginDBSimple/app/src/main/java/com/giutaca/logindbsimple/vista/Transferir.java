package com.giutaca.logindbsimple.vista;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.giutaca.logindbsimple.R;

public class Transferir extends AppCompatActivity {

    private Button btnTransferir;
    private EditText etNumeroTelefono, etMontoTransferir;
    private ImageView imgAtras4;


    private double saldoDisponible = 1000; // Saldo disponible para transferencia
    private boolean toastShoen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transferir);

        initComponets();

        btnTransferir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener los valores ingresados
                String numeroTelefono = etNumeroTelefono.getText().toString();
                double montoTransferir = Double.parseDouble(etMontoTransferir.getText().toString());

                // Validar si el monto está disponible para transferencia
                if (montoTransferir <= saldoDisponible) {
                    // Mostrar cuadro de diálogo de confirmación
                    showConfirmationDialog(numeroTelefono, montoTransferir);
                } else {
                    if (!toastShoen){
                    Toast.makeText(Transferir.this, "Monto no disponible", Toast.LENGTH_SHORT).show();
                    toastShoen = true;

                }}
            }
        });

        imgAtras4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent img4 = new Intent(Transferir.this,Principal.class);
                startActivity(img4);
            }
        });

    }

    private void initComponets() {
        etNumeroTelefono = findViewById(R.id.etNumeroTelefono);
        etMontoTransferir = findViewById(R.id.etMontoTransferir);
        imgAtras4 = findViewById(R.id.imgAtras4);
        btnTransferir = findViewById(R.id.btntransferir);
    }

    private void showConfirmationDialog(final String numeroTelefono, final double montoTransferir) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirmación de transferencia")
                .setMessage("¿Desea transferir " + montoTransferir + " a " + numeroTelefono + "?")
                .setPositiveButton("Continuar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Realizar la transferencia
                       realizarTransferencia(numeroTelefono, montoTransferir);
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }


    private void realizarTransferencia(String numeroTelefono, double montoTransferir) {
        //Aquí puedes implementar la lógica para realizar la transferencia
        //por ejemplo, actualizar el saldo disponible, enviar la transacción al servidor, etc.
        saldoDisponible -= montoTransferir;
        if (!toastShoen)Toast.makeText(this, "Transferencia realizada con éxito", Toast.LENGTH_SHORT).show();
    }
}