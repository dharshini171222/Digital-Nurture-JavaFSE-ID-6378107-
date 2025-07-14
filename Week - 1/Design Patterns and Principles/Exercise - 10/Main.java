public class Main {
    public static void main(String[] args) {
        // Create model
        Student student = new Student("Alice", "S001", "A");

        // Create view
        StudentView view = new StudentView();

        // Create controller
        StudentController controller = new StudentController(student, view);

        // Initial display
        controller.updateView();

        // Update student details
        controller.setStudentName("Alice Johnson");
        controller.setStudentGrade("A+");

        // Display updated details
        controller.updateView();
    }
}
