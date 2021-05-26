/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto_hospital.modelo;

/**
 *
 * @author acer
 */
public class Eps {
    private String nombreEps;
    private double codigo;

    public Eps(String nombreEps, double codigo) {
        this.nombreEps = nombreEps;
        this.codigo = codigo;
    }

    public String getNombreEps() {
        return nombreEps;
    }

    public void setNombreEps(String nombreEps) {
        this.nombreEps = nombreEps;
    }

    public double getCodigo() {
        return codigo;
    }

    public void setCodigo(double codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return nombreEps ;
    }


}
