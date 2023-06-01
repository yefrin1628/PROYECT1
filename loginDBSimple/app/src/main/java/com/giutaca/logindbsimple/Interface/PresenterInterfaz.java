package com.giutaca.logindbsimple.Interface;

import com.giutaca.logindbsimple.DB.Usuario;

public interface PresenterInterfaz {


    interface PresenterLogin {
        String mostrarError(String error);

        void mostrarErrorEditText(String[] error);

        void validarUsuarios(Usuario usuario);
    }

    interface PresenterRegistro {
        void mostrarError(String error);
        void mostrarErrorEditText(String[] error);
        void validarUsuario(Usuario usuario);
        void usuarioRegistrado(Usuario usuario);
    }
}
