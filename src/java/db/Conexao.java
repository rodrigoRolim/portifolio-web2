package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static Connection instance;

    private Conexao() {
    }

    public static Connection getInstance() {
        if (instance == null) {
            try {
                return DriverManager.getConnection("jdbc:mysql://localhost/dbweb2", "root", "123");
            } catch (SQLException ex) {
                System.err.println("Erro na conexão: " + ex.getMessage());
                return null;
            }
        } else {
            return instance;
        }

    }
}
