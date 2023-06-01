package com.giutaca.logindbsimple.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.giutaca.logindbsimple.DB.AdminSQLiteOpenHelper;
import com.giutaca.logindbsimple.DB.Usuario;
import com.giutaca.logindbsimple.Interface.InterfacesMain;
import com.giutaca.logindbsimple.Interface.ModeloInterfaz;
import com.giutaca.logindbsimple.Interface.PresenterInterfaz;
import com.giutaca.logindbsimple.presenter.MainPresenterRegistro;

public class MainActivityRegistroModelo implements ModeloInterfaz.ModeloRegistro {

    PresenterInterfaz.PresenterRegistro presenter;
    Context ctx;
    SQLiteDatabase bd;

    public MainActivityRegistroModelo(MainPresenterRegistro presenter, Context ctx) {
        this.presenter = presenter;
        this.ctx = ctx;
    }



    @Override
    public String mostrarError(String error) {
        return null;
    }

    @Override
    public Usuario registrarUsuario(Usuario usuario) {
        InitDB();
        ContentValues registro = new ContentValues();
        registro.put("pin", usuario.getPin());
        registro.put("nombre", usuario.getNombre());
        registro.put("confirmarPin", usuario.getConfirmarPin());
        registro.put("telefono", usuario.getTelefono());
        registro.put("correo", usuario.getCorreo());
        bd.insert("usuarios", null, registro);
        bd.close();
        return usuario;
    }

    @Override
    public Boolean consultarUsuarioPorId(String pin) {
        InitDB();
        Cursor fila = bd.rawQuery("select * from usuarios where pin=?", new String[]{pin});
        if ((fila.moveToFirst())) {
            return false;
        }
        bd.close();
        return true;
    }


    @Override
    public void InitDB() {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this.ctx,"DBsimple", null, 1);
        bd = admin.getWritableDatabase();
    }
}
