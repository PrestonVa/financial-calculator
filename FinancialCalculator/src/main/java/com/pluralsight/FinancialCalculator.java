package com.pluralsight;

import java.util.Scanner;
import java.text.DecimalFormat;

public class FinancialCalculator {
    // Initialize the scanner.
    static Scanner scanner = new Scanner(System.in);

    // Set double to print with only 2 decimal places.
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {

        // Ask user which calculator they want to use.
        System.out.println("Which calculator would you like to use?");
        System.out.println("1. A Mortgage Calculator");
        System.out.println("2. Future Value Calculator");
        int choice = scanner.nextInt();
        System.out.println("You entered: " + choice);

        // Start the calculator the user wants to use.
        switch (choice) {
            case 1:
                mortgageCalculator();
                break;
            case 2:
                futureValue();
                break;
        }

        // Close the scanner.
        scanner.close();
    }

    // Create the mortgage calculator.
    public static void mortgageCalculator() {
        // Tell user to enter the principal.
        System.out.println("Input the principal: ");
        double principal = scanner.nextDouble();

        // Tell user to enter the interest rate.
        System.out.println("Input the interest rate: ");
        double interestRate = scanner.nextDouble();

        // Tell user to enter the load length in years.
        System.out.print("Input the load length in years: ");
        int loanLength = scanner.nextInt();

        // Calculate the monthly interest rate.
        double monthlyInterestRate = interestRate / 12.00;

        // Convert years to months.
        int totalMonths = loanLength * 12;

        // Calculate the monthly payment.
        double monthlyPayment = principal * monthlyInterestRate / (1 - Math.pow(1 + monthlyInterestRate, - totalMonths));

        // Calculate the total interest.
        double totalInterest = monthlyPayment * totalMonths - principal;

        // Print out the information.
        System.out.println("Monthly Payment: $" + df.format(monthlyPayment));
        System.out.println("Total Interest Paid: $" + df.format(totalInterest));

        // Close the scanner.
        scanner.close();
    }

    // Create the future value calculator.
    public static void futureValue() {
        // Tell user to enter the deposit.
        System.out.println("Input the interest rate: ");
        double deposit = scanner.nextDouble();

        // Tell user to enter the interest rate.
        System.out.println("Input interest rate: ");
        double interestRate = scanner.nextDouble();

        // Tell user to enter the length in years.
        System.out.print("Input the length in years: ");
        int totalLength = scanner.nextInt();

        // Calculate the monthly interest rate.
        double monthlyInterestRate = interestRate / 12.00;

        // Convert years to months.
        int totalMonths = totalLength * 12;

        // Calculate future value.
        double futureValue = deposit * Math.pow(1 + monthlyInterestRate, totalMonths);

        // Calculate total interest.
        double totalInterest = futureValue - deposit;

        // Print out the information.
        System.out.println("Future Value: $" + df.format(futureValue));
        System.out.println("Total Interest Earned: $" + df.format(totalInterest));

        // Close the Scanner.
        scanner.close();
    }
}