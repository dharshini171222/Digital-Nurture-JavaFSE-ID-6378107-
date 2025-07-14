import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Book[] books = {
            new Book(101, "The Hobbit", "J.R.R. Tolkien"),
            new Book(102, "1984", "George Orwell"),
            new Book(103, "A Brief History of Time", "Stephen Hawking"),
            new Book(104, "To Kill a Mockingbird", "Harper Lee"),
            new Book(105, "The Great Gatsby", "F. Scott Fitzgerald")
        };

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. View All Books");
            System.out.println("2. Search Book by Title (Linear Search)");
            System.out.println("3. Search Book by Title (Binary Search)");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    LibrarySearch.viewBooks(books);
                    break;

                case 2:
                    System.out.print("Enter book title to search: ");
                    String title1 = sc.nextLine();
                    Book found1 = LibrarySearch.linearSearch(books, title1);
                    if (found1 != null)
                        System.out.println("Book found: " + found1);
                    else
                        System.out.println("Book not found.");
                    break;

                case 3:
                    LibrarySearch.sortBooksByTitle(books);
                    System.out.print("Enter book title to search: ");
                    String title2 = sc.nextLine();
                    Book found2 = LibrarySearch.binarySearch(books, title2);
                    if (found2 != null)
                        System.out.println("Book found: " + found2);
                    else
                        System.out.println("Book not found.");
                    break;

                case 4:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
