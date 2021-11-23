package mesa_de_trabalho;

import mesa_de_trabalho.model.Roupa;
import mesa_de_trabalho.model.Tamanho;
import mesa_de_trabalho.model.Tipo;

import java.util.HashMap;
import java.util.Map;

public class RoupaFactory {
    private static Integer contador = 0;

    private static Map<String, Roupa> flyweight = new HashMap<>();

    public Roupa buscarRoupa(Tamanho tamanho, Tipo tipo, boolean eNova, boolean eImportada) {

        String id = "tamanho:" + tamanho + "tipo:" + tipo;

        if(!flyweight.containsKey(id)) {
            flyweight.put(id, new Roupa(tamanho, tipo, eNova, eImportada));
            contador++;
            System.out.println("Roupa nova criada!");
            System.out.println(flyweight.get(id).toString());

        } else {
            System.out.println("Esta roupa não existe...");
        }
        return flyweight.get(id);
    }

    public static Integer getContador() {
        return contador;
    }

    public static void setContador(Integer contador) {
        RoupaFactory.contador = contador;
    }
}
