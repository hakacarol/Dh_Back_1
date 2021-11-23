package dao;
import static org.junit.jupiter.api.Assertions.assertEquals;

import model.Endereco;
import org.apache.log4j.PropertyConfigurator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ServidorEnderecoTest {
    Endereco endereco01;
    Endereco endereco02;
    Endereco endereco03;
    ServidorEndereco servidorEndereco;

    @BeforeEach
    void doBefore() {
        PropertyConfigurator.configure("log4j.properties");

        servidorEndereco = new ServidorEndereco();
        servidorEndereco.create();
        endereco01 = new Endereco("Santos", "245", "Sao Paulo", "Sao Paulo");
        endereco02 = new Endereco("Pio XII", "649", "Maceio", "Alagoas");
        endereco03 = new Endereco("Piaui", "123", "Campinas", "Sao Paulo");
    }

    @Test
    void insert() {
        servidorEndereco.insert(endereco01);
        String resultado01 = servidorEndereco.selectColuna(endereco01.getId(), "rua");
        assertEquals("Santos", resultado01);

        servidorEndereco.insert(endereco02);
        String resultado02 = servidorEndereco.selectColuna(endereco02.getId(), "rua");
        assertEquals("Pio XII", resultado02);

        servidorEndereco.insert(endereco03);
        String resultado03 = servidorEndereco.selectColuna(endereco03.getId(), "rua");
        assertEquals("Piaui", resultado03);
    }
}