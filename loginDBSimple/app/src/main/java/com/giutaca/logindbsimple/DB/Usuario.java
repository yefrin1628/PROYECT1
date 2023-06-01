package com.giutaca.logindbsimple.DB;


import java.io.Serializable;

public class Usuario implements Serializable {

    private String pin;
    private String nombre;
    private String confirmarPin;
    private String telefono;
    private String correo;

    public Usuario() {
    }

    public Usuario(String documento, String nombre, String clave, String telefono, String correo) {
        this.pin = documento;
        this.nombre = nombre;
        this.confirmarPin = clave;
        this.telefono = telefono;
        this.correo = correo;
    }

    public Usuario(String documento,String clave) {
        this.pin = documento;
        this.confirmarPin = clave;
    }


    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getConfirmarPin() {
        return confirmarPin;
    }

    public void setConfirmarPin(String confirmarPin) {
        this.confirmarPin = confirmarPin;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
