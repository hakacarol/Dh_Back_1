package dao.configuracao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfiguracaoJDBC{
    private String jdbcDriver;
    private String dbUrl;
    private String nomeUsuario;
    private String senhaUsuario;

    public ConfiguracaoJDBC(String jdbcDriver, String dbUrl, String nomeUsuario, String senhaUsuario) {
        this.jdbcDriver = jdbcDriver;
        this.dbUrl = dbUrl;
        this.nomeUsuario = nomeUsuario;
        this.senhaUsuario = senhaUsuario;
    }

    public ConfiguracaoJDBC () {
        this.jdbcDriver = "org.h2Driver";
        this.dbUrl = "jdbc:tcp:h2:~clinica;DB_CLOSE_DELAY=-1;INIT=RUNSCRIPT FROM 'CREATE.sql'";
        this.nomeUsuario = "sa";
        this.senhaUsuario = "";
    }

    public Connection conectarComBancoDeDados() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(
                    dbUrl,
                    nomeUsuario,
                    senhaUsuario
            );
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
