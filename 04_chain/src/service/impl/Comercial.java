package service.impl;

import model.Mail;
import service.CheckEmail;

public class Comercial extends CheckEmail {

    @Override
    public void processarEmail(Mail mail, String nomeDestinatario) {

        if(nomeDestinatario.equals("comercial")){
            System.out.println("Esse Email é do Comercial e chegou ao seu destinatário");
        } else {
            this.proximoDestinatario.processarEmail(mail, nomeDestinatario);
        }
    }
}
