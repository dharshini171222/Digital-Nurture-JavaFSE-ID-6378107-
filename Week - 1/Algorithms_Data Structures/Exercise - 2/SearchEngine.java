import java.util.*;

public class SearchEngine {

    public static Product linearSearch(Product[] products, String name) {
        for (Product p : products) {
            if (p.productName.equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String name) {
        int left = 0, right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = name.compareToIgnoreCase(products[mid].productName);

            if (comparison == 0)
                return products[mid];
            else if (comparison < 0)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return null;
    }

    public static void sortByName(Product[] products) {
        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));
    }

    public static void viewProducts(Product[] products) {
        if (products.length == 0) {
            System.out.println("No products available.");
            return;
        }

        System.out.println("\n--- Product List ---");
        for (Product p : products) {
            System.out.println(p);
        }
    }
}
