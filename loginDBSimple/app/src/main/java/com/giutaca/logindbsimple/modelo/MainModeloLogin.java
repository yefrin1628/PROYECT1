package com.giutaca.logindbsimple.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.giutaca.logindbsimple.DB.AdminSQLiteOpenHelper;
import com.giutaca.logindbsimple.DB.Usuario;
import com.giutaca.logindbsimple.Interface.ModeloInterfaz;
import com.giutaca.logindbsimple.Interface.PresenterInterfaz;
import com.giutaca.logindbsimple.presenter.MainPresenterLogin;

public class MainModeloLogin implements ModeloInterfaz.ModeloLogin {

    PresenterInterfaz.PresenterLogin presenter;
    Context ctx;
    SQLiteDatabase bd;

    public MainModeloLogin(MainPresenterLogin presenter, Context ctx) {
        this.presenter = presenter;
        this.ctx = ctx;
    }

    @Override
    public String mostrarError(String error) {
        return null;
    }



    @Override
    public boolean iniciarUsuario(Usuario usuario) {
        InitDB();
        Cursor fila = bd.rawQuery("select * from usuarios where pin=? and confirmarPin=?", new String[]{usuario.getPin(),usuario.getConfirmarPin()});
        if (!(fila.moveToFirst())) {
            return false;
        }
        bd.close();
        return true;
    }


    private void InitDB() {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this.ctx,"DBsimple", null, 1);
        bd = admin.getWritableDatabase();
    }
}
