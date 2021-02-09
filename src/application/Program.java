package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.BalanceException;
import model.exceptions.WithdrawException;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter Account Data: ");
			System.out.print("Number: ");
			int number = sc.nextInt();
			System.out.print("Holder: ");
			sc.nextLine();
			String holder = sc.nextLine();
			System.out.print("Initial Balance: ");
			Double balance = sc.nextDouble();
			System.out.print("Withdraw Limit: ");
			Double withdrawLimit = sc.nextDouble();
			
			Account acc = new Account(number, holder, balance, withdrawLimit);

			System.out.print("\nDigite a quantidade de deseja sacar: ");
			Double amount = sc.nextDouble();
			acc.withdraw(amount);
			System.out.print("New Balance: " + acc.getBalance());
		}
		catch(RuntimeException e) {
			System.out.print("\nErro encontrado! Finalizando programa...");
		}
		catch(BalanceException e) {
			System.out.print("Erro: " + e.getMessage());
		}
		catch(WithdrawException e) {
			System.out.print("Erro: " + e.getMessage());
		}
		
		sc.close();
	}

}
