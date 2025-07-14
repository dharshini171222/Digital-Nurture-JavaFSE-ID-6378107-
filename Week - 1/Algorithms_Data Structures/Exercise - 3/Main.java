import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Order[] orders = {
            new Order(201, "Alice", 399.99),
            new Order(202, "Bob", 1299.50),
            new Order(203, "Charlie", 99.90),
            new Order(204, "David", 799.75),
            new Order(205, "Eve", 499.00)
        };

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Order Sorting Menu ---");
            System.out.println("1. View Orders");
            System.out.println("2. Sort by Price (Bubble Sort)");
            System.out.println("3. Sort by Price (Quick Sort)");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    SortUtils.viewOrders(orders);
                    break;

                case 2:
                    SortUtils.bubbleSort(orders);
                    System.out.println("Sorted using Bubble Sort.");
                    break;

                case 3:
                    SortUtils.quickSort(orders, 0, orders.length - 1);
                    System.out.println("Sorted using Quick Sort.");
                    break;

                case 4:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
