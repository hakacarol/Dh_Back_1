package exercicio_aula.interfac;

import exercicio_aula.model.Cartao;
import exercicio_aula.model.Produto;

public interface IDesconto {
    public Double calcularDesconto(Cartao cartao, Produto produto, Integer quantidade);
}
