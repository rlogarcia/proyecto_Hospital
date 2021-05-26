/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto_hospital.modelo;


public class Paciente {
    private String nombre;
    private String cedula;
    private String direccion;
    private Eps eps;
    private String telefono;
    private Boolean sospechoso;
    private Boolean complicaciones;
    private String observaciones;

    public Paciente(String nombre, String cedula, String direccion, Eps eps, String telefono, Boolean sospechoso, Boolean complicaciones, String observaciones) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.direccion = direccion;
        this.eps = eps;
        this.telefono = telefono;
        this.sospechoso = sospechoso;
        this.complicaciones = complicaciones;
        this.observaciones = observaciones;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

     public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Boolean getSospechoso() {
        return sospechoso;
    }

    public void setSospechoso(Boolean sospechoso) {
        this.sospechoso = sospechoso;
    }

    public Boolean getComplicaciones() {
        return complicaciones;
    }

    public void setComplicaciones(Boolean complicaciones) {
        this.complicaciones = complicaciones;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return "Paciente{" + "nombre=" + nombre + ", cedula=" + cedula + ", direccion=" + direccion + ", eps=" + eps + ", telefono=" + telefono + ", sospechoso=" + sospechoso + ", complicaciones=" + complicaciones + ", observaciones=" + observaciones + '}';
    }

    public Eps getEps() {
        return eps;
    }

    public void setEps(Eps eps) {
        this.eps = eps;
    }

   
    
    
    
}
