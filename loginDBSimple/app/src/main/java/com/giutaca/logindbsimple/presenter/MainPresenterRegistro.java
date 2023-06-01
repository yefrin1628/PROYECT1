package com.giutaca.logindbsimple.presenter;

import static com.giutaca.logindbsimple.utils.Constantes.ERROR_CLAVE;
import static com.giutaca.logindbsimple.utils.Constantes.ERROR_CORREO;
import static com.giutaca.logindbsimple.utils.Constantes.ERROR_DOCUMENTO;
import static com.giutaca.logindbsimple.utils.Constantes.ERROR_DOCUMENTO_DUPLICADO;
import static com.giutaca.logindbsimple.utils.Constantes.ERROR_NOMBRE;
import static com.giutaca.logindbsimple.utils.Constantes.ERROR_TELEFONO;

import android.content.Context;
import android.widget.Switch;

import com.giutaca.logindbsimple.DB.Usuario;
import com.giutaca.logindbsimple.Interface.PresenterInterfaz;
import com.giutaca.logindbsimple.modelo.MainActivityRegistroModelo;
import com.giutaca.logindbsimple.vista.MainActivityRegistroVista;

public class MainPresenterRegistro implements PresenterInterfaz.PresenterRegistro {

    MainActivityRegistroModelo modelo;
    MainActivityRegistroVista vista;
    Context ctx;


    public MainPresenterRegistro(MainActivityRegistroVista vista, Context ctx) {
        this.vista = vista;
        this.ctx = ctx;
        this.modelo = new MainActivityRegistroModelo(this, ctx);

    }

    @Override
    public void mostrarError(String error) {

    }

    @Override
    public void mostrarErrorEditText(String[] error) {
        this.vista.mostrarErrorEditText(error);
    }

    @Override
    public void validarUsuario(Usuario usuario) {

        if (!(usuario.getNombre() != null && (usuario.getNombre().length() > 4 && usuario.getNombre().length() < 15))) {
            mostrarErrorEditText(new String[]{"1", ERROR_NOMBRE});
            return;
        }

        if (!(usuario.getPin() != null && usuario.getPin().length() == 4)) {
            mostrarErrorEditText(new String[]{"2", ERROR_DOCUMENTO});
            return;
        }

        if (!(this.modelo.consultarUsuarioPorId(usuario.getPin()))) {
            mostrarErrorEditText(new String[]{"2", ERROR_DOCUMENTO_DUPLICADO});
            return;
        }

        if (!(usuario.getConfirmarPin() != null && (usuario.getConfirmarPin().length() <= 4))){
            mostrarErrorEditText(new String[]{"3", ERROR_CLAVE});
            return;
        }

        if (!(usuario.getTelefono() != null && usuario.getTelefono().length() <= 10)) {
            mostrarErrorEditText(new String[]{"4", ERROR_TELEFONO});
            return;
        }

        if (!(usuario.getCorreo() != null && !(usuario.getCorreo().length() > 6 && usuario.getCorreo().length() < 20))) {
            mostrarErrorEditText(new String[]{"5", ERROR_CORREO});
            return;
        }

        modelo.registrarUsuario(usuario);
        usuarioRegistrado(usuario);
    }

    @Override
    public void usuarioRegistrado(Usuario usuario) {
        this.vista.usuarioRegistrado(usuario);
    }
}
