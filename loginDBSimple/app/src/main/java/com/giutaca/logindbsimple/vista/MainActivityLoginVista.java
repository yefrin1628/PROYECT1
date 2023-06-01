package com.giutaca.logindbsimple.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.giutaca.logindbsimple.DB.Usuario;
import com.giutaca.logindbsimple.Interface.InterfacesMain;
import com.giutaca.logindbsimple.Interface.PresenterInterfaz;
import com.giutaca.logindbsimple.R;
import com.giutaca.logindbsimple.presenter.MainPresenterLogin;

public class MainActivityLoginVista extends AppCompatActivity implements InterfacesMain.VistaLogin {


    EditText et_numero;
    EditText et_pin;
    TextView tv;
    Button btn_login;
    ImageView imgAtras1;
    Button btn_registro;

    Usuario usuario;
    PresenterInterfaz.PresenterLogin presenter;
    Context ctx = MainActivityLoginVista.this;

    String strNumero;
    String strPin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 strNumero = et_numero.getText().toString();
                 strPin = et_pin.getText().toString();

                usuario = new Usuario(strNumero, strPin);

                presenter.validarUsuarios(usuario);

            }
        });


        btn_registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivityLoginVista.this, MainActivityRegistroVista.class);
                startActivity(i);
            }
        });

        imgAtras1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent img1 = new Intent(MainActivityLoginVista.this,Movii.class);
            startActivity(img1);
            }
        });

    }

    private void initComponents() {
        tv = findViewById(R.id.textView6);
        et_numero =findViewById(R.id.editTextNumber2);
        et_pin =findViewById(R.id.editTextTextPassword2);
        btn_login=findViewById(R.id.button);
        imgAtras1 = findViewById(R.id.imgAtras1);
        btn_registro=findViewById(R.id.buttonRegister);
        presenter = new MainPresenterLogin(this,ctx);

//        try {
//            Bundle extras = getIntent().getExtras();
//            String strLogin = tv.getText().toString();
//            Usuario usua = (Usuario) getIntent().getSerializableExtra("usuario");;
//            tv.setText(strLogin + usua.getNombre());
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }

    @Override
    public String mostrarError(String error) {
        return null;
    }

    @Override
    public void usuarioInicioSesion(Usuario usuario) {
        Intent principal = new Intent(MainActivityLoginVista.this,Principal.class);
        startActivity(principal);
    }

    @Override
    public void mostrarErrorEditText(String[] error) {
        Toast.makeText(ctx, "EditText" + error[0], Toast.LENGTH_SHORT).show();
        switch (error[0]){
            case "1":
                et_numero.setError(error[1]);
                break;
            case "2":
                et_pin.setError(error[1]);
            default :
                break;
        }
    }


}