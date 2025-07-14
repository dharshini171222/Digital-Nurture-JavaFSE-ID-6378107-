import java.util.HashMap;

public class Inventory {
    HashMap<Integer, SortUtils> inventory = new HashMap<>();

    public void addProduct(SortUtils product) {
        if (inventory.containsKey(product.productId)) {
            System.out.println("Product ID already exists.");
        } else {
            inventory.put(product.productId, product);
            System.out.println("Product added.");
        }
    }

    public void updateProduct(int productId, String name, int quantity, double price) {
        if (inventory.containsKey(productId)) {
            SortUtils p = inventory.get(productId);
            p.productName = name;
            p.quantity = quantity;
            p.price = price;
            System.out.println("Product updated.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public void deleteProduct(int productId) {
        if (inventory.remove(productId) != null) {
            System.out.println("Product deleted.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public void viewInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (SortUtils p : inventory.values()) {
                System.out.println(p);
            }
        }
    }
}
