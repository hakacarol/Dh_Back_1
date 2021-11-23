package service.impl;

import model.Funcionario;
import model.FuncionarioContratado;
import service.PagamentoService;

public class CalculoSalarialContratado extends PagamentoService {

    @Override
    protected Double calcularSalario(Funcionario funcionario) {
        FuncionarioContratado contratado = ((FuncionarioContratado) funcionario);

        return contratado.getValorHora() + contratado.getNumHoras();
    }
}
