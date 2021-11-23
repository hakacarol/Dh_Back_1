package service.impl;

import model.Funcionario;
import model.FuncionarioEfetivo;
import service.PagamentoService;

public class CalculoSalarialEfetivo extends PagamentoService {

    @Override
    protected Double calcularSalario(Funcionario funcionario) {
        FuncionarioEfetivo efetivo = ((FuncionarioEfetivo) funcionario);
        Double salario = efetivo.getSalarioBase(); // Salario Base
        salario = salario - (efetivo.getSalarioBase() * efetivo.getDesconto() / 100); // Salario - Descontos
        salario += (salario * efetivo.getBeneficio() / 100); // Salario(com descontos) + beneficios

        return salario;
    }
}
