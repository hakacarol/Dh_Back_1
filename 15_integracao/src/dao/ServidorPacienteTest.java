package dao;
//    Adicione um paciente com endereço e pesquise no banco de dados pelo ID;
//    2. Exclua o paciente criado anteriormente e procure-o;
//    3. Pesquise e imprima no console todos os pacientes com seus endereços,
//       serão listados todos os pacientes que incluímos antes de realizar o
//       primeiro teste.

import model.Endereco;
import model.Paciente;
import org.apache.log4j.PropertyConfigurator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServidorPacienteTest {
    Paciente paciente01;
    Paciente paciente02;
    Paciente paciente03;
    Paciente paciente04;
    Endereco endereco01;
    Endereco endereco02;
    Endereco endereco03;
    Endereco endereco04;
    ServidorPaciente servidorPaciente;
    ServidorEndereco servidorEndereco;

    @BeforeEach
    void doBefore() {
        PropertyConfigurator.configure("log4j.properties");

        endereco01 = new Endereco("Santos", "245", "Sao Paulo", "Sao Paulo");
        endereco02 = new Endereco("Pio XII", "649", "Maceio", "Alagoas");
        endereco03 = new Endereco("Piaui", "123", "Campinas", "Sao Paulo");

        paciente01 = new Paciente("Maria", "Bethania", "12345678", endereco01);
        paciente02 = new Paciente("Caetano", "Veloso", "12341234", endereco02);
        paciente03 = new Paciente("Leandro", "Roque de Oliveira", "12345678", endereco03);

        servidorEndereco = new ServidorEndereco();
        servidorEndereco.create();
        servidorEndereco.insert(endereco01);
        servidorEndereco.insert(endereco02);
        servidorEndereco.insert(endereco03);

        servidorPaciente = new ServidorPaciente();
        servidorPaciente.create();
        servidorPaciente.insert(paciente01);
        servidorPaciente.insert(paciente02);
        servidorPaciente.insert(paciente03);

        servidorPaciente.selectAll();
    }

    @Test
    void insert() {
        endereco04 = new Endereco("dos Bobos", "0", "Pallet", "Kanto");
        servidorEndereco.insert(endereco04);

        paciente04 = new Paciente("Ash", "Ketchum", "01023923", endereco04);
        servidorPaciente.insert(paciente04);
        servidorPaciente.select(4);
        servidorPaciente.delete(4);

        assertEquals("Está id não possui no banco", servidorPaciente.select(4));
    }
}
