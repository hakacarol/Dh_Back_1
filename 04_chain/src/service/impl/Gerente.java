package service.impl;

import model.Mail;
import service.CheckEmail;

public class Gerente extends CheckEmail {

    @Override
    public void processarEmail(Mail mail, String nomeDestinatario) {

        if(nomeDestinatario.equals("gerente")) {
            System.out.println("Esse Email é do Gerente e chegou ao seu destinatário");
        } else {
            this.proximoDestinatario.processarEmail(mail, nomeDestinatario);
        }
    }
}
