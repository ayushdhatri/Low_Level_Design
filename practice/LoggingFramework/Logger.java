package Low_Level_Design.practice.LoggingFramework;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import Low_Level_Design.practice.LoggingFramework.entities.LogMessage;
import Low_Level_Design.practice.LoggingFramework.enums.LogLevel;
import Low_Level_Design.practice.LoggingFramework.strategies.appender.LogAppender;

public class Logger {
    private volatile LogLevel minLogLevel;
    
    private final List<LogAppender> appenders;

    public Logger(LogLevel minLogLevel){
        this.minLogLevel = minLogLevel;
        this.appenders = new CopyOnWriteArrayList<>();
    }

    public void setLevel(LogLevel level){
        this.minLogLevel = level;
    }

    public void addAppender(LogAppender appender){
        this.appenders.add(appender);
    }

    public void removeAppender(LogAppender appender){
        this.appenders.remove(appender);
    }

    public void log(LogLevel level, String message){
        if(level.isGreaterOrEqual(minLogLevel)){
            LogMessage msg = new LogMessage(level, message);
            for(LogAppender appender : appenders){
                appender.append(msg);
            }
        }
    }

    public void debug(String msg) { log(LogLevel.DEBUG, msg); }
    public void info(String msg)  { log(LogLevel.INFO, msg); }
    public void warn(String msg)  { log(LogLevel.WARN, msg); }
    public void error(String msg) { log(LogLevel.ERROR, msg); }



    
}
