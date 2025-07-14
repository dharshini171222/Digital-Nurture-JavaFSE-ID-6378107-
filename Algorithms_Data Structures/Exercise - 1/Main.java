import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inventory inv = new Inventory();
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\n1. Add  2. Update  3. Delete  4. View  5. Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID, Name, Quantity, Price: ");
                    int id = sc.nextInt();
                    String name = sc.next();
                    int qty = sc.nextInt();
                    double price = sc.nextDouble();
                    inv.addProduct(new Product(id, name, qty, price));
                    break;
                case 2:
                    System.out.print("Enter ID to update, then new Name, Quantity, Price: ");
                    id = sc.nextInt();
                    name = sc.next();
                    qty = sc.nextInt();
                    price = sc.nextDouble();
                    inv.updateProduct(id, name, qty, price);
                    break;
                case 3:
                    System.out.print("Enter ID to delete: ");
                    id = sc.nextInt();
                    inv.deleteProduct(id);
                    break;
                case 4:
                    inv.viewInventory();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid input.");
                    break;
            }
        }while(true);
    }
}
