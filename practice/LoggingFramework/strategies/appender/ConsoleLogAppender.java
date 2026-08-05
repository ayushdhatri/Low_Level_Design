package Low_Level_Design.practice.LoggingFramework.strategies.appender;

import Low_Level_Design.practice.LoggingFramework.entities.LogMessage;
import Low_Level_Design.practice.LoggingFramework.strategies.formatter.LogFormatter;
import Low_Level_Design.practice.LoggingFramework.strategies.formatter.TextFormatter;

public class ConsoleLogAppender implements LogAppender {
    private volatile LogFormatter formatter;
    public ConsoleLogAppender(){
        this.formatter = new TextFormatter();// by default strategy
    }
    @Override
    public void append(LogMessage message) {
        String formattedString = formatter.formatLogMessage(message);
        // Here this is anyways syncrhonized
        System.out.println(formattedString);
      
    }
    @Override
    public void setFormatter(LogFormatter formatter) {
       this.formatter = formatter;
    }
    
}
