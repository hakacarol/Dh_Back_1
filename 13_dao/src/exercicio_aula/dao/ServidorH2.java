package exercicio_aula.dao;

import exercicio_aula.config.ConfigJDBC;
import exercicio_aula.model.Medicamento;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ServidorH2 implements IDao<Medicamento>{

    private ConfigJDBC config = new ConfigJDBC();

    private static final Logger logger = Logger.getLogger(ServidorH2.class);

    @Override
    public Medicamento insert(Medicamento medicamento) {
        String query = String.format("INSERT INTO Medicamento VALUES ('%s', '%s', '%s', '%s', '%s', '%s')",
                medicamento.getId(),
                medicamento.getCodigoNumerico(),
                medicamento.getNome(),
                medicamento.getLaboratorio(),
                medicamento.getQuantidade(),
                medicamento.getPreco());

        try{
            // criando uma execução
            Connection connection = config.getConnectionH2();
            Statement stmt = connection.createStatement();

            // executando a query, não retorna nada / para retornar utilizar o executeQuery()
            stmt.execute(query);

            // fechando o Statement
            stmt.close();
            logger.info(String.format("Mediacamento %s foi incluído", medicamento.getNome()));

        }catch (Exception e){
            e.printStackTrace();
        }
        return medicamento;
    }

    @Override
    public void delete(Integer id) {
        String query = String.format("DELETE FROM Medicamento WHERE id = %s", id);

        try{
            Connection connection = config.getConnectionH2();
            Statement stmt = connection.createStatement();
            stmt.execute(query);
            stmt.close();
            logger.info(String.format("Mediacamento com id %s foi deletado", id));

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void select(Integer id) {
        String query = String.format("SELECT * FROM Medicamento WHERE id = %s", id);

        try{
            Connection connection = config.getConnectionH2();
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(query);

            // vai me dizer se terá um próximo resultado e dirá a hora de parar
            while(result.next()){
                logger.info(String.format("--------------------"));
                logger.info(String.format("\n%s \n%s \n%s \n%s \n%s \n%s",
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getInt(5),
                        result.getDouble(6)));
                logger.info(String.format("--------------------"));

            }
            stmt.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void selectAll() {
        String query = String.format("SELECT * FROM Medicamento");

        try{
            Connection connection = config.getConnectionH2();
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(query);

            while(result.next()){
                logger.info(String.format("--------------------"));
                logger.info(String.format("\n%s \n%s \n%s \n%s \n%s \n%s",
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getInt(5),
                        result.getDouble(6)));
                logger.info(String.format("--------------------"));
            }
            stmt.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void selectCodigo(String codigo) {
        String query = String.format("SELECT * FROM Medicamento WHERE codigoNumerico = %s", codigo);

        try{
            Connection connection = config.getConnectionH2();
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(query);

            while(result.next()){
                logger.info(String.format("--------------------"));
                logger.info(String.format("\n%s \n%s \n%s \n%s \n%s \n%s",
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getInt(5),
                        result.getDouble(6)));
                logger.info(String.format("--------------------"));
            }
            stmt.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
