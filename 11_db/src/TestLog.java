import java.sql.*;

public class TestLog {

    private static final String sqlCreate = "CREATE TABLE Animal (Id INT PRIMARY KEY, Nome VARCHAR(100) NOT NULL, Tipo VARCHAR(120))";
    private static final String sqlDrop = "DROP TABLE IF EXISTS Animal";

    private static final String sqlInsert = "INSERT INTO Animal (Id, Nome, Tipo) VALUES(1, 'Baleia', 'Cachorro')";
    private static final String sqlInsert2 = "INSERT INTO Animal (Id, Nome, Tipo) VALUES(2, 'Amora', 'Cachorro')";
    private static final String sqlInsert3 = "INSERT INTO Animal (Id, Nome, Tipo) VALUES(3, 'Meg', 'Cachorro')";
    private static final String sqlInsert4 = "INSERT INTO Animal (Id, Nome, Tipo) VALUES(4, 'Tarta', 'Tartaruga')";
    private static final String sqlInsert5 = "INSERT INTO Animal (Id, Nome, Tipo) VALUES(5, 'Maria Aparecida', 'Gato')";

    private static final String sqlDelete = "DELETE FROM Animal WHERE Id=3";

    private static final String sqlSelect = "SELECT * FROM Animal";

    public static void main(String[] args) {
        Connection connection = null;

        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(sqlDrop);
            statement.execute(sqlCreate);

            statement.execute(sqlInsert);
            statement.execute(sqlInsert2);
            statement.execute(sqlInsert3);
            statement.execute(sqlInsert4);
            statement.execute(sqlInsert5);

            mostrarAnimais(connection);

            statement.execute(sqlDelete);

            System.out.println("-----------");

            mostrarAnimais(connection);

            statement.execute(sqlSelect);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void mostrarAnimais(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultado = statement.executeQuery(sqlSelect);

        while(resultado.next()) {
            System.out.println(resultado.getInt(1) + " " + resultado.getString(2) + " " +
                    resultado.getString(3));
            ;
        }
    }

    public static Connection getConnection() throws Exception{

        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
    }
}