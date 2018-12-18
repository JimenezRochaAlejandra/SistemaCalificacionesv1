/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

import connection.ConexionMySQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Martínez Hernández Gabriela Martínez Carrera Dulce Carolina
 */
public class Consultas {

    ConexionMySQL con = new ConexionMySQL("calificaciones", "root", "alejandra");

    public Consultas() {
    }

    public String[] getCurp() {
        Integer registros = 0;
        // obtenemos la cantidad de registros existentes en la tabla
        try {
            PreparedStatement pstm = con.getConnection()
                    .prepareStatement("SELECT count(CURP) as total FROM profesor ");
            //El ResultSet devuelve el resultado de la consulta
            try (ResultSet res = pstm.executeQuery()) {
                res.next();
                registros = res.getInt("total");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        String[] data = new String[registros];
        // realizamos la consulta sql y llenamos los datos en "Object"
        try {
            PreparedStatement pstm = con.getConnection()
                    .prepareStatement("SELECT CURP FROM profesor ORDER BY CURP ");
            ResultSet res = pstm.executeQuery();
            Integer i = 0;
            while (res.next()) {
                String nomMat = res.getString("CURP");
                data[i] = nomMat;
                i++;
            }
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return data;
    }

    public void insetarGrupo(String idMateria, String nombre, String anio, String periodo, String numeroUnidades, String hora, String curp) {
        try {
            try (PreparedStatement pstm = con.getConnection().prepareStatement("insert into "
                    + "materia "
                    + " values(?,?,?,?,?,?,?)")) {
                pstm.setString(1, idMateria);
                pstm.setString(2, nombre);
                pstm.setString(3, anio);
                pstm.setString(4, periodo);
                pstm.setString(5, numeroUnidades);
                pstm.setString(6, hora);
                pstm.setString(7, curp);
                pstm.execute();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public String[] getNombreUsuarios() {
        Integer registros = 0;
        // obtenemos la cantidad de registros existentes en la tabla
        try {
            PreparedStatement pstm = con.getConnection()
                    .prepareStatement("SELECT count(CURP) as total FROM profesor ");
            //El ResultSet devuelve el resultado de la consulta
            try (ResultSet res = pstm.executeQuery()) {
                res.next();
                registros = res.getInt("total");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        String[] data = new String[registros];
        // realizamos la consulta sql y llenamos los datos en "Object"
        try {
            PreparedStatement pstm = con.getConnection()
                    .prepareStatement("SELECT nombreUsuario FROM profesor ORDER BY nombreUsuario ");
            ResultSet res = pstm.executeQuery();
            Integer i = 0;
            while (res.next()) {
                String nomMat = res.getString("nombreUsuario");
                data[i] = nomMat;
                i++;
            }
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return data;
    }

    public void updateMateria(String idMateria, String nombre, String anio, String periodo, String numeroUnidades, String hora, String curp) {
        try {
            PreparedStatement pstm = con.getConnection().prepareStatement("update materia "
                    + "set id_materia = ? ,"
                    + "nombre = ? ,"
                    + "anio = ? ,"
                    + "periodo = ?,"
                    + "numeroUnidades = ?,"
                    + "hora = ? ,"
                    + "CURP_profesor"
                    + "where id_materia = ? and nombre = ? and anio = ? and periodo = ?");
            pstm.setString(1, idMateria);
            pstm.setString(2, nombre);
            pstm.setString(3, anio);
            pstm.setString(4, periodo);
            pstm.setString(5, numeroUnidades);
            pstm.setString(6, hora);
            pstm.setString(7, curp);
            pstm.setString(8, idMateria);
            pstm.setString(9, nombre);
            pstm.setString(10, anio);
            pstm.setString(11, periodo);
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void insetarAlumno(String numeroControl, String nombre, String carrera, String semestre, String tipoCurso, String idMateria, String nombreMateria, String anioMateria, String periodoMateria, String hora) {
        try {
            try (PreparedStatement pstm = con.getConnection().prepareStatement("insert into "
                    + "alumno "
                    + " values(?,?,?,?,?,?,?,?,?,?)")) {
                pstm.setString(1, numeroControl);
                pstm.setString(2, nombre);
                pstm.setString(3, carrera);
                pstm.setString(4, semestre);
                pstm.setString(5, tipoCurso);
                pstm.setString(6, idMateria);
                pstm.setString(7, nombreMateria);
                pstm.setString(8, anioMateria);
                pstm.setString(9, periodoMateria);
                pstm.setString(10, hora);
                pstm.execute();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public Object[][] getDatos(String idGrupo, String nombreMateria, String hora) {
        int registros = 0;
        //obtenemos la cantidad de registros existentes en la tabla
        try {
            PreparedStatement pstm = con.getConnection().prepareStatement(
                    "SELECT count(numeroControl) as total FROM alumno ");
            try (ResultSet res = pstm.executeQuery()) {
                res.next();
                registros = res.getInt("total");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        Object[][] data = new String[registros][10];
        //realizamos la consulta sql y llenamos los datos en "Object"
        try {
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT "
                    + " numeroControl, nombre_completo, carrera, semestre, tipoCurso, id_materia, nombre_materia, anio_materia, periodo, hora "
                    + " FROM alumno where id_materia = '" + idGrupo + "' and nombre_materia = '" + nombreMateria + "' and hora = '" + hora
                    + "' ORDER BY nombre_completo ");
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while (res.next()) {
                String numeControl = res.getString("numeroControl");
                String nomCompleto = res.getString("nombre_completo");
                String carrera = res.getString("carrera");
                String semestre = res.getString("semestre");
                String tipoCurso = res.getString("tipoCurso");
                String idMateria = res.getString("id_materia");
                String nomMateria = res.getString("nombre_materia");
                String anioMateria = res.getString("anio_materia");
                String periodo = res.getString("periodo");
                String hora1 = res.getString("hora");
                data[i][0] = numeControl;
                data[i][1] = nomCompleto;
                data[i][2] = carrera;
                data[i][3] = semestre;
                data[i][4] = tipoCurso;
                data[i][5] = idMateria;
                data[i][6] = nomMateria;
                data[i][7] = anioMateria;
                data[i][8] = periodo;
                data[i][9] = hora1;
                i++;
            }
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return data;
    }

    public Object [][] getVerRubricas(){
      int registros = 0;
      //obtenemos la cantidad de registros existentes en la tabla
      try{         
         PreparedStatement pstm = con.getConnection().prepareStatement(
                 "SELECT count(id_unidad) as total FROM rubrica ");
          try (ResultSet res = pstm.executeQuery()) {
              res.next();
              registros = res.getInt("total");
          }
      }catch(SQLException e){
         System.out.println(e);
      }    
       
      Object[][] data = new String[registros][15];  
    //realizamos la consulta sql y llenamos los datos en "Object"
      try{    
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT " +
            " id_unidad, id_materia, nombreMateria, anioMateria, periodo, valor1, cal1val1, valor2, cal2val2, valor3, cal3val3, valor4, cal4val4, valor5, cal5val5" +
            " FROM rubrica" +
            " ORDER BY nombreMateria ");
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){
            String val1 = res.getString("valor1");
            String cal1val1 = res.getString("cal1val1");
            String val2 = res.getString("valor2");
            String cal2val2 = res.getString("cal2val2");
            String val3 = res.getString("valor3");
            String cal3val3 = res.getString("cal3val3");
            String valor4 = res.getString("valor4");
            String cal4val4 = res.getString("cal4val4");
            String valor5 = res.getString("valor5");
            String cal5val5 = res.getString("cal5val5");
            String idUnidad = res.getString("id_unidad");
            String idMateria = res.getString("id_materia");
            String nomMateria = res.getString("nombreMateria");
            String anioMateria = res.getString("anioMateria");
            String periodo = res.getString("periodo");
            data[i][0] = idUnidad; 
            data[i][1] = idMateria; 
            data[i][2] = nomMateria; 
            data[i][3] = anioMateria; 
            data[i][4] = periodo; 
            data[i][5] = val1;            
            data[i][6] = cal1val1;            
            data[i][7] = val2;                     
            data[i][8] = cal2val2; 
            data[i][9] = val3; 
            data[i][10] = cal3val3; 
            data[i][11] = valor4; 
            data[i][12] = cal4val4; 
            data[i][13] = valor5; 
            data[i][14] = cal5val5; 
            i++;
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return data;
 }
    
    public void insetarRubrica(String unidad, String grupo, String materia, String anio, String periodo, String valor1, String ponderacion1, String valor2, String ponderacion2, String valor3, String ponderacion3, String valor4, String ponderacion4, String valor5, String ponderacion5) {
        try {
            try (PreparedStatement pstm = con.getConnection().prepareStatement("insert into "
                    + "rubrica (valor1, cal1val1, valor2, cal2val2, valor3, cal3val3, valor4, cal4val4, valor5, cal5val5, id_unidad, id_materia, nombreMateria, anioMateria, periodo)"
                    + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)")) {
                
                pstm.setString(1, valor1);
                pstm.setString(2, ponderacion1);
                pstm.setString(3, valor2);
                pstm.setString(4, ponderacion2);
                pstm.setString(5, valor3);
                pstm.setString(6, ponderacion3);
                pstm.setString(7, valor4);
                pstm.setString(8, ponderacion4);
                pstm.setString(9, valor5);
                pstm.setString(10, ponderacion5);
                pstm.setString(11, unidad);
                pstm.setString(12, grupo);
                pstm.setString(13, materia);
                pstm.setString(14, anio);
                pstm.setString(15, periodo);
                pstm.execute();
            }
        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
    
    public Object[][] getCalificaciones(String idGrupo, String nombreMateria, String anio, String periodo) {
        int registros = 0;
        //obtenemos la cantidad de registros existentes en la tabla
        try {
            PreparedStatement pstm = con.getConnection().prepareStatement(
                    "SELECT count(numeroControl) as total FROM unidad ");
            try (ResultSet res = pstm.executeQuery()) {
                res.next();
                registros = res.getInt("total");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        Object[][] data = new String[registros][7];
        //realizamos la consulta sql y llenamos los datos en "Object"
        try {
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT "
                    + " numeroControl, id_unidad, clave_materia, nombreMateria, anio, periodo, calificacion "
                    + " FROM unidad where clave_materia = '" + idGrupo + "' and nombreMateria = '" + nombreMateria
                    + "' and anio = '"+ anio +"' and periodo = '"+ periodo +"' ORDER BY numeroControl ");
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while (res.next()) {
                String numeControl = res.getString("numeroControl");
                String idUnidad = res.getString("id_unidad");
                String idMateria = res.getString("clave_materia");
                String nomMateria = res.getString("nombreMateria");
                String year = res.getString("anio");
                String perio = res.getString("periodo");
                String cal = res.getString("calificacion");
                data[i][0] = numeControl;
                data[i][1] = idUnidad;
                data[i][2] = idMateria;
                data[i][3] = nomMateria;
                data[i][4] = year;
                data[i][5] = perio;
                data[i][6] = cal;
                i++;
            }
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return data;
    }
    
    public Object [][] getVerMaterias(){
      int registros = 0;
      //obtenemos la cantidad de registros existentes en la tabla
      try{         
         PreparedStatement pstm = con.getConnection().prepareStatement(
                 "SELECT count(id_materia) as total FROM materia ");
          try (ResultSet res = pstm.executeQuery()) {
              res.next();
              registros = res.getInt("total");
          }
      }catch(SQLException e){
         System.out.println(e);
      }    
       
      Object[][] data = new String[registros][7];  
    //realizamos la consulta sql y llenamos los datos en "Object"
      try{    
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT " +
            " id_materia, nombre, anio, periodo, numeroUnidades, hora, CURP_profesor" +
            " FROM materia" +
            " ORDER BY nombre ");
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){
            String idMateria = res.getString("id_materia");
            String nombre = res.getString("nombre");
            String anio = res.getString("anio");
            String periodo = res.getString("periodo");
            String numUni = res.getString("numeroUnidades");
            String hora = res.getString("hora");
            String curp = res.getString("CURP_profesor");
            data[i][0] = idMateria; 
            data[i][1] = nombre; 
            data[i][2] = anio; 
            data[i][3] = periodo; 
            data[i][4] = numUni; 
            data[i][5] = hora;            
            data[i][6] = curp;
            i++;
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return data;
 }
}
