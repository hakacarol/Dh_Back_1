package exercicio_pg.service.impl;

import exercicio_pg.service.IBankService;

public class AccountService implements IBankService {
    private int balance;

    public int getBalance() {
        return balance;
    }

    public int getConta(){
        System.out.println("Seu saldo atual: ");
        return this.getBalance();
    }

    @Override
    public void useServices(String name, Integer id, String password) {
    }
}
