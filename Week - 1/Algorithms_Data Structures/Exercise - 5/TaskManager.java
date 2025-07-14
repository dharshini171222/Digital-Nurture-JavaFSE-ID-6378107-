public class TaskManager {
    // Node class
    class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    private Node head = null;

    // Add task to end
    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
        System.out.println("Task added.");
    }

    // Search task by ID
    public Task searchTask(int id) {
        Node curr = head;
        while (curr != null) {
            if (curr.task.taskId == id) {
                return curr.task;
            }
            curr = curr.next;
        }
        return null;
    }

    // Traverse all tasks
    public void viewTasks() {
        if (head == null) {
            System.out.println("No tasks found.");
            return;
        }
        System.out.println("\n--- Task List ---");
        Node curr = head;
        while (curr != null) {
            System.out.println(curr.task);
            curr = curr.next;
        }
    }

    // Delete task by ID
    public void deleteTask(int id) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.task.taskId == id) {
            head = head.next;
            System.out.println("Task deleted.");
            return;
        }

        Node prev = head;
        Node curr = head.next;

        while (curr != null) {
            if (curr.task.taskId == id) {
                prev.next = curr.next;
                System.out.println("Task deleted.");
                return;
            }
            prev = curr;
            curr = curr.next;
        }
        System.out.println("Task not found.");
    }
}
