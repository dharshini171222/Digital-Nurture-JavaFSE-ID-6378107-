import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MultiAppenderLoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(MultiAppenderLoggingExample.class);

    public static void main(String[] args) {
        logger.info("This message will go to both the console and the file.");
        logger.error("An error occurred and was logged to multiple appenders.");
    }
}
