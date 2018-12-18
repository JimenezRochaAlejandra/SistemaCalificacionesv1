/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transacciones;

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
public class InsertPeriodo {
    private String nombreTabla;

    public InsertPeriodo(String nombreTabla) {
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
    
    public boolean insertPeriodo(Connection conexionBD, int idPeriodo, String nombrePeriodo){
        boolean insertado;
        try {            
            insertado = isNullInsertPeriodo(conexionBD, idPeriodo, nombrePeriodo);
            if (!insertado) {
                throw new NullPointerException("Fracaso al registrar periodo");
            }
            return true;
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
     private boolean isNullInsertPeriodo(Connection conexionBD, int idPeriodo, String nombrePeriodo) {
        String insert  = "Insert Into "+nombreTabla+" values ("+
                idPeriodo+",'"+                
                nombrePeriodo+"');";
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
