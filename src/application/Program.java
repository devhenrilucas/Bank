package application;

import model.entities.Account;
import model.entities.CurrentAccount;
import model.entities.SavingsAccount;
import model.exceptions.InsufficientBalanceException;
import model.exceptions.InvalidAmountException;

import java.time.LocalDate;
import java.util.*;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Account> accountList = new ArrayList<>();
        boolean running = true;

        while (running) {
            System.out.println("Bank System");

            System.out.println("1 - Create account");
            System.out.println("2 - Enter a account");
            System.out.println("3 - Aplicar updtade mensal");
            System.out.println("0 - Sair");
            int menu = sc.nextInt();

            switch (menu) {
                case (1):
                    System.out.println("1 - Conta Corrente");
                    System.out.println("2 - Conta Poupanca");

                    int typeAccount = sc.nextInt();

                    if (typeAccount == 1) {
                        System.out.print("Digite seu CPF: ");
                        String clientId = sc.next();
                        System.out.println("Limite de saque em cheque especial: ");
                        double overdraftLimit = sc.nextDouble();

                        Account ac = new CurrentAccount(clientId, 0.0, overdraftLimit);

                        System.out.print("Deseja fazer um deposito inicial (s/n)? ");
                        char canDeposit = sc.next().charAt(0);

                        if (canDeposit == 's' || canDeposit == 'S') {
                            System.out.print("Valor do deposito: ");
                            double valor = sc.nextDouble();
                            ac.deposit(valor);
                        }

                        accountList.add(ac);

                    } else if (typeAccount == 2) {
                        System.out.print("Digite seu CPF: ");
                        String clientId = sc.next();

                        Account ac = new SavingsAccount(clientId, 0.0);

                        System.out.print("Deseja fazer um deposito inicial (s/n)? ");
                        char canDeposit = sc.next().charAt(0);

                        if (canDeposit == 's' || canDeposit == 'S') {
                            System.out.print("Valor do deposito: ");
                            double valor = sc.nextDouble();
                            ac.deposit(valor);
                        }

                        accountList.add(ac);
                    }

                    break;

                case (2):

                    Account foundAccount = null;

                    System.out.print("Digite seu cpf: ");
                    String searchId = sc.next();

                    for (Account acc : accountList) {
                        if (acc.getClientId().equals(searchId)) {
                            foundAccount = acc;
                            break;
                        }
                    }

                    if (foundAccount == null) {
                        System.out.println("Conta nao encontrada!");
                        break;
                    }

                    System.out.println("Conta encontrada!");

                    boolean insideAccount = true;

                    while (insideAccount) {

                        System.out.println("Escolha uma opcao");
                        System.out.println("1 - Deposito");
                        System.out.println("2 - Saque");
                        System.out.println("3 - Consultar saldo");
                        System.out.println("0 - Voltar para o menu");

                        System.out.print("Opcao: ");
                        int option = sc.nextInt();

                        switch (option) {

                            case 1:
                                System.out.print("Valor de deposito: ");
                                double dep = sc.nextDouble();

                                try {
                                    foundAccount.deposit(dep);
                                    System.out.println("Deposito realizado com sucesso!");
                                } catch (InvalidAmountException e) {
                                    System.out.println("Erro: " + e.getMessage());
                                }
                                break;

                            case 2:
                                System.out.print("Valor de saque: ");
                                double wd = sc.nextDouble();

                                try {
                                    foundAccount.withdraw(wd);
                                    System.out.println("Saque realizado com sucesso!");
                                } catch (InsufficientBalanceException | InvalidAmountException e) {
                                    System.out.println("Erro: " + e.getMessage());
                                }
                                break;

                            case 3:
                                System.out.printf("Saldo atual: %.2f%n", foundAccount.getBalance());
                                break;

                            case 0:
                                insideAccount = false;
                                System.out.println("Voltando ao menu principal...");
                                break;

                            default:
                                System.out.println("Opcao invalida!");
                                break;
                        }
                    }
                    break;
                case (3):
                    if(accountList.isEmpty()) {
                        System.out.println("Nenhuma conta cadastrada!");
                    } else {
                        for (Account acc : accountList) {
                            acc.monthlyUpdate();
                        }
                    }
                    System.out.println("Atualizacao concluida!");
                    break;
                case (0):
                    running = false;
                    break;

                default:
                    System.out.println("Opcao invalida!");
                    break;


            }
        }
    }
}
