/* Autor: SEBASTIÁN FACUNDO VERA */
package com.example.crud;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    private static final String URL = "jdbc:mysql://eu-cdbr-west-03.cleardb.net:3306/heroku_cca90c3aa387efe?autoReconnet=true&useSSL=false";
    private static final String USUARIO = "b18ec6b31a816e";
    private static final String PASS = "f1ca3d3d";
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
