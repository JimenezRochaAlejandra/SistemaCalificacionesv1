/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transacciones;

import Clases.Usuario;
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
public class InsertRegistroUsuario {
    private String nombreTabla;

    public InsertRegistroUsuario(String nombreTabla) {
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
    
    public boolean insertUsuario(Connection conexionBD, String CURP, String nombreDeUsuario, String password, String nombre, String apellidoPaterno, String apellidoMaterno){
        Usuario usuario = null;
        boolean insertado;
        try {
            usuario = new Usuario(CURP, nombre, apellidoPaterno, apellidoMaterno, nombreDeUsuario, password);
            
            insertado = isNullInsertUsuario(conexionBD, usuario);
            if (!insertado) {
                throw new NullPointerException("Fracaso al registrar usuario");
            }
            return true;
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    private boolean isNullInsertUsuario(Connection conexionBD, Usuario usuario) {
        String insert  = "Insert Into profesor values ('"+
                //usuario.getIdDocente()+",'"+
                usuario.getCURP()+"','"+
                usuario.getNombreDeUsuario()+"','"+
                usuario.getPasswordUsuario()+"','"+
                usuario.getNombre()+"','"+
                usuario.getApellidoPaterno()+"','"+
                usuario.getApellidoMaterno()+"');";
        try {
            conexionBD.setAutoCommit(false); ////// ----->> Desactivamos auto commit
            Statement st = conexionBD.createStatement();
            st.executeUpdate(insert);
            conexionBD.commit();
            return true;
        } catch (SQLException ex) {
            try {
//                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                System.out.println(ex.getMessage());
                ex.printStackTrace();
                conexionBD.rollback();
            } catch (SQLException ex1) {                
                JOptionPane.showMessageDialog(null, ex1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return false;
    }
}
