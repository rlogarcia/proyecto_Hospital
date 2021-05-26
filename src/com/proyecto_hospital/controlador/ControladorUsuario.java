/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto_hospital.controlador;

import com.proyecto_hospital.excepciones.UsuarioExcepcion;
import com.proyecto_hospital.modelo.Rol;
import com.proyecto_hospital.modelo.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author acer
 */
public class ControladorUsuario {
    private  Rol[] roles; 
    private List<Usuario> usuarios;
    
    public ControladorUsuario(){
        inicializarColecciones();
    }
    private void inicializarColecciones(){
        roles= new Rol[3];
        roles[0]= new Rol((byte)1, "Medico");
        roles[1]= new Rol((byte)2, "Enfermero");
        roles[2]= new Rol((byte)3, "Internista");
        
        usuarios= new ArrayList<>();
        usuarios.add(new Usuario("rloaiza89567@umanizales.edu.co", "roger123", roles[0],"Roger","Loaiza Garcia"));
        usuarios.add(new Usuario("rcarmona@umanizales.edu.co", "alejo123", roles[1],"Raul Alejandro", "Carmona Cuellar"));
        usuarios.add(new Usuario("ejemplo@umanizales.edu.co", "casi123", roles[2],"Ejemplo", "no tiene"));
    }

     public  Usuario verificarUsuario(String correo, String contrasenia) throws UsuarioExcepcion{
            if (correo==null|| correo.equals("")||contrasenia==null||contrasenia.equals("")){
                throw new UsuarioExcepcion("Debe diligenciar todos los datos ");
            }
                if (!validarCorreo(correo)){
                    throw new UsuarioExcepcion("Debe ingresar un correo valido");
                }
                if(contrasenia.length()<6){
                    throw new UsuarioExcepcion(" la contraseña debe tener almenos 6 caracateres");
                }
                for(Usuario usu: usuarios){
            if(usu.getCorreo().equals(correo) && usu.getContrasenia().equals(contrasenia) ){
                return usu;
            }
        }
            
      throw new UsuarioExcepcion(" Los datos ingresados no coinciden");
}
     private boolean validarCorreo(String email) {
        boolean espacios = true;

        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher matcher = pattern.matcher(email);

        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == ' ') {
                espacios = false;
                break;
            }
        }

        return matcher.find() && espacios;
    }
     
     
}
