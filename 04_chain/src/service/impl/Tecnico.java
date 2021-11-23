package service.impl;

import model.Mail;
import service.CheckEmail;

public class Tecnico extends CheckEmail {

    @Override
    public void processarEmail(Mail mail, String nomeDestinatario) {
        String[] arrayMail = mail.getDestino().split("@");

        if(nomeDestinatario.equals("tecnico") && arrayMail[1].equals("colmeia.com")) {
            System.out.println("Esse Email é do Tecnico e chegou ao seu destinatário");
        } else {
            System.out.println("Esse Email é um SPAM");
        }
    }
}
