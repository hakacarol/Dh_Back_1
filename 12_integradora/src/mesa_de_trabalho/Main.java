package mesa_de_trabalho;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.h2.Driver;

import java.sql.*;

public class Main {

    // criação dos objetos
    private static final Logger logger = Logger.getLogger(Main.class);

    private static final String createSql = "CREATE TABLE Funcionario " +
            "(Id INT PRIMARY KEY," +
            "primeiroNome VARCHAR(100) NULL," +
            "sobrenome VARCHAR(100) NOT NULL," +
            "idade INT NOT NULL," +
            "profissao VARCHAR(150))";

    // criação da tabela
    private static final String dropSql = "DROP TABLE IF EXISTS Funcionario";

    // criação das variáveis
    private static final String insertSql =
            "INSERT INTO Funcionario (Id, primeiroNome, sobrenome, idade, profissao) VALUES (1, 'Marcolerio', 'Vidoti', 32, 'arquiteto')";
    private static final String insertSql2 =
            "INSERT INTO Funcionario (Id, primeiroNome, sobrenome, idade, profissao) VALUES (1, 'Camila', 'Labella', 29, 'arquiteta')";
    private static final String insertSql3 =
            "INSERT INTO Funcionario (Id, primeiroNome, sobrenome, idade, profissao) VALUES (3, 'Renan', 'Silveira', 31, 'engenheiro')";
    private static final String selectAllSql =
            "SELECT * FROM Funcionario";
    private static final String updateSql =
            "UPDATE Funcionario SET primeiroNome = 'Marco Aurélio' WHERE primeiroNome = 'Marcolerio'";
    private static final String deleteSql =
            "DELETE FROM Funcionario WHERE id = 3";
    private static final String selectSql =
            "SELECT * FROM Funcionario WHERE id = 1";


    public static void main(String[] args) {
        PropertyConfigurator.configure("log4j.properties");

        Connection connection = null;

        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(dropSql);
            statement.execute(createSql);

            statement.execute(insertSql);
            statement.execute(insertSql3);

            showFuncionarios(connection);

            statement.execute(deleteSql);

            statement.execute(updateSql);
            selectFuncionario(connection);

            showFuncionarios(connection);

            try {
                statement.execute(insertSql2);
            } catch (Exception e) {
                logger.warn(e.getMessage());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void showFuncionarios(Connection connection) throws SQLException {
        Statement  statement = connection.createStatement();
        ResultSet result = statement.executeQuery(selectAllSql);

        while(result.next()){
            logger.info(String.format("%s %s",
                    result.getString(2),
                    result.getString(3))
            );
        }
    }

    private static void selectFuncionario(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(selectSql);

        while(result.next()){
            logger.debug(String.format("%s %s %s",
                    result.getString(1),
                    result.getString(2),
                    result.getString(3))
            );
        }
    }

    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
    }
}
