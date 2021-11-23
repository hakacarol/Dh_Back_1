import model.Mail;
import service.CheckEmail;
import service.impl.Comercial;
import service.impl.Gerente;
import service.impl.Tecnico;

public class Main {
    public static void main(String[] args) {
        Mail mail01 = new Mail("joao@gmail.com", "comercial@colmeia.com", "Spring Boot");
        Mail mail02 = new Mail("maria@gmail.com", "tecnico@colmeia.com", "Spring Boot");
        Mail mail03 = new Mail("maria@gmail.com", "natural@colmeia.com", "Spring Boot");

        //Mail[] arrayEmail = {mail01, mail02};

        String[] emailValidado = mail01.getDestino().split("@");

        CheckEmail checkEmail;

        if(emailValidado[1].equals("colmeia.com")){
            checkEmail = new Gerente().setProximoDestinatario(new Comercial().setProximoDestinatario(new Tecnico()));
        } else {
            checkEmail = new Tecnico(); //o spam esta no definido no tecnico
        }

        checkEmail.processarEmail(mail01, emailValidado[0]);

        //for(Mail a: arrayEmail){
        //    checkEmail.processarEmail(a);
        //}

        //checkEmail.processarEmail(mail01);
        //checkEmail.processarEmail(mail02);
        //checkEmail.processarEmail(mail03);
    }

}
