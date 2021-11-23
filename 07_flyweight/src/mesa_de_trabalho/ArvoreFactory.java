package mesa_de_trabalho;

import mesa_de_trabalho.model.Arvore;

import java.util.HashMap;
import java.util.Map;

public class ArvoreFactory {

    private static Map<String, Arvore> flyweight = new HashMap<>();

    public Arvore buscarArvore(Integer altura, Integer largura, String cor) {

        String id = "altura:" + altura + "largura:" + largura + "cor:" + cor;

        if(!flyweight.containsKey(id)) {
            flyweight.put(id, new Arvore(altura, largura, cor));
            System.out.println("Arvore criada");
        }

        return flyweight.get(id);
    }
}
