package br.edu.unisinos.distribuited.systems;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public static void main(String[] args) {
        try {
            BankAccount account = new BankAccountImpl();
            BankAccount stub = (BankAccount) UnicastRemoteObject.exportObject(account, 0);
            Registry registry = LocateRegistry.createRegistry(1099);

            registry.rebind("BankAccount", stub);

            System.out.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.getMessage());
        }
    }
}
