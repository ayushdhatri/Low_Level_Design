package Low_Level_Design.practice.LoggingFramework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import Low_Level_Design.practice.LoggingFramework.enums.LogLevel;
import Low_Level_Design.practice.LoggingFramework.strategies.appender.ConsoleLogAppender;
import Low_Level_Design.practice.LoggingFramework.strategies.appender.FileAppender;
import Low_Level_Design.practice.LoggingFramework.strategies.formatter.JsonFormatter;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        // Initialize Core Logger with INFO threshold
        Logger logger = new Logger(LogLevel.INFO);

        // Configure Appenders with distinct Formatter strategies
        ConsoleLogAppender consoleAppender = new ConsoleLogAppender();
        FileAppender fileAppender = new FileAppender("app.log", new JsonFormatter());

        logger.addAppender(consoleAppender);
        logger.addAppender(fileAppender);

        System.out.println("--- Starting Concurrent Logging Test ---");

        // Simulate 10 concurrent threads logging simultaneously
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            executor.submit(() -> {
                logger.info("Worker Task " + taskId + " processing job.");
                logger.debug("Worker Task " + taskId + " debug info (Ignored).");
                logger.error("Worker Task " + taskId + " encountered an issue!");
            });
        }

        executor.shutdown();
        executor.awaitTermination(2, TimeUnit.SECONDS);

        System.out.println("--- Dynamic Runtime Configuration Change ---");
        // Change Formatter dynamically at runtime
        consoleAppender.setFormatter(new JsonFormatter());
        logger.setLevel(LogLevel.DEBUG);

        logger.debug("This DEBUG log now appears in JSON format!");
    }
}
