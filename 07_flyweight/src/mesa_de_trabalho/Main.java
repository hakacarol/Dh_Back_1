package mesa_de_trabalho;

import mesa_de_trabalho.model.Arvore;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArvoreFactory factory = new ArvoreFactory();
        Arvore ornamental = factory.buscarArvore(200, 400, "verde");
        Arvore frutifera = factory.buscarArvore(500, 300, "vermelha");
//        Arvore florifera = factory.buscarArvore(100, 200, "azul");

        ArrayList<Arvore> arvoreList = new ArrayList<>();
        for(int i=0; i<=500000; i++){
            arvoreList.add(ornamental);
            arvoreList.add(frutifera);
        }

        Runtime runtime = Runtime.getRuntime();
        System.out.println("Memória utilizada: " + (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024));
    }
}
