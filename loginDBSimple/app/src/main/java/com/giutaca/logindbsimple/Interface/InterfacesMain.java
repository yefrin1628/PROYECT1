package com.giutaca.logindbsimple.Interface;

import com.giutaca.logindbsimple.DB.Usuario;

public interface InterfacesMain {


    interface VistaLogin {
        String mostrarError(String error);

        void usuarioInicioSesion(Usuario usuario);

        void mostrarErrorEditText(String[] error);
    }



    interface VistaRegistro {
        String mostrarError(String error);
        void usuarioRegistrado(Usuario usuario);
        void mostrarErrorEditText(String[] error);
    }
}
