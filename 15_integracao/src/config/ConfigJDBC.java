package config;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConfigJDBC {

    public static Connection getConnectionH2() throws Exception {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
    }
}
