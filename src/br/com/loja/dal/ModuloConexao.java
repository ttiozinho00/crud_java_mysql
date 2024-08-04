package br.com.loja.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ModuloConexao {

    // Private constructor to prevent instantiation
    private ModuloConexao() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    // Method to establish a connection with the database
    public static Connection conector() {
        Connection conexao = null;

        // Define JDBC driver and database URL
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/crudjava?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "Douglas123@";

        // Establish a connection to the database
        try {
            // Load the JDBC driver
            Class.forName(driver);

            // Create a connection using DriverManager
            conexao = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão estabelecida com sucesso.");

        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC não encontrado.");
            // Added to print stack trace for debugging

        } catch (SQLException e) {
            System.out.println("Falha ao estabelecer conexão com o banco de dados.");
            // Added to print stack trace for debugging
        }

        return conexao;
    }
}
