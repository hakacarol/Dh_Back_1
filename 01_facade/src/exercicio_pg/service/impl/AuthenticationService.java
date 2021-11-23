package exercicio_pg.service.impl;

import exercicio_pg.service.IBankService;

public class AuthenticationService implements IBankService {

    public Boolean validateIdAndPassword(Integer id, String password) {
        if (id != null && password != null) {
            System.out.println("Dados inválidos");
            return false;
        } else {
            System.out.println("Bem vindo!");
            return true;
        }
    }
    @Override
    public void useServices(String name, Integer id, String password) {
    }
}
