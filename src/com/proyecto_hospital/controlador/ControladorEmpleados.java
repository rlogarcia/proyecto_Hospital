/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto_hospital.controlador;

import com.proyecto_hospital.modelo.Empleado;

/**
 *
 * @author acer
 */
public class ControladorEmpleados {
    public static final int   NUMERO_EMPLEADOS=4;
    private Empleado [] empleados;
    
    public ControladorEmpleados () {
    empleados= new Empleado[NUMERO_EMPLEADOS];
    }

}


