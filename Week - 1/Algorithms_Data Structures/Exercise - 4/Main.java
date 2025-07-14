import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager(100);
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Employee Management System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee by ID");
            System.out.println("3. View All Employees");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter ID, Name, Position, Salary: ");
                    int id = sc.nextInt();
                    String name = sc.next();
                    String position = sc.next();
                    double salary = sc.nextDouble();
                    manager.addEmployee(new Employee(id, name, position, salary));
                    break;

                case 2:
                    System.out.print("Enter ID to search: ");
                    id = sc.nextInt();
                    Employee emp = manager.searchEmployee(id);
                    if (emp != null) {
                        System.out.println("Found: " + emp);
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;

                case 3:
                    manager.viewEmployees();
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    id = sc.nextInt();
                    manager.deleteEmployee(id);
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
