package dao;

import model.Dentista;
import org.apache.log4j.PropertyConfigurator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServidorDentistaTest {

    Dentista dentista01;
    Dentista dentista02;
    Dentista dentista03;
    Dentista dentista04;
    Dentista dentista05;
    ServidorDentista servidorDentista;

    @BeforeEach
    void doBefore(){
        PropertyConfigurator.configure("log4j.properties");

        servidorDentista = new ServidorDentista();
        servidorDentista.create();

        dentista01 = new Dentista("12345", "Renata", "Antonelli");
        dentista02 = new Dentista("12346", "Marcolério", "Vidoti");
        dentista03 = new Dentista("12347", "Renan", "Mofo");
        dentista04 = new Dentista("12348", "Adriane", "Fernandes");
        dentista05 = new Dentista("12349", "Camila", "Labella");

        servidorDentista.insert(dentista01);
        servidorDentista.insert(dentista02);
        servidorDentista.insert(dentista03);
        servidorDentista.insert(dentista04);
        servidorDentista.insert(dentista05);
    }

    @Test
    void selectAll() {
        ArrayList<String> dentistasInfoCadastroSelectAll = servidorDentista.selectAll();
        ArrayList<String> dentistasInfoCadastro = new ArrayList<>();

        String dentistasInfoCadastro01 = String.format("\n------ \n%s \n%s \n%s \n%s \n------",
                dentista01.getId(),
                dentista01.getNumeroMatricula(),
                dentista01.getNome(),
                dentista01.getSobrenome());

        String dentistasInfoCadastro02 = String.format("\n------ \n%s \n%s \n%s \n%s \n------",
                dentista02.getId(),
                dentista02.getNumeroMatricula(),
                dentista02.getNome(),
                dentista02.getSobrenome());

        String dentistasInfoCadastro03 = String.format("\n------ \n%s \n%s \n%s \n%s \n------",
                dentista03.getId(),
                dentista03.getNumeroMatricula(),
                dentista03.getNome(),
                dentista03.getSobrenome());

        String dentistasInfoCadastro04 = String.format("\n------ \n%s \n%s \n%s \n%s \n------",
                dentista04.getId(),
                dentista04.getNumeroMatricula(),
                dentista04.getNome(),
                dentista04.getSobrenome());

        String dentistasInfoCadastro05 = String.format("\n------ \n%s \n%s \n%s \n%s \n------",
                dentista05.getId(),
                dentista05.getNumeroMatricula(),
                dentista05.getNome(),
                dentista05.getSobrenome());

        dentistasInfoCadastro.add(dentistasInfoCadastro01);
        dentistasInfoCadastro.add(dentistasInfoCadastro02);
        dentistasInfoCadastro.add(dentistasInfoCadastro03);
        dentistasInfoCadastro.add(dentistasInfoCadastro04);
        dentistasInfoCadastro.add(dentistasInfoCadastro05);

        assertEquals(dentistasInfoCadastro, dentistasInfoCadastroSelectAll);
    }
}
