import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== SHOPPING LIST AND COST CALCULATOR ===");

        int count;
        do {
            System.out.print("How many items are you buying? ");
            while (!input.hasNextInt()) {
                System.out.print("Please enter a whole number: ");
                input.next();
            }
            count = input.nextInt();
            if (count <= 0) {
                System.out.println("Enter at least one item.");
            }
        } while (count <= 0);

        input.nextLine(); // Clear the newline after the number.

        String[] items = new String[count];
        double[] prices = new double[count];
        double total = 0.0;
        int mostExpensiveIndex = 0;

        for (int i = 0; i < count; i++) {
            System.out.print("Enter the name of item " + (i + 1) + ": ");
            items[i] = input.nextLine();

            double price;
            do {
                System.out.print("Enter the price of " + items[i] + ": ");
                while (!input.hasNextDouble()) {
                    System.out.print("Please enter a valid price: ");
                    input.next();
                }
                price = input.nextDouble();
                if (price < 0) {
                    System.out.println("Price cannot be negative.");
                }
            } while (price < 0);

            prices[i] = price;
            input.nextLine(); // Clear the newline after the price.
            total += prices[i];

            if (prices[i] > prices[mostExpensiveIndex]) {
                mostExpensiveIndex = i;
            }
        }

        double budget;
        do {
            System.out.print("Enter your shopping budget: ");
            while (!input.hasNextDouble()) {
                System.out.print("Please enter a valid budget: ");
                input.next();
            }
            budget = input.nextDouble();
            if (budget < 0) {
                System.out.println("Budget cannot be negative.");
            }
        } while (budget < 0);

        System.out.println("\n--- YOUR SHOPPING LIST ---");
        for (int i = 0; i < items.length; i++) {
            System.out.printf("%d. %s - %.2f%n", i + 1, items[i], prices[i]);
        }

        System.out.printf("%nTotal cost: %.2f%n", total);
        System.out.println("Most expensive item: " + items[mostExpensiveIndex]
                + String.format(" (%.2f)", prices[mostExpensiveIndex]));

        if (total > budget) {
            System.out.printf("Budget status: Over budget by %.2f%n", total - budget);
        } else {
            System.out.printf("Budget status: Within budget. Remaining: %.2f%n", budget - total);
        }

        input.close();
    }
}