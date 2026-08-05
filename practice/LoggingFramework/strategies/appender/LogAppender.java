package Low_Level_Design.practice.LoggingFramework.strategies.appender;

import Low_Level_Design.practice.LoggingFramework.entities.LogMessage;
import Low_Level_Design.practice.LoggingFramework.strategies.formatter.LogFormatter;

public interface LogAppender {
    void append(LogMessage message);
    void setFormatter(LogFormatter formatter);
}
