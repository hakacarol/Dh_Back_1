package dao;

import configJDBC.ConfigJDBC;
import model.Dentista;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ServidorDentista implements IDao<Dentista> {

    private ConfigJDBC configJDBC = new ConfigJDBC();
    private static final Logger logger = Logger.getLogger(ServidorDentista.class);

    @Override
    public void create() {

        String dropQuery = String.format("DROP TABLE Dentista IF EXISTS");
        String createQuery = String.format("CREATE TABLE IF NOT EXISTS Dentista(id int PRIMARY KEY AUTO_INCREMENT, " +
                "numeroMatricula VARCHAR(100), nome VARCHAR(100), sobrenome VARCHAR(100))");

        try {
            Connection connection = configJDBC.getConnectionH2();
            Statement statement = connection.createStatement();

            statement.execute(dropQuery);
            statement.execute(createQuery);
            statement.close();
            logger.info("Tabela Dentista foi criada");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Dentista insert(Dentista dentista) {

        String insertQuery = String.format("INSERT INTO Dentista (numeroMatricula, nome, sobrenome) VALUES ('%s', '%s', '%s')",
                dentista.getNumeroMatricula(),
                dentista.getNome(),
                dentista.getSobrenome());

        String selectIdQuery = String.format("SELECT id FROM Dentista WHERE numeroMatricula = %s",
                dentista.getNumeroMatricula(),
                dentista.getNome(),
                dentista.getSobrenome());

        try {
            Connection connection = configJDBC.getConnectionH2();
            Statement statement = connection.createStatement();
            statement.execute(insertQuery);

            ResultSet resultSet = statement.executeQuery(selectIdQuery);

            while (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                dentista.setId(id);
            }
            statement.close();
            logger.info(String.format("Dentista com id %s foi incluido", dentista.getId()));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dentista;
    }

    @Override
    public void select(Integer id) {
        String selectQuery = String.format("SELECT * FROM Dentista WHERE id = %s", id);

        try{
            Connection connection = configJDBC.getConnectionH2();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(selectQuery);

            while(result.next()){
                logger.info(String.format("\n------ \n%s \n%s \n%s \n%s \n------ ",
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4)));
            }
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList selectAll() {
        String selectQuery = String.format("SELECT * FROM Dentista");
        ArrayList<String> selectAllInfoCadastro = new ArrayList<>();

        try{
            Connection connection = configJDBC.getConnectionH2();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(selectQuery);

            while(result.next()){
                String dentistaInfoCadastro = String.format("\n------ \n%s \n%s \n%s \n%s \n------",
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4));

                logger.info(dentistaInfoCadastro);
                selectAllInfoCadastro.add(dentistaInfoCadastro);
            }
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return selectAllInfoCadastro;
    }

    @Override
    public void update(Integer id, String coluna, String novoValor) {
        String updateQuery = String.format("UPDATE Dentista SET %s = '%s' WHERE id = '%s'",
                coluna, novoValor, id);

        try {
            Connection connection = configJDBC.getConnectionH2();
            Statement statement = connection.createStatement();
            statement.execute(updateQuery);
            statement.close();
            logger.info(String.format("Dentista com id %s foi atualizado", id));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        String deleteQuery = String.format("DELETE FROM Dentista WHERE id = %s", id);

        try{
            Connection connection = configJDBC.getConnectionH2();
            Statement statement = connection.createStatement();
            statement.execute(deleteQuery);
            statement.close();
            logger.warn(String.format("Dentista com id %s foi deletado", id));

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
