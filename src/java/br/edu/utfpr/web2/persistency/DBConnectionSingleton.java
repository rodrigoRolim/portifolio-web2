package br.edu.utfpr.web2.persistency;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionSingleton {

    private static Connection conn;
    private static DBConnectionSingleton instance;
    private final String dbURL = "jdbc:mysql://localhost:3306/portfolio?autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final String username = "root"; 
    private final String password = "";
    DBConnectionSingleton() throws SQLException, ClassNotFoundException {
       Class.forName("com.mysql.cj.jdbc.Driver");
       conn = DriverManager.getConnection(dbURL, username, password);
    }
    public static synchronized Connection getInstance() throws SQLException, ClassNotFoundException {
        if (instance == null) 
           instance = new DBConnectionSingleton();
           
        return conn;
   }
}
