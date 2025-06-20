import java.util.ArrayList;
import java.util.Scanner;

class Inventory {
    int id;
    String name;
    int quantity;
    float price;

    Inventory(int id, String name, int quantity, float price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    void display() {
        System.out.println("Product ID      : " + id);
        System.out.println("Product Name    : " + name);
        System.out.println("Product Quantity: " + quantity);
        System.out.println("Product Price   : ₹" + price);
    }
}

public class StoreApp {
    ArrayList<Inventory> store = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    void addItem() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();
        System.out.print("Enter Price: ");
        float price = sc.nextFloat();

        // Check for duplicate ID
        for (Inventory item : store) {
            if (item.id == id) {
                System.out.println("ID already exists!");
                return;
            }
        }

        store.add(new Inventory(id, name, quantity, price));
        System.out.println("Item added.");
    }

    void updateItem() {
        System.out.print("Enter ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        boolean found = false;
        for (Inventory item : store) {
            if (item.id == id) {
                System.out.print("New Name: ");
                item.name = sc.nextLine();
                System.out.print("New Quantity: ");
                item.quantity = sc.nextInt();
                System.out.print("New Price: ");
                item.price = sc.nextFloat();
                System.out.println("Updated.");
                found = true;
                break;
            }
        }
        if (!found) System.out.println("ID not found.");
    }

    void removeItem() {
        System.out.print("Enter ID to remove: ");
        int id = sc.nextInt();
        boolean removed = store.removeIf(item -> item.id == id);
        System.out.println(removed ? "Removed." : "ID not found.");
    }

    void viewAll() {
        if (store.isEmpty()) {
            System.out.println("Store is empty.");
        } else {
            for (Inventory item : store) item.display();
        }
    }

    void run() {
        int choice;
        do {
            System.out.println("\n=== Inventory Menu ===");
            System.out.println("1. Add");
            System.out.println("2. Update");
            System.out.println("3. Remove");
            System.out.println("4. View");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addItem();
                case 2 -> updateItem();
                case 3 -> removeItem();
                case 4 -> viewAll();
                case 5 -> System.out.println("Exit...");
                default -> System.out.println("Invalid Choice.");
            }
        } while (choice != 5);
    }

    public static void main(String[] args) {
        new StoreApp().run();
    }
}
