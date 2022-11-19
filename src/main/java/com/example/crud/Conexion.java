/* Autor: SEBASTIÁN FACUNDO VERA */
package com.example.crud;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    private static final String URL = "jdbc:mysql://localhost:3306/nombre_base?autoReconnet=true&useSSL=false";
    private static final String USUARIO = "root";
    private static final String PASS = "";
    private static Connection con = null;

    public static Connection getConnection() {
        if (con==(null)) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(URL, USUARIO, PASS);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return con;
    }


}
