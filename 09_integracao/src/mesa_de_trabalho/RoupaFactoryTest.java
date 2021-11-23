package mesa_de_trabalho;

import mesa_de_trabalho.model.Roupa;
import mesa_de_trabalho.model.Tamanho;
import mesa_de_trabalho.model.Tipo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class RoupaFactoryTest {

    List<Roupa> listaRoupas = new ArrayList<>();
    RoupaFactory factory = new RoupaFactory();

    @BeforeEach
    void doBefore() {

        listaRoupas.add(factory.buscarRoupa(Tamanho.M, Tipo.CALÇA, true, true));
        listaRoupas.add(factory.buscarRoupa(Tamanho.M, Tipo.CALÇA, true, true));
        listaRoupas.add(factory.buscarRoupa(Tamanho.G, Tipo.CAMISA, true, true));
        listaRoupas.add(factory.buscarRoupa(Tamanho.G, Tipo.CAMISA, true, false));
        listaRoupas.add(factory.buscarRoupa(Tamanho.P, Tipo.CAMISA, true, false));

    }

    @Test
    void getRoupa() {
        assertEquals(Tamanho.M, listaRoupas.get(0).getTamanho());
    }

    @Test
    void getContador() {
        assertEquals(3, RoupaFactory.getContador());
    }

}
