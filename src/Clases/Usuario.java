/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Exceptions.EmptyStringException;
import Exceptions.IncorrectPasswordException;
import javax.swing.JOptionPane;
import utilities.utilerias;

/**
 *
 * @author Martínez Hernández Gabriela
 *         Martínez Carrera Dulce Carolina
 */
public class Usuario {

    private String CURP, nombre, apellidoPaterno, apellidoMaterno, nombreDeUsuario, password;
    //private int idDocente;

    public Usuario(String CURP, String nombre, String apellidoPaterno, String apellidoMaterno, String nombreDeUsuario, String password) {
        try {
            checkData(CURP, nombre, apellidoPaterno, apellidoMaterno, nombreDeUsuario, password);
            if (!checkPassword(password)) {
                throw new IncorrectPasswordException("Contraseña inválida.");
            }
            this.CURP = CURP;
            this.nombre = nombre;
            this.apellidoPaterno = apellidoPaterno;
            this.apellidoMaterno = apellidoMaterno;
            this.nombreDeUsuario = nombreDeUsuario;
            this.password = password;
            //this.idDocente = idDocente;
        } catch (NullPointerException | IncorrectPasswordException npe) {
            JOptionPane.showMessageDialog(null, npe.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void checkData(String CURP, String nombre, String apellidoPaterno, String apellidoMaterno, String nombreDeUsuario, String password) {
        try {
            if (utilerias.emptyString(nombre) && nombre.length() > 20) {
                throw new EmptyStringException("La longitud del nombre es muy grande");
            }
            if (utilerias.emptyString(apellidoPaterno) && apellidoPaterno.length() > 15) {
                throw new EmptyStringException("La longitud del apellido paterno es muy grande");
            }
            if (utilerias.emptyString(apellidoMaterno) && apellidoMaterno.length() > 15) {
                throw new EmptyStringException("La longitud del apellido materno es muy grande");
            }
            if (utilerias.emptyString(nombreDeUsuario) && nombreDeUsuario.length() > 10) {
                throw new EmptyStringException("La longitud del nombre de usuario es muy grande");
            }            
            if (nombre.length() < 3) {
                throw new EmptyStringException("La longitud del nombre es muy corta");
            }
            if (apellidoPaterno.length() < 3) {
                throw new EmptyStringException("La longitud del apellido paterno es muy corta");
            }
            if (apellidoMaterno.length() < 3) {
                throw new EmptyStringException("La longitud del apellido materno es muy corta");
            }
            if (nombreDeUsuario.length() < 3) {
                throw new EmptyStringException("La longitud del nombre de usuario es muy corta");
            }
            if (utilerias.emptyString(password)) {
                throw new EmptyStringException("Dato inválido");
            }
            if(utilerias.emptyString(CURP)){
                throw new EmptyStringException("No ha ingresado la CURP");
            }
        } catch (EmptyStringException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean checkPassword(String password) {
        return password.length() >= 8 && password.length() <= 16;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getNombreDeUsuario() {
        return nombreDeUsuario;
    }

    public String getPasswordUsuario() {
        return password;
    }

//    public int getIdDocente() {
//        return idDocente;
//    }

    public String getCURP(){
        return CURP;
    }
    
    public Boolean equalsPassword(String password) {
        try {
            if (utilerias.emptyString(password)) {
                throw new EmptyStringException("Dato inválido");
            }
        } catch (EmptyStringException | NullPointerException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return password.equals(password);
    }
}
