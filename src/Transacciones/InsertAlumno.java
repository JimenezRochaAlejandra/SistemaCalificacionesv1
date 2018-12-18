/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transacciones;

import Clases.Alumno;
import Exceptions.EmptyStringException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import utilities.utilerias;

/**
 *
 * @author Martínez Hernández Gabriela
 *         Martínez Carrera Dulce Carolina
 */
public class InsertAlumno {
    private String nombreTabla;

    public InsertAlumno(String nombreTabla) {
        try {
            if (utilerias.emptyString(nombreTabla)) {
                throw new EmptyStringException("Dato inválido");
            }
            this.nombreTabla = nombreTabla;
        } catch (NullPointerException npe) {
            JOptionPane.showMessageDialog(null, npe.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (EmptyStringException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void insertAlumno(Connection conexionBD, String nomeroDeControl, String nombre [], String carrera, int semestre, String tipoDeCurso){
        Alumno alumno = null;
        boolean insertado;
        try {
            alumno = new Alumno(
                    nomeroDeControl,
                    (nombre.length == 4)?nombre[2] +" "+ nombre[3]:(nombre.length == 2)?nombre[1]:nombre[2], //nombre
                    nombre[0], //Apellido paterno
                    (nombre.length == 2)?" ":nombre[1], //Apellido materno
                    carrera,
                    semestre,
                    tipoDeCurso
            );
            
            insertado = isNullResultSet(conexionBD, alumno);
            if (!insertado) {
                throw new NullPointerException("Fracaso al registrar alumno");
            }
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }    
    
    private boolean isNullResultSet(Connection conexionBD, Alumno alumno) {
        String insert  = "Insert Into "+nombreTabla+" values ('"+
                alumno.getNumeroDeControl()+"','"+
                alumno.getNombre()+"','"+
                alumno.getApellidoPaterno()+"','"+
                alumno.getApellidoMaterno()+"','"+
                alumno.getCarrera()+"',"+
                alumno.getSemestre()+",'"+
                alumno.getTipoDeCurso()+"');";
        try {
            conexionBD.setAutoCommit(false); ////// ----->> Desactivamos auto commit
            Statement st = conexionBD.createStatement();
            st.executeUpdate(insert);
            conexionBD.commit();
            return true;
        } catch (SQLException ex) {
            try {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                conexionBD.rollback();
            } catch (SQLException ex1) {                
                JOptionPane.showMessageDialog(null, ex1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return false;
    }
}
