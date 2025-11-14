package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException; // Importação adicionada

public class User {
     
    public Connection conectarBD() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.Driver.Manager").newInstance();
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
        // Retorna a conexão 
        return conn;
    }

    //Verifica se um usuário existe no banco
     
    public boolean verificarUsuario(String login, String senha) {
        
        sql += "select nome from usuarios where login = '" + login + "' and senha = '" + senha + "';";

        // Verifica a conx
        if (conn == null) {
            System.err.println("Falha na conexão. Não é possível verificar o usuário.");
            return false; // Retorna false se a conexão falhar (tratamento de NullPointer adicionado)
        }

        Statement st = null;
        ResultSet rs = null;

        try {
            // Statement
            st = conn.createStatement();
            // Query
            rs = st.executeQuery(sql);

            // Verifica se há um próximo registro 
            if (rs.next()) {
                result = true;
                nome = rs.getString("nome"); // Obtém o nome do usuário
            }
        } catch (SQLException e) {
            // Deveria ser logada ou relançada.
            System.err.println("Erro ao executar a query SQL: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }

        // Retorna o resultado 
        return result;
    }
} 
