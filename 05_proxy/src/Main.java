import model.Pessoa;
import server.IVacinacao;
import server.impl.VacinacaoProxy;
import server.impl.VacinacaoService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        Date data = formatoData.parse("14/10/2021");

        Pessoa pessoa = new Pessoa("Lucas", "Pagia", "36070642", "H1N1", data);

        IVacinacao proxy = new VacinacaoProxy(new VacinacaoService());

        proxy.vacinar(pessoa);
    }
}
