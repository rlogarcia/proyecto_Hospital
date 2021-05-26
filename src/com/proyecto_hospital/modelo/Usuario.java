/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto_hospital.modelo;

import java.io.Serializable;

/**
 *
 * @author acer
 */
public class Usuario implements Serializable {
    private String correo;
    private String contrasenia;
    private Rol rol;
    private String nombre;
    private String Apellido;

    public Usuario(String correo, String contrasenia, Rol rol, String nombre, String Apellido) {
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.rol = rol;
        this.nombre = nombre;
        this.Apellido = Apellido;
    }

   

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Rol getRol() {
        return rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Usuario{" + "correo=" + correo + ", contrasenia=" + contrasenia + ", rol=" + rol + ", nombre=" + nombre + ", Apellido=" + Apellido + '}';
    }

    
    }
    
    

