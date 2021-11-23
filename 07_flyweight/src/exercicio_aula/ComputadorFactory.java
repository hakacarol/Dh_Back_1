package exercicio_aula;

import exercicio_aula.model.Computador;

import java.util.HashMap;
import java.util.Map;

public class ComputadorFactory {

    private static Map<String, Computador> flymweight = new HashMap<>();

    public Computador buscarComputador(Integer ram, Integer hd){

        String id = "ram:" + ram + "hd:" + hd;

//      if(flymweight.containsKey(id)) {
        if(!flymweight.containsKey(id)) {
            flymweight.put(id, new Computador(ram, hd));
            System.out.println("Computador criado!");
//          return flymweight.get(id); // get() - existe dentro do HashMap
        } else {
            System.out.println("Computador já existe!");
        }

//        flymweight.put(id, new Computador(ram, hd));
//        System.out.println("Computador criado!");
        return  flymweight.get(id);
    }
}
