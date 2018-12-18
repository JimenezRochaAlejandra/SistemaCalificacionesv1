/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;
import Exceptions.EmptyStringException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import utilities.utilerias;

/**
 *
 * @author Martínez Hernández Gabriela
 *         Martínez Carrera Dulce Carolina
 */
public class SelectPeriodos {
    
    private String nombreTabla;

    public SelectPeriodos(String nombreTabla) {
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
    
    
    public JComboBox executeSelectPeriodos(Connection conexionBD) {
        ResultSet resultadoConsulta;
        JComboBox periodos = new JComboBox();
        DefaultComboBoxModel modeloComboboxPeriodos = new DefaultComboBoxModel();
        try {
            resultadoConsulta = isNullResultSet(conexionBD);
            if (!resultadoConsulta.next()) {
                throw new NullPointerException();
            }

            modeloComboboxPeriodos.addElement("Seleccione un campo");//es el primer registro q mostrara el combo
            modeloComboboxPeriodos.addElement(resultadoConsulta.getString("periodo"));
            while (resultadoConsulta.next()) {
                modeloComboboxPeriodos.addElement(resultadoConsulta.getString("periodo"));                
            }
            periodos.setModel(modeloComboboxPeriodos);
             return periodos;           
        } catch (NullPointerException ex) {
            modeloComboboxPeriodos.addElement("---PERIODO NO DISPONIBLE---");//es el primer registro q mostrara el combo
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    private ResultSet isNullResultSet(Connection conexionBD) {
        PreparedStatement preparedStatement = null;
        String consulta = "select * from " + nombreTabla ;

        try {
            preparedStatement = conexionBD.prepareStatement(consulta);
            return preparedStatement.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
}
