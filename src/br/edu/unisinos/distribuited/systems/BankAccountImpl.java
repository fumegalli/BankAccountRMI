package br.edu.unisinos.distribuited.systems;

import java.math.BigDecimal;
import java.rmi.RemoteException;

public class BankAccountImpl implements BankAccount {
    private BigDecimal balance;

    public BankAccountImpl() throws RemoteException {
        balance = BigDecimal.ZERO;
    }

    @Override
    public void deposit(BigDecimal amount) throws RemoteException {
        balance = balance.add(amount);
    }

    @Override
    public void withdraw(BigDecimal amount) throws RemoteException {
        if (balance.compareTo(amount) >= 0) {
            balance = balance.subtract(amount);
        } else {
            throw new RemoteException("Saldo Insuficiente");
        }
    }

    @Override
    public BigDecimal getBalance() throws RemoteException {
        return balance;
    }
}
