/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


/**
 *
 * @author AGUSTIN
 */
public class ModelAgenda {

    private Connection conexion;
    private Statement st;
    private ResultSet rs;

    private String nombre;
    private String email;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    /**
     * Método que realiza las siguietnes acciones:
     * 1.- Conecta con la base agenda_mvc.
     * 2.- Consulta todo los registros de la tabla contactos.
     * 3.- Obtiene el nombre y el email y los guarda en las variables globales
     * nombre y email.
     */
    public void conectarDB() {
        try {
            
            conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/mvccsv","root","");
            st = conexion.createStatement();
            rs = st.executeQuery("SELECT * FROM contactos;");
            rs.next();
            nombre = rs.getString("nombre");
            email = rs.getString("email");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error ModelAgenda 001: " + err.getMessage());
        }
         
    }
    
    
   
     
    /**
     * Método que realiza las siguiente acciones:
     * 1.- Moverse al primer registro
     * 2.- obtener el valor del nombre de rs y guardarlo en la variable nombre
     * 3.- obtener el valor del email de rs y guardarlo en la variable email
     */
    public void moverPrimerRegistro(){
        System.out.print("Programa accion moverPrimerRegistro");
        try {
            rs.first();
            nombre = rs.getString("nombre");
            email = rs.getString("email");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error 001" + ex.getMessage());
        }
    }
    
    /**
     * Método que realiza las siguiente acciones:
     * 1.- Moverse al siguiente registro
     * 2.- obtener el valor del nombre de rs y guardarlo en la variable nombre
     * 3.- obtener el valor del email de rs y guardarlo en la variable email
     */
    public void moverSiguienteRegistro(){
        System.out.print("Programa accion moverSiguienteRegistro");
        try {
            if (!rs.isLast()) {
                rs.next();
                
                nombre = rs.getString("nombre");
                email = rs.getString("email");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error 001" + ex.getMessage());
        }

    }
    
    /**
     * Método que realiza las siguiente acciones:
     * 1.- Moverse al anterior registro
     * 2.- obtener el valor del nombre de rs y guardarlo en la variable nombre
     * 3.- obtener el valor del email de rs y guardarlo en la variable email
     */
    public void moverAnteriorRegistro(){
        System.out.print("Programa accion moverAnteriorRegistro");
        
        try {
            if (!rs.isFirst()) {
                rs.previous();
                nombre = rs.getString("nombre");
                email = rs.getString("email");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error 001" + ex.getMessage());
        }
    }
    
    /**
     * Método que realiza las siguiente acciones:
     * 1.- Moverse al ultimo registro
     * 2.- obtener el valor del nombre de rs y guardarlo en la variable nombre
     * 3.- obtener el valor del email de rs y guardarlo en la variable email
     */
    public void moverUltimoRegistro(){
        System.out.print("Programa accion moverUltimoRegistro");
        try {
            rs.last();
           nombre = rs.getString("nombre");
           email = rs.getString("email");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error 001" + ex.getMessage());
        }
    }
}
