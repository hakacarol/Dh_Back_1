import model.Estagiario;
import model.Funcionario;
import model.Vendedor;

public class Main {
    public static void main(String[] args) {
        Vendedor funcionario = new Funcionario("Maria");

        //Casting
        ((Funcionario)funcionario).setAnosEmpresa(4);
        funcionario.vender();
        funcionario.vender();
        funcionario.vender();
        funcionario.vender();


        //Casting
        Vendedor afiliado = ((Funcionario)funcionario).obterAfiliado("Marco Aurélio");
        afiliado.vender();
        afiliado.vender();

        Vendedor estagiario = new Estagiario("Andre");
        estagiario.vender();
        estagiario.vender();
        estagiario.vender();

        funcionario.mostrarCategoria();
        afiliado.mostrarCategoria();
        estagiario.mostrarCategoria();
    }
}
