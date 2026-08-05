package Low_Level_Design.practice.LoggingFramework.strategies.formatter;

import Low_Level_Design.practice.LoggingFramework.entities.LogMessage;

public class TextFormatter implements LogFormatter {

    @Override
    public String format(LogMessage message) {
        return String.format("[%s] [%s] [%s] - %s", 
                            message.getTimeStamp(),
                            message.getLevel(),
                            message.getMessage(),
                            message.getThreadName()
                        );
    }
    
    
}
