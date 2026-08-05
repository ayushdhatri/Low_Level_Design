package Low_Level_Design.practice.LoggingFramework.strategies.formatter;

import Low_Level_Design.practice.LoggingFramework.entities.LogMessage;

public class JsonFormatter implements LogFormatter {

    @Override
    public String formatLogMessage(LogMessage message) {
       return String.format("{\"timestamp\" : %d, \"thread\" : %s,\"level\" : %s, \"message\" : %s}" ,
         message.getTimeStamp(),
         message.getThreadName(),
         message.getLevel(),
         message.getMessage()
       );
    }
}
