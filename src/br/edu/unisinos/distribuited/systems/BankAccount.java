package br.edu.unisinos.distribuited.systems;

import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BankAccount extends Remote {
    void deposit(BigDecimal amount) throws RemoteException;

    void withdraw(BigDecimal amount) throws RemoteException;

    BigDecimal getBalance() throws RemoteException;
}
