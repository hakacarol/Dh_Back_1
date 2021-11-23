package exercicio_aula;

import exercicio_aula.model.Cachorro;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // criando lista
        List<Cachorro> cachorros = new ArrayList<>();

        Cachorro dog01 = new Cachorro("Meg", 10);
        Cachorro dog02 = new Cachorro("Amora", 3);
        Cachorro dog03 = new Cachorro("Baleia", 3);

        cachorros.add(dog01);
        cachorros.add(dog02);
        cachorros.add(dog03);

        // serializacao
        // criar arquivo
        FileOutputStream fileOut;

        try {
            // criando lista cachorros
            fileOut = new FileOutputStream("ListaCachorros.txt");
            // criando o objeto
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            // colocando o objeto na lista
            objOut.writeObject(cachorros);

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();
        }

        // deserializacao
        // para ler um arquivo
        // criamos lista de cachorro
        List<Cachorro> cachorro02 = null;
        FileInputStream fileInput;

        try {
            //o arquivo q irá ser lido
            fileInput = new FileInputStream(("ListaCachorros.txt"));
            // transformando em objeto
            ObjectInputStream objInput = new ObjectInputStream(fileInput);

            // salvando o objeto na lista
            cachorro02 = (ArrayList) objInput.readObject();

        } catch (FileNotFoundException e) {
            System.out.println("Erro no arquivo");

        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Cachorro dog: cachorro02) {
            System.out.println("Nome: " + dog.getNome() + " Idade: " + dog.getIdade() );
        }
    }
}
