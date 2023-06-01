package com.giutaca.logindbsimple.Interface;

import com.giutaca.logindbsimple.DB.Usuario;

public interface ModeloInterfaz {

    interface ModeloLogin {
        String mostrarError(String error);
        boolean iniciarUsuario(Usuario usuario);


    }

    interface ModeloRegistro {
        String mostrarError(String error);
        Usuario registrarUsuario(Usuario usuario);
        Boolean consultarUsuarioPorId(String pin);
        void InitDB();

    }
}
