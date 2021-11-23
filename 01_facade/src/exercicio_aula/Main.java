package exercicio_aula;

import exercicio_aula.model.Cartao;
import exercicio_aula.model.Produto;
import exercicio_aula.service.ServiceDesconto;

public class Main {
    public static void main(String[] args) {

        Cartao cartao01 = new Cartao("12345", "Itau");
        Produto produto01 = new Produto("leite", "caixa");

        ServiceDesconto service = new ServiceDesconto();

        System.out.println(service.calcularDesconto(cartao01, produto01, 13));
    }
}
