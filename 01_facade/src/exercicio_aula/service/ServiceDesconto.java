package exercicio_aula.service;

import exercicio_aula.externo_api.ApiCartao;
import exercicio_aula.externo_api.ApiProduto;
import exercicio_aula.externo_api.ApiQuantidade;
import exercicio_aula.interfac.IDesconto;
import exercicio_aula.model.Cartao;
import exercicio_aula.model.Produto;

public class ServiceDesconto implements IDesconto {

    private ApiCartao apiCartao = new ApiCartao();
    private ApiProduto apiProduto = new ApiProduto();
    private ApiQuantidade apiQuantidade = new ApiQuantidade();


    @Override
    public Double calcularDesconto(Cartao cartao, Produto produto, Integer quantidade) {

        Double desconto = 0.00;  //variavel somente está utilizada dentro do calcular desconto, por isso não tem o public/private

        desconto = desconto + apiCartao.checkDesconto(cartao.getBanco());
        desconto += apiProduto.checkDesconto(produto.getTipo());
        desconto += apiQuantidade.checkDesconto(quantidade);
        return desconto;

    }
}
