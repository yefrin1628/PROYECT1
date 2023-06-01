package com.giutaca.logindbsimple.presenter;

import static com.giutaca.logindbsimple.utils.Constantes.ERROR_CLAVE;
import static com.giutaca.logindbsimple.utils.Constantes.ERROR_DATOS;
import static com.giutaca.logindbsimple.utils.Constantes.ERROR_DOCUMENTO;
import static com.giutaca.logindbsimple.utils.Constantes.ERROR_DOCUMENTO_DUPLICADO;

import android.content.Context;

import com.giutaca.logindbsimple.DB.Usuario;
import com.giutaca.logindbsimple.Interface.InterfacesMain;
import com.giutaca.logindbsimple.Interface.ModeloInterfaz;
import com.giutaca.logindbsimple.Interface.PresenterInterfaz;
import com.giutaca.logindbsimple.modelo.MainModeloLogin;

public class MainPresenterLogin implements PresenterInterfaz.PresenterLogin {

    InterfacesMain.VistaLogin vista;
    ModeloInterfaz.ModeloLogin modelo;
    Context ctx;

    public MainPresenterLogin(InterfacesMain.VistaLogin vista, Context ctx) {
        this.vista = vista;
        this.modelo = new MainModeloLogin(this, ctx);
        this.ctx = ctx;
    }

    @Override
    public String mostrarError(String error) {
        return null;
    }

    @Override
    public void mostrarErrorEditText(String[] error) {
        this.vista.mostrarErrorEditText(error);
    }

    @Override
    public void validarUsuarios(Usuario usuario) {
        if (!(usuario.getTelefono() != null && (usuario.getTelefono().length() <= 10))){
            mostrarErrorEditText(new String[]{"1", ERROR_DOCUMENTO});
            return;
        }
        if(!(usuario.getPin() != null && (usuario.getPin().length() <= 4))){
            mostrarErrorEditText(new String[]{"2", ERROR_CLAVE});
            return;
        }
        if(!(this.modelo.iniciarUsuario(usuario))){
            mostrarErrorEditText(new String[]{"1", ERROR_DATOS});
            return;
        }
    }
}



