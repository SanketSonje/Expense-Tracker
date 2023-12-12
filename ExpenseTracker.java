import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Expense 
{
    String name;
    double amount;

    Expense(String name, double amount) 
    {
        this.name = name;
        this.amount = amount;
    }
}

public class ExpenseTracker 
{
    private List<Expense> expenses;
    private double budget;

    public ExpenseTracker(double budget) 
    {
        this.expenses = new ArrayList<>();
        this.budget = budget;
    }

    public void logExpense(String name, double amount) 
    {
        expenses.add(new Expense(name, amount));
        System.out.println("Expense logged successfully!");
    }

    public void setBudget(double budget) 
    {
        this.budget = budget;
        System.out.println("Budget set successfully!");
    }

    public void visualizeExpenses() 
    {
        System.out.println("Expense List:");
        for (Expense expense : expenses) 
        {
            System.out.println(expense.name + ": $" + expense.amount);
        }
        System.out.println("Total Expenses: $" + calculateTotalExpenses());
        System.out.println("Budget: $" + budget);
    }

    private double calculateTotalExpenses() 
    {
        double total = 0;
        for (Expense expense : expenses) 
        {
            total += expense.amount;
        }
        return total;
    }

    public void remind() 
    {
        double remainingBudget = budget - calculateTotalExpenses();
        if (remainingBudget <= 0) 
        {
            System.out.println("You have exceeded your budget!");
        } else {
            System.out.println("Remaining budget: $" + remainingBudget);
        }
    }

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your budget: $");
        double initialBudget = scanner.nextDouble();

        ExpenseTracker expenseTracker = new ExpenseTracker(initialBudget);

        while (true) 
        {
            System.out.println("\nExpense Tracker Menu:");
            System.out.println("1. Log Expense");
            System.out.println("2. Set Budget");
            System.out.println("3. Visualize Expenses");
            System.out.println("4. Remind");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter expense name: ");
                    String expenseName = scanner.next();
                    System.out.print("Enter expense amount: $");
                    double expenseAmount = scanner.nextDouble();
                    expenseTracker.logExpense(expenseName, expenseAmount);
                    break;

                case 2:
                    System.out.print("Enter new budget: $");
                    double newBudget = scanner.nextDouble();
                    expenseTracker.setBudget(newBudget);
                    break;

                case 3:
                    expenseTracker.visualizeExpenses();
                    break;

                case 4:
                    expenseTracker.remind();
                    break;

                case 5:
                    System.out.println("Exiting Expense Tracker. Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
