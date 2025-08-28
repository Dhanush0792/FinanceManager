package com.financemanager;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class ExpenseManager {
    private List<Expense> expenses = new ArrayList<>();
    private static final String FILE_NAME = "expenses.csv";

    public ExpenseManager() {
        loadExpenses();
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
        saveExpenses();
    }

    public void showExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
            return;
        }
        expenses.forEach(System.out::println);
    }

    public void showSummary() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses found.");
            return;
        }

        double total = expenses.stream().mapToDouble(Expense::getAmount).sum();
        System.out.println("=== Expense Summary ===");
        System.out.println("Total Expenses: $" + total);

        expenses.stream()
            .collect(Collectors.groupingBy(
                e -> e.getDate().getMonth(),
                Collectors.summingDouble(Expense::getAmount)
            ))
            .forEach((month, sum) -> {
                System.out.println(month + ": $" + sum);
            });
    }

    private void saveExpenses() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Expense e : expenses) {
                writer.println(e.getCategory() + "," + e.getAmount() + "," + e.getDate());
            }
        } catch (IOException e) {
            System.out.println("Error saving expenses: " + e.getMessage());
        }
    }

    private void loadExpenses() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(",");
                if (parts.length == 3) {
                    expenses.add(new Expense(
                        parts[0],
                        Double.parseDouble(parts[1]),
                        java.time.LocalDate.parse(parts[2])
                    ));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading expenses: " + e.getMessage());
        }
    }
}
