package Low_Level_Design.practice.LoggingFramework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import Low_Level_Design.practice.LoggingFramework.enums.LogLevel;

public class LogManager {
    private static final LogManager INSTANCE = new LogManager();
    private final Map<String, Logger> loggers = new ConcurrentHashMap<>();
    private final Logger rootLogger;
    private final AsyncLogProcessor processor;

    private LogManager(){
        this.rootLogger = new Logger(LogLevel.INFO);
        this.loggers.put("root", rootLogger);
        this.processor = new AsyncLogProcessor();
    }

    public LogManager getInstance(){
        return INSTANCE;
    }

}
