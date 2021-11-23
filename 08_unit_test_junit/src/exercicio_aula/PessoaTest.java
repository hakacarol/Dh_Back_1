package exercicio_aula;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

public class PessoaTest {

    Pessoa pessoa01;
    Pessoa pessoa02;
    Pessoa pessoa03;

    @BeforeEach
    void doBefore() {
        pessoa01 = new Pessoa("Wheslley", "Rimar");
        pessoa01.setIdade(LocalDate.of(1990, 6, 23));

        pessoa02 = new Pessoa("Helena", "Martinez");
        pessoa02.setIdade(LocalDate.of(1990, 11, 12));

        pessoa03 = new Pessoa("Matheus", "Affonso");
        pessoa03.setIdade(LocalDate.of(1987, 11, 12));
    }

    @Test
    void getNomeCompleto() {
        assertEquals ("Wheslley Rimar", pessoa01.concatenarNomeCompleto());
    }

    @Test
    void getEMaiorOuIgual18() {
        assertEquals(pessoa02.eMaiorDeIdade(), true);
    }


}

