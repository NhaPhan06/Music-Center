/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author PhongNha
 */
public class DBUtils {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=PianoMusicCenter";
        conn = DriverManager.getConnection(url, "sa", "123456789");
        return conn;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        System.out.println(DBUtils.getConnection());
    }
}
