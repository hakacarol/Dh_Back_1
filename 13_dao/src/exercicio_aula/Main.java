package exercicio_aula;

import exercicio_aula.dao.ServidorH2;
import exercicio_aula.model.Medicamento;
import org.apache.log4j.PropertyConfigurator;

public class Main {
    public static void main(String[] args) {
        // executa a configuração do log4j
        PropertyConfigurator.configure("log4j.properties");

        Medicamento med = new Medicamento(1,"12345","Dorflex", "NeoQuimica",15, 8.50);
        ServidorH2 servidor = new ServidorH2();

        // chamando as funções
        servidor.insert(med);
        servidor.select(med.getId());
        servidor.selectAll();
        servidor.delete(med.getId());
    }
}
