/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;
import connection.ConexionMySQL;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author Martínez Hernández Gabriela 
 * Martínez Carrera Dulce Carolina
 */
public class ValidarAdministrador {
    ConexionMySQL con = new ConexionMySQL("calificaciones", "root", "alejandra");
    public ValidarAdministrador(){
        
    }
    
    public Boolean validarAdministrador(String idAdministrador, String password) {
        try {
            Statement instruccionSQL = con.getConnection().createStatement();
            ResultSet resultadosConsulta = instruccionSQL.executeQuery("SELECT * "
                    + "FROM profesor WHERE nombreUsuario = '" 
                    + idAdministrador + "' AND contrasena = '" + password +"'");
            if(resultadosConsulta.first()){
                return true;        //Aceptado
            } else {
                return false;        //No aceptado
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
