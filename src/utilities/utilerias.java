/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import Exceptions.InvalidFormatException;
import java.awt.List;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Martínez Hernández Gabriela
 *         Martínez Carrera Dulce Carolina
 */
public class utilerias {

    public static boolean emptyString(final String s) {
        return s == null || s.trim().isEmpty();
    }

    public static String ventanaDeBusqueda(JFrame ventana) {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Hoja de cálculo", "xlsx");

        fileChooser.setFileFilter(filter);

        int result = fileChooser.showOpenDialog(ventana);

        if (result != JFileChooser.CANCEL_OPTION) {

            File fileName = fileChooser.getSelectedFile();
            try {
                if ((fileName == null) || (fileName.getName().equals(""))) {
                    throw new NullPointerException("No se ha seleccionado un archivo.");
                }
                return fileName.getAbsolutePath();
            } catch (NullPointerException npe) {
                JOptionPane.showMessageDialog(null, npe.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return " ";
    }

    public static ArrayList cargarArchivoExcel(String ruta) {
        FileInputStream file = null;
        XSSFWorkbook libroExcel = null;
        XSSFSheet hojaDelLibro = null;

        try {
            file = new FileInputStream(new File(ruta));
            // Crear el objeto que tendra el libro de Excel
            libroExcel = new XSSFWorkbook(file);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        /*
	 * Obtenemos la primera pestaña a la que se quiera procesar indicando el indice.
	 * Una vez obtenida la hoja excel con las filas que se quieren leer obtenemos el iterator
	 * que nos permite recorrer cada una de las filas que contiene.
         */
        try {
            hojaDelLibro = libroExcel.getSheetAt(0);
            return recorrerArchivoExcel(hojaDelLibro);
        } catch (NullPointerException npe) {
            JOptionPane.showMessageDialog(null, npe.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    private static ArrayList recorrerArchivoExcel(XSSFSheet hojaDelLibro) {
        Iterator<Row> rowIterator = hojaDelLibro.iterator();
        Row fila;// Recorremos todas las filas para mostrar el contenido de cada celda
        ArrayList<String[]> alumnos = new ArrayList<String[]>();
        
        while (rowIterator.hasNext()) {
            fila = rowIterator.next();
            // Obtenemos el iterator que permite recorrer todas las celdas de una fila
            Iterator<Cell> cellIterator = fila.cellIterator();
            Cell celda;
            String[] datosALumnos = new String[2];
            while (cellIterator.hasNext()) {

                celda = cellIterator.next();
                // Dependiendo del formato de la celda el valor se debe mostrar como String, Fecha, boolean, entero...
                try {
                    if (celda.getCellType() == Cell.CELL_TYPE_BLANK && celda.getCellType() == Cell.CELL_TYPE_BOOLEAN
                            || celda.getCellType() == Cell.CELL_TYPE_ERROR && celda.getCellType() == Cell.CELL_TYPE_FORMULA) {
                        throw new InvalidFormatException("Formato de celda inválido");
                    }

                    if (celda.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                        String str = NumberToTextConverter.toText(celda.getNumericCellValue());
                        datosALumnos[0] = str;
                    }

                    if (celda.getCellType() == Cell.CELL_TYPE_STRING) {
                        datosALumnos[1] = celda.getStringCellValue();
                    }
                    
                } catch (InvalidFormatException ife) {
                    JOptionPane.showMessageDialog(null, ife.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
            alumnos.add(datosALumnos);
        }
        return alumnos;
    }

    public static JComboBox getListaDeAños() {
        JComboBox comboBoxAños = null;
        if (comboBoxAños == null) {
                        ArrayList<Integer> lstAnyos = new ArrayList<>();
                        int year = Calendar.getInstance().get(Calendar.YEAR);
                        for (int i = 2014; i<= year; i++) {
                              lstAnyos.add(i);
                        }
 
                        comboBoxAños = new JComboBox();
                        comboBoxAños.setModel(new DefaultComboBoxModel(lstAnyos.toArray(new Integer[lstAnyos .size()])));
 
        }
        return comboBoxAños;
    }
}
