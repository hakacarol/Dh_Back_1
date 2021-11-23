package exercicio_aula.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConfigJDBC {

    // criando conexão com o banco de dados
    public static Connection getConnectionH2() throws Exception {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
    }
}
