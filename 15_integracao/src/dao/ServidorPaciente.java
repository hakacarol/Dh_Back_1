package dao;

import config.ConfigJDBC;
import model.Paciente;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ServidorPaciente implements IDao <Paciente> {

    private ConfigJDBC config = new ConfigJDBC();
    private static final Logger logger = Logger.getLogger(ServidorPaciente.class);

    @Override
    public void create() {

        String dropQuery = String.format("DROP TABLE Paciente IF EXISTS");
        String createQuery = String.format("CREATE TABLE IF NOT EXISTS Paciente(id int PRIMARY KEY AUTO_INCREMENT, " +
                "nome VARCHAR(100), sobrenome VARCHAR(100), rg VARCHAR(100), dataCadastro DATE, enderecoId INT NOT NULL)"
        );

        try {
            Connection connection = config.getConnectionH2();
            Statement statement = connection.createStatement();

            statement.execute(dropQuery);
            statement.execute(createQuery);
            statement.close();
            logger.info("Tabela Paciente foi criada");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Paciente insert(Paciente paciente) {
        String insertQuery = String.format("INSERT INTO Paciente (nome, sobrenome, rg,dataCadastro, enderecoId) VALUES ('%s', '%s', '%s', '%s', '%s')",
                paciente.getNome(),
                paciente.getSobrenome(),
                paciente.getRg(),
                paciente.getDataCadastro(),
                paciente.getEndereco().getId());

        String selectIdQuery = String.format("SELECT id FROM Paciente WHERE rg = %s",
                paciente.getRg());

        try {
            Connection connection = config.getConnectionH2();
            Statement statement = connection.createStatement();

            statement.execute(insertQuery);

            ResultSet resultSet = statement.executeQuery(selectIdQuery);

            while (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                paciente.setId(id);
            }

            statement.close();
            logger.info(String.format("Paciente com id %s foi incluido", paciente.getNome(), paciente.getSobrenome()));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return paciente;
    }

    @Override
    public void update(Integer id, String coluna, String valorNovo) {
        String updateQuery = String.format("UPDATE Paciente SET %s = '%s' WHERE id = '%s'",
                coluna, valorNovo, id);

        try {
            Connection connection = config.getConnectionH2();
            Statement statement = connection.createStatement();
            statement.execute(updateQuery);
            statement.close();
            logger.info(String.format("Paciente com id %s foi atualizado", id));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        String deleteQuery = String.format("DELETE FROM Paciente WHERE id = %s", id);

        try{
            Connection connection = config.getConnectionH2();
            Statement statement = connection.createStatement();
            statement.execute(deleteQuery);
            statement.close();
            logger.warn(String.format("Paciente com id %s foi deletado", id));

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public String select(Integer id) {
        String selectQuery = String.format("SELECT * FROM Paciente WHERE id = %s", id);
        String idBanco = "Está id não possui no banco";

        try{
            Connection connection = config.getConnectionH2();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(selectQuery);

            while(result.next()){
                idBanco = "Está id possui no banco";
                logger.info(String.format("\n***** \n%s \n%s \n%s \n%s \n%s \n%s \n*****",
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getInt(5),
                        result.getString(6)));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return idBanco;
    }

    @Override
    public void selectAll() {
        String selectQuery = String.format("SELECT * FROM Paciente");

        try{
            Connection connection = config.getConnectionH2();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(selectQuery);

            while(result.next()){
                logger.info(String.format("\n***** \n%s \n%s \n%s \n%s \n%s \n%s \n*****",
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getInt(5),
                        result.getString(6)));
            }
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}