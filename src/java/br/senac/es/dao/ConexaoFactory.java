/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.es.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

    public static Connection getConnection() throws SQLException, ClassNotFoundException {

        Connection conn = null;

        String drive = "com.mysql.jdbc.Driver";
        String banco = "jdbc:mysql://localhost:3306/bd_webservice";
        String usuarioBD = "root";
        String senha = "";

        try {
            Class.forName(drive);
            conn = DriverManager.getConnection(banco, usuarioBD, senha);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return conn;
    }
}
