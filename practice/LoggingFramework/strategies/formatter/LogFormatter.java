package Low_Level_Design.practice.LoggingFramework.strategies.formatter;

import Low_Level_Design.practice.LoggingFramework.entities.LogMessage;

public interface LogFormatter {
    String format(LogMessage message);
}

