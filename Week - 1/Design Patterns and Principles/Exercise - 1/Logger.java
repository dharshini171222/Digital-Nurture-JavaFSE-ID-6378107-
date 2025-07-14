public class Logger {
    // Step 1: Create a private static instance of Logger (eager initialization)
    private static Logger instance = new Logger();

    // Step 2: Make the constructor private so no other class can instantiate it
    private Logger() {
        System.out.println("Logger Initialized");
    }

    // Step 3: Provide a public static method to get the single instance
    public static Logger getInstance() {
        return instance;
    }

    // Example logging method
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}
