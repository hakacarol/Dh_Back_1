package mesa_trabalho;

import mesa_trabalho.model.Contato;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Contato> contatos = new ArrayList<>();

        Contato contato01 = new Contato("Renata", "renata@gmail.com", "923451717");
        Contato contato02 = new Contato("Helena", "helena@uol.com", "923490017");
        Contato contato03 = new Contato("Adryana", "adryana@hotmail.com", "923444017");
        Contato contato04 = new Contato("Clarissa", "clarissa@gmail.com", "912444017");
        Contato contato05 = new Contato("Flavio", "flavio@hotmail.com", "912433017");
        Contato contato06 = new Contato("Ailla", "ailla@bol.com", "912433557");

        contatos.add(contato01);
        contatos.add(contato02);
        contatos.add(contato03);
        contatos.add(contato04);
        contatos.add(contato05);
        contatos.add(contato06);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("ListaContatos.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(contatos);

        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Contato> contatos02 = new ArrayList<>();

        try {
            FileInputStream fileInputStream = new FileInputStream("ListaContatos.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            contatos02 = (ArrayList) objectInputStream.readObject();

        }catch (Exception e) {
            e.printStackTrace();
        }

        for(Contato contato: contatos02) {
            System.out.println(String.format("Nome: %s Email: %s Telefone: %s",
                    contato.getNome(), contato.getEmail(), contato.getTelefone()));
    }
    }

}
