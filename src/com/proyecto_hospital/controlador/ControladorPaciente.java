/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto_hospital.controlador;


import com.proyecto_hospital.excepciones.UsuarioExcepcion;
import com.proyecto_hospital.modelo.Eps;
import com.proyecto_hospital.modelo.Paciente;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * @author acer
 */
public class ControladorPaciente {
    public static final int NUMERO_PACIENTE=15;
    private Paciente [] pacientes;
    private int contadorPaciente=0;
    private  Eps[] eps; 
    private List<Paciente> paciente;
    
    

    public ControladorPaciente() 
    {
        pacientes= new Paciente[NUMERO_PACIENTE];
        inicializarEps();
        inicializarPaciente();
        eliminarPaciente();;
        
    }
     private void inicializarEps(){
        eps= new Eps[13];
        eps[0]= new Eps("Salud Colmena E.P.S. S.A.", (byte)1);
        eps[1]= new Eps("Salud Total S.A. E.P.S.", (byte)2);
        eps[2]= new Eps("Cafesalud E.P.S. S.A.", (byte)3);
        eps[3]= new Eps("E.P.S.  Sanitas S.A.", (byte)4);
        eps[4]= new Eps("E.P.S. Unimec - Liquidación", (byte)5);
        eps[5]= new Eps("Compensar  E.P.S", (byte)6);
        eps[6]= new Eps("EPS Prog. Comfenalco Antioquia", (byte)7);
        eps[7]= new Eps("SALUDCOLOMBIA EPS S.A.", (byte)8);
        eps[8]= new Eps("SALUDVIDA S.A. EPS", (byte)9);
        eps[9]= new Eps("Colseguros E.P.S.", (byte)10);
        eps[10]= new Eps("E.P.S.  Saludcoop", (byte)11);
        eps[11]= new Eps("Coomeva E.P.S", (byte)12);
        eps[12]= new Eps("Solsalud S.A. EPS.", (byte)13);
    }
    public int getContadorPaciente() {
        return contadorPaciente;
    }

    public void setContadorPaciente(int contadorPaciente) {
        this.contadorPaciente = contadorPaciente;
    }
    
    private void inicializarPaciente(){
        pacientes[0]= new Paciente("Alfredo di estefano", "1727171271", "cerca a mi casa", eps[2], "652611", false, true, "no tiene nadita");
        //pacientes[0]= new Paciente("Alfredo di estefano", "1727171271", "cerca a mi casa", new Eps("Salud Colmena E.P.S. S.A", (byte)1), "652611", false, true, "no tiene nadita");
        contadorPaciente ++;
    }
    
    
    public void eliminarPaciente(){
        contadorPaciente --;
    }
    
    
    public String adicionaPaciente(Paciente regser)
    {
             if(contadorPaciente<NUMERO_PACIENTE){
                   pacientes[contadorPaciente]=regser;
            contadorPaciente++;
            return "Paciente adicionado";
        }
        else{
            return "No se pueden adicionar mas pacientes";
        }
    }

    public Paciente[] getPacientes() {
        return pacientes;
    }

    public void setPacientes(Paciente[] pacientes) {
        this.pacientes = pacientes;
    }

    @Override
    public String toString() {
        return Arrays.toString(eps);
    }

    public Eps[] getEps() {
        return eps;
    }

    public void setEps(Eps[] eps) {
        this.eps = eps;
    }
    public  Paciente verificarUsuario(String nombreCompleto, String cedula, String direccion,Eps eps, String telefono, boolean sospechoso, boolean complicaciones,String observaciones) throws UsuarioExcepcion{
            if (nombreCompleto==null|| nombreCompleto.equals("")||cedula==null||cedula.equals("")||direccion==null||direccion.equals("")||telefono==null||telefono.equals("")
                    ){
                throw new UsuarioExcepcion("Debe diligenciar todos los datos ");
            }
                if (!validarNombreCompleto(nombreCompleto)){
                    throw new UsuarioExcepcion("Ingrese un nombre valido");
                }
                if(telefono.length()!=10){
                    throw new UsuarioExcepcion(" El numero de telefono ingresado no es valido");
                }
               
       
                return new Paciente(nombreCompleto, cedula, direccion, eps, telefono, sospechoso, complicaciones, observaciones);
}
    
//    public void eliminarDatos(){
//          DefaultTableModel model= (DefaultTableModel) tblPacientes.getModel();
//          int eli= tblPacientes.getSelectedRowCount();
//           if (eli!=0){
//            model.getDataVector().removeElement(true);
//            tblPacientes.removeRowSelectionInterval(eli, eli);
//            tblPacientes.removeRowSelectionInterval(eli, eli);
//            tblPacientes.repaint();
//            JOptionPane.showMessageDialog(rootPane, "eliminar");
//                
//            
//        }else{
//            JOptionPane.showMessageDialog(rootPane, "No hay datos que eliminar");
//        
//       
//                }
//         tblPacientes.repaint();
//     }
    private boolean validarNombreCompleto(String nombre) {
        
        Pattern pattern = Pattern.compile("[a-zA-ZñÑáéíóúÁÉÍÓÚüÜ]{2,} [a-zA-ZñÑáéíóúÁÉÍÓÚüÜ]{2,} ");
        Matcher matcher = pattern.matcher(nombre);

              return matcher.find() ;
    }
}
