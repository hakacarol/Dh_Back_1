package mesa_de_trabalho;

import mesa_de_trabalho.server.SerieNaoHabilitadaException;
import mesa_de_trabalho.server.impl.SerieProxy;

public class Main {
    public static void main(String[] args) {

        SerieProxy serie = new SerieProxy();
        try {
            System.out.println(serie.getSerie("blabla01"));
            System.out.println(serie.getSerie("blabla02"));
            System.out.println(serie.getSerie("blabla03"));
            System.out.println(serie.getSerie("blabla04"));
            System.out.println(serie.getSerie("blabla05"));
            System.out.println(serie.getSerie("blabla06"));

        } catch (SerieNaoHabilitadaException exception) {
            System.out.println(exception.getMessage());
        }
    }
}

// toda vez q eu crio exception trata ele (try e catch)
