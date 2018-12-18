/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

import connection.ConexionMySQL;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Martínez Hernández Gabriela 
 * Martínez Carrera Dulce Carolina
 */
public class InsertarGrupo {
    ConexionMySQL con = new ConexionMySQL("calificaciones", "root", "alejandra");
    
    public InsertarGrupo(){
    }
    
    public void nuevoGrupo(String idsem, String fechaini, String idcalle, String estado){
       try {            
           try (PreparedStatement pstm = con.getConnection().prepareStatement("insert into " + 
                        "semaforo(id_semaforo, fecha_inicio, id_calle, estado) " +
                        " values(?,?,?,?)")) {
               pstm.setString(1, idsem);
               pstm.setString(2, fechaini);
               pstm.setString(3, idcalle);                        
               pstm.setString(4, estado);                        
               pstm.execute();
           }            
         }catch(SQLException e){
         System.out.println(e);
      }
   } 
}
