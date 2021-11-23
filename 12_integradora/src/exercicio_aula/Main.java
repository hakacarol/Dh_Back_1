package exercicio_aula;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.sql.*;

public class Main {

    private static  final Logger logger = Logger.getLogger(Main.class);

    private static final String createSql =
            "CREATE TABLE Usuario (Id INT PRIMARY KEY," +
            "primeiroNome VARCHAR2 NOT NULL," +
            "sobrenome VARCHAR2 NOT NULL," +
            "idade INT NOT NULL)";

    private static final String dropSql = "DROP TABLE IF EXISTS usuario";

    private static final String insertSql =
            "INSERT INTO Usuario (Id, primeiroNome, sobrenome, idade) VALUES (1, 'Adryana', 'Portugal', 21)";

    private static final String insertSql2 =
            "INSERT INTO Usuario (Id, primeiroNome, sobrenome, idade) VALUES (2, 'Felipe', 'Rosa', 34)";

    private static final String insertSql3 =
            "INSERT INTO Usuario (Id, primeiroNome, sobrenome, idade) VALUES (3, 'Vinicius', 'Mendes', 18)";

    private  static final String deleteSql = "DELETE FROM usuario WHERE id = 2";

    private static final String selectSql = "SELECT * FROM Usuario";


    public static void main(String[] args) {
        PropertyConfigurator.configure("log4j.properties");

        Connection connection = null;

        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(dropSql);
            statement.execute(createSql);

            statement.execute(insertSql);
            statement.execute(insertSql2);
            statement.execute(insertSql3);
            showUsuarios(connection);

            statement.execute(deleteSql);
            logger.info("O Usuario Felipe foi deletado");

            showUsuarios(connection);

//            //Select
//            ResultSet result = statement.execute(deleteSql);
//
//            while(result.next()) {
//                logger.info("O usuario " + result.getNString(2));
//            }
            logger.info("O usuario Felipe");


        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void showUsuarios(Connection connection) throws SQLException {
        Statement  statement = connection.createStatement();
        ResultSet result = statement.executeQuery(selectSql);

//        while(result.next()) {
//            logger.warn("Usuario " + result.getString(2) + " " + result.getString(3));
//        }
    }

    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
    }
}
