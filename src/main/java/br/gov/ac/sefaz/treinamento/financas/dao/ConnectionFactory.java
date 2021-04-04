package br.gov.ac.sefaz.treinamento.financas.dao;


import javax.print.DocFlavor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String URL_DB = "jdbc:mysql://localhost:3306/treinamento";
    private static final String USER_DB = "dev";
    private static final String SENHA_USER_DB = "";




    private static Connection criaConnection() throws ClassNotFoundException, SQLException {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL_DB, USER_DB, SENHA_USER_DB);
            System.out.println("Conexão feita com sucesso");
            return conn;
    }

    public static void main(String[] args) {
        try {
            criaConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
