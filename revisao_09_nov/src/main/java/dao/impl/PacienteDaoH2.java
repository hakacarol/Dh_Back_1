package dao.impl;

import dao.IDao;
import dao.configuracao.ConfiguracaoJDBC;
import model.Paciente;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class PacienteDaoH2 implements IDao<Paciente> {


    Logger log = Logger.getLogger(PacienteDaoH2.class);
    private ConfiguracaoJDBC configuracaoJDBC;

    @Override
    public Paciente salvar(Paciente paciente) {
        Connection conexao = configuracaoJDBC.conectarComBancoDeDados();
        Statement statement = null;
        String query = String.format("INSERT INTO paciente (nome) VALUES ('%s')",
        paciente.getNome());

        try {
            log.debug("Iniciando conexão com o banco - Paciente");
            log.info("Iniciando conexão com o banco - Paciente");
            statement = conexao.createStatement();
            statement.executeUpdate(query,Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = statement.getGeneratedKeys();

            if(keys.next())
                paciente.setId(keys.getInt(1));
            statement.close();

        } catch (SQLException e){
            e.printStackTrace();
        }
        return paciente;
    }

    @Override
    public Optional<Paciente> buscar(Integer id) {
        return Optional.empty();
    }

    @Override
    public void excluir(Integer id) {

    }

    @Override
    public List<Paciente> buscarTodos() {
        return null;
    }
}
