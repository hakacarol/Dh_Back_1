package service;

import model.Funcionario;
import model.Tipo;

import java.text.DecimalFormat;
import java.util.Locale;

public abstract class PagamentoService {

    public void pagar(Funcionario funcionario) {

        funcionario.setSalarioFinal(calcularSalario(funcionario));
        Double salario = funcionario.getSalarioFinal();
        Locale.setDefault(Locale.US);
        DecimalFormat formato = new DecimalFormat("#.##");
        salario = Double.valueOf(formato.format(salario));

//        String resultado = String.format("%.2f", funcionario.getSalarioFinal());
        System.out.println(salario);

        System.out.println(depositarSalario(funcionario.getContaBancaria(), salario));
        System.out.println(emitirComprovante(funcionario.getTipo()));
    }

    private String depositarSalario(String conta, Double salario){
        return "Depositado do salario " + salario + " efetuado na conta " + conta;
    }

    private String emitirComprovante(Tipo tipo) {
        if (tipo == Tipo.CONTRATADO) {
            return "Recibo enviado por Email";
        } else if (tipo == Tipo.EFETIVO) {
            return "Recibo impresso com sucesso!";
        }

        return "Erro ao emitir o recibo";
    }

    protected abstract Double calcularSalario(Funcionario funcionario);
}
