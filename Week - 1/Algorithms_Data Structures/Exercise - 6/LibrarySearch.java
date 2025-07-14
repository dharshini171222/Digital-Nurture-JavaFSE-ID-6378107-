import java.util.Arrays;
import java.util.Comparator;

public class LibrarySearch {

    // Linear Search by title
    public static Book linearSearch(Book[] books, String title) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                return b;
            }
        }
        return null;
    }

    // Binary Search by title (assumes sorted array)
    public static Book binarySearch(Book[] books, String title) {
        int left = 0, right = books.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = title.compareToIgnoreCase(books[mid].title);

            if (cmp == 0) return books[mid];
            else if (cmp < 0) right = mid - 1;
            else left = mid + 1;
        }

        return null;
    }

    // Sort books by title (for binary search)
    public static void sortBooksByTitle(Book[] books) {
        Arrays.sort(books, Comparator.comparing(b -> b.title.toLowerCase()));
    }

    // View all books
    public static void viewBooks(Book[] books) {
        System.out.println("\n--- Book List ---");
        for (Book b : books) {
            System.out.println(b);
        }
    }
}
