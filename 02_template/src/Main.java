import model.Funcionario;
import model.FuncionarioContratado;
import model.FuncionarioEfetivo;
import model.Tipo;
import service.PagamentoService;
import service.impl.CalculoSalarialContratado;
import service.impl.CalculoSalarialEfetivo;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, PagamentoService> serviceMap = Map.of("Contratado", new CalculoSalarialContratado(), "Efetivo", new CalculoSalarialEfetivo());

        Funcionario efetivo = new FuncionarioEfetivo("Jose", "Silva", "12345", Tipo.EFETIVO, 2400.35);
        Funcionario contratado = new FuncionarioContratado("Maria", "Gomes", "67890", Tipo.CONTRATADO, 176, 35.08);

        PagamentoService service01 = serviceMap.get("Efetivo");
        service01.pagar(efetivo);

        PagamentoService service02 = serviceMap.get("Contratado");
        service02.pagar(contratado);
    }

}
