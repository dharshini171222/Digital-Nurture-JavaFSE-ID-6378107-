import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Task Management System ---");
            System.out.println("1. Add Task");
            System.out.println("2. Search Task by ID");
            System.out.println("3. View All Tasks");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID, Name, Status: ");
                    int id = sc.nextInt();
                    String name = sc.next();
                    String status = sc.next();
                    manager.addTask(new Task(id, name, status));
                    break;

                case 2:
                    System.out.print("Enter ID to search: ");
                    id = sc.nextInt();
                    Task found = manager.searchTask(id);
                    if (found != null)
                        System.out.println("Found: " + found);
                    else
                        System.out.println("Task not found.");
                    break;

                case 3:
                    manager.viewTasks();
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    id = sc.nextInt();
                    manager.deleteTask(id);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
