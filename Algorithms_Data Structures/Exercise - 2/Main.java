import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SortUtils[] products = {
            new SortUtils(101, "Laptop", "Electronics"),
            new SortUtils(102, "Shoes", "Footwear"),
            new SortUtils(103, "Watch", "Accessories"),
            new SortUtils(104, "Phone", "Electronics"),
            new SortUtils(105, "T-shirt", "Clothing")
        };

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- E-Commerce Product Search ---");
            System.out.println("1. View all products");
            System.out.println("2. Search by name (Linear Search)");
            System.out.println("3. Search by name (Binary Search)");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();  // Clear newline

            switch (choice) {
                case 1:
                    SearchEngine.viewProducts(products);
                    break;

                case 2:
                    System.out.print("Enter product name to search (Linear): ");
                    String nameLinear = sc.nextLine();
                    SortUtils result1 = SearchEngine.linearSearch(products, nameLinear);
                    if (result1 != null)
                        System.out.println("Found: " + result1);
                    else
                        System.out.println("Product not found.");
                    break;

                case 3:
                    SearchEngine.sortByName(products); // Sort before binary search
                    System.out.print("Enter product name to search (Binary): ");
                    String nameBinary = sc.nextLine();
                    SortUtils result2 = SearchEngine.binarySearch(products, nameBinary);
                    if (result2 != null)
                        System.out.println("Found: " + result2);
                    else
                        System.out.println("Product not found.");
                    break;

                case 4:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
