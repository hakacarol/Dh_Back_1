package exercicio_aula;

import exercicio_aula.model.Computador;

public class Main {
    public static void main(String[] args) {

        ComputadorFactory factory = new ComputadorFactory();
        Computador cpu01Mac = factory.buscarComputador(8, 500);
        Computador cpu02Windows = factory.buscarComputador(16, 128);
        Computador cpu03Windows = factory.buscarComputador(16, 128);

        System.out.println(cpu01Mac.toString());
        System.out.println(cpu02Windows.toString());
        System.out.println(cpu03Windows.toString());
    }
}
