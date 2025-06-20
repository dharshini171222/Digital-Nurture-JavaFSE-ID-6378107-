import java.util.*;

class Product {
    int id;
    String name;
    String category;

    Product(int id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    void display() {
        System.out.println("\nProduct ID   : " + id);
        System.out.println("Product Name : " + name);
        System.out.println("Category     : " + category);
    }
}

public class SearchDemo {
    static Product[] products = {
        new Product(101, "Laptop", "Electronics"),
        new Product(102, "Shoes", "Footwear"),
        new Product(103, "Watch", "Accessories"),
        new Product(104, "Phone", "Electronics"),
        new Product(105, "T-shirt", "Clothing")
    };

    void viewAll() {
        System.out.println("\nAvailable Products:");
        for (Product p : products) {
            p.display();
        }
    }

    void linearSearch(String target) {
        boolean found = false;
        for (Product p : products) {
            if (p.name.equalsIgnoreCase(target)) {
                System.out.println("\n🔍 Product Found (Linear Search):");
                p.display();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No product found with that name.");
        }
    }

    void binarySearch(String target) {
        Arrays.sort(products, Comparator.comparing(p -> p.name.toLowerCase()));

        int low = 0, high = products.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = target.compareToIgnoreCase(products[mid].name);
            if (cmp == 0) {
                System.out.println("\n🔍 Product Found (Binary Search):");
                products[mid].display();
                return;
            } else if (cmp > 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("No product found with that name.");
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n=== 🛒 E-Commerce Product Search ===");
            System.out.println("1. View all products");
            System.out.println("2. Search by name (Linear Search)");
            System.out.println("3. Search by name (Binary Search)");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear the newline character

            switch (choice) {
                case 1 -> viewAll();
                case 2 -> {
                    System.out.print("Enter product name: ");
                    String name = sc.nextLine();
                    linearSearch(name);
                }
                case 3 -> {
                    System.out.print("Enter product name: ");
                    String name = sc.nextLine();
                    binarySearch(name);
                }
                case 4 -> System.out.println("Exiting... Thank you!");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
        sc.close();
    }

    public static void main(String[] args) {
        SearchDemo app = new SearchDemo();
        app.run();
    }
}
