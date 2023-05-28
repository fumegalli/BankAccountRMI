package br.edu.unisinos.distribuited.systems;

import java.math.BigDecimal;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            BankAccount account = (BankAccount) registry.lookup("BankAccount");

            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite o valor de depósito: R$");
            double depositAmount = scanner.nextDouble();
            account.deposit(BigDecimal.valueOf(depositAmount));

            System.out.print("Digite o valor de saque: R$");
            double withdrawAmount = scanner.nextDouble();
            account.withdraw(BigDecimal.valueOf(withdrawAmount));

            BigDecimal balance = account.getBalance();
            System.out.println("Saldo da conta: R$" + balance);
        } catch (Exception e) {
            System.out.println("Client error: " + e);
        }
    }
}
