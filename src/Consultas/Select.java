/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

import Clases.Usuario;
import Exceptions.EmptyStringException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import utilities.utilerias;

/**
 *
 * @author Martínez Hernández Gabriela
 *         Martínez Carrera Dulce Carolina
 */
public class Select {

    private String nombreTabla;

    public Select(String nombreTabla) {
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

    public Usuario executeSelectLogin(Connection conexionBD, String usuario, String contraseña) {
        ResultSet resultadoConsulta;
        Usuario docente = null;
        try {
            resultadoConsulta = isNullResultSet(conexionBD, usuario);
            if (!resultadoConsulta.next()) {
                throw new SQLException("Usuario incorrecto.");
            }
            
            docente = new Usuario(
                    resultadoConsulta.getString(4),
                    resultadoConsulta.getString(5),
                    resultadoConsulta.getString(6),
                    resultadoConsulta.getString(2),
                    resultadoConsulta.getString(3),
                    resultadoConsulta.getString(4)
                    //resultadoConsulta.getInt(1)
            );

            if (!docente.equalsPassword(contraseña)) {
                throw new NullPointerException("Contraseña incorrecta.");
            }

            return docente;
        } catch (SQLException | NullPointerException ex) {
            System.out.println("Consultas.Select.executeSelectLogin()");
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return docente;
    }

    private ResultSet isNullResultSet(Connection conexionBD, String usuario) throws SQLException {
        PreparedStatement preparedStatement = null;
        String consulta = "select * from " + nombreTabla + " where nombreUsuario = ?";
        preparedStatement = conexionBD.prepareStatement(consulta);
        preparedStatement.setString(1, usuario);
        return preparedStatement.executeQuery();
    }

    public int selectCount(Connection conexionBD, String atributoAcontar) {
        PreparedStatement preparedStatement = null;
        ResultSet resultadoConsulta;
        String consulta = "select count(" + atributoAcontar + ") cant from " + nombreTabla;

        try {
            preparedStatement = conexionBD.prepareStatement(consulta);
            resultadoConsulta = preparedStatement.executeQuery();
            resultadoConsulta.next();
            return resultadoConsulta.getInt(1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }
}
