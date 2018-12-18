/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import Exceptions.EmptyStringException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import utilities.utilerias;

/**
 *
 * @author Martínez Hernández Gabriela
 *         Martínez Carrera Dulce Carolina
 */
public class ConexionMySQL {

    private Connection connection;
    private String dataBase;
    private String userDataBase;
    private String paswordDataBase;

    public ConexionMySQL(String dataBase, String userDataBase, String paswordDataBase) {
        try {
            if (utilerias.emptyString(dataBase)) {
                throw new EmptyStringException("Dato inválido");
            }
            if (utilerias.emptyString(userDataBase)) {
                throw new EmptyStringException("Dato inválido");
            }
            if (utilerias.emptyString(paswordDataBase)) {
                throw new EmptyStringException("Dato inválido");
            }
            this.dataBase = dataBase;
            this.userDataBase = userDataBase;
            this.paswordDataBase = paswordDataBase;
        } catch (NullPointerException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
        } catch (EmptyStringException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Connection getConnection() {
        try {
            if (connection == null) {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost/" + dataBase, userDataBase, paswordDataBase);
            }
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException("Conexión fallida", e);
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(ex);
        }
    }
}
