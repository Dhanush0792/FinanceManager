package com.financemanager;

import java.time.LocalDate;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ExpenseManager manager = new ExpenseManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== Finance Manager ====");
            System.out.println("1. Add Expense");
            System.out.println("2. Show Expenses");
            System.out.println("3. Show Summary");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    manager.addExpense(new Expense(category, amount, LocalDate.now()));
                    System.out.println("Expense added.");
                    break;
                case 2:
                    manager.showExpenses();
                    break;
                case 3:
                    manager.showSummary();
                    break;
                case 4:
                    System.out.println("Exiting... Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }
}
