import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {
        String username = "vineeth";
        int userId = 42;

        logger.info("User {} has logged in with ID {}", username, userId);
        logger.warn("Disk space for user {} is below {}%", username, 10);
    }
}
