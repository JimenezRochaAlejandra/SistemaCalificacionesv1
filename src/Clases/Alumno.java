/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Exceptions.EmptyStringException;
import javax.swing.JOptionPane;
import utilities.utilerias;

/**
 *
 * @author Martínez Hernández Gabriela
 *         Martínez Carrera Dulce Carolina
 */
public class Alumno {

    private String numeroDeControl, nombre, apellidoPaterno, apellidoMaterno, carrera, tipoDeCurso;
    private int semestre;
    public Alumno(String numeroDeControl, String nombre, String apellidoPaterno, String apellidoMaterno, String carrera, int semestre, String tipoDeCurso) {
        try {
            checkData(numeroDeControl, nombre, apellidoPaterno);
            this.numeroDeControl = numeroDeControl;
            this.nombre = nombre;
            this.apellidoPaterno = apellidoPaterno;
            this.apellidoMaterno = apellidoMaterno;
            this.carrera = carrera;
            this.semestre = semestre;
            this.tipoDeCurso = tipoDeCurso;
        } catch (NullPointerException npe) {
            JOptionPane.showMessageDialog(null, npe.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void checkData(String numeroDeControl, String nombre, String apellidoPaterno) {
        try {
            if (utilerias.emptyString(numeroDeControl)) {
                throw new EmptyStringException("Dato inválido");
            }
            if (utilerias.emptyString(nombre)) {
                throw new EmptyStringException("Dato inválido");
            }
            if (utilerias.emptyString(apellidoPaterno)) {
                throw new EmptyStringException("Dato inválido");
            }
        } catch (EmptyStringException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String getNumeroDeControl() {
        return numeroDeControl;
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

    public String getCarrera() {
        return carrera;
    }

    public int getSemestre() {
        return semestre;
    }

    public String getTipoDeCurso() {
        return tipoDeCurso;
    }

}
