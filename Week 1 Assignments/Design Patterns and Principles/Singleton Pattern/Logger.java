public class Logger {
    
    private static Logger instance = null;

    
    private Logger() {
        System.out.println("Logger is activated");
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG] " + message);
    }

    public static void main(String[] args) {
        Logger log1 = Logger.getInstance();
        Logger log2 = Logger.getInstance();

        log1.log("log1");
        log2.log("log2");

        if (log1 == log2) {
            System.out.println("Both are equal (singleton works)");
        } else {
            System.out.println("Not equal (singleton failed)");
        }
    }
}
