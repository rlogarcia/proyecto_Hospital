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
public class Internista extends Empleado implements Serializable  {
    
    public Internista(String nombre, String apellido) {
        super(nombre, apellido);
    }
    
}
