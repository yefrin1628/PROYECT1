package com.giutaca.logindbsimple.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.giutaca.logindbsimple.DB.Usuario;
import com.giutaca.logindbsimple.Interface.InterfacesMain;
import com.giutaca.logindbsimple.Interface.PresenterInterfaz;
import com.giutaca.logindbsimple.R;
import com.giutaca.logindbsimple.presenter.MainPresenterRegistro;

public class MainActivityRegistroVista extends AppCompatActivity implements InterfacesMain.VistaRegistro {

    EditText et_pin;
    EditText et_confirmarPin;
    EditText et_nombre;
    EditText et_telefono;
    EditText et_correo;
    ImageView imgAtras2;
    Button btn_registro;
    PresenterInterfaz.PresenterRegistro presenter;
    boolean toastshoen;
    Context ctx = MainActivityRegistroVista.this;
    Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_registro_vista);

        initComponents();
        presenter = new MainPresenterRegistro(this, ctx);
        btn_registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_pin = et_pin.getText().toString();
                String str_confirmar = et_confirmarPin.getText().toString();
                String str_nombre = et_nombre.getText().toString();
                String str_telefono = et_telefono.getText().toString();
                String str_correo = et_correo.getText().toString();

                usuario = new Usuario(str_pin, str_nombre, str_confirmar, str_telefono, str_correo);

                presenter.validarUsuario(usuario);
            }
        });

        imgAtras2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent img2 = new Intent(MainActivityRegistroVista.this, MainActivityLoginVista.class);
                startActivity(img2);
            }
        });

    }

    private void initComponents() {
        et_pin = findViewById(R.id.editTextNumber);
        et_confirmarPin = findViewById(R.id.editTextTextPassword);
        et_nombre = findViewById(R.id.editTextTextPersonName);
        et_telefono = findViewById(R.id.PersonNam1);
        et_correo = findViewById(R.id.PersonName);
        imgAtras2 = findViewById(R.id.imgAtras2);
        btn_registro = findViewById(R.id.buttonRegister);
    }

    @Override
    public String mostrarError(String error) {
        return null;
    }

    @Override
    public void usuarioRegistrado(Usuario usuario) {
        Intent i = new Intent(MainActivityRegistroVista.this, Principal.class);
//        i.putExtra("usuario", usuario);
        startActivity(i);
    }

    @Override
    public void mostrarErrorEditText(String[] error) {
        if (!toastshoen)
            Toast.makeText(ctx, "EditText" + error[0], Toast.LENGTH_SHORT).show();
        switch (error[0]) {
            case "1":
                et_nombre.setError(error[1]);
                break;
            case "2":
                et_pin.setError(error[1]);
                break;
            case "3":
                et_confirmarPin.setError(error[1]);
                break;
            case "4":
                et_telefono.setError(error[1]);
                break;
            case "5":
                et_correo.setError(error[1]);
            default:
                break;
        }
    }
}