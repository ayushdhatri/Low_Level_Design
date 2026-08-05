package Low_Level_Design.practice.LoggingFramework.strategies.appender;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import Low_Level_Design.practice.LoggingFramework.entities.LogMessage;
import Low_Level_Design.practice.LoggingFramework.strategies.formatter.LogFormatter;
import Low_Level_Design.practice.LoggingFramework.strategies.formatter.TextFormatter;

public class FileAppender implements LogAppender {
    private volatile LogFormatter formatter;
    private final String filePath;

    public FileAppender(String filePath){
        this.filePath = filePath;
        this.formatter = new TextFormatter();
    }

    public FileAppender(String filePath, LogFormatter formatter){
        this.filePath = filePath;
        this.formatter = formatter;
    }

    @Override
    public void append(LogMessage message) {
        String formatterString = formatter.formatLogMessage(message);

        synchronized(this){
            try(PrintWriter writer = new PrintWriter(new FileWriter(this.filePath, true))){
                writer.println(formatterString);
            }
            catch(IOException ex){
                System.out.println("Failed to write log to file : " + ex.getMessage());

            }

        }
    }

    @Override
    public void setFormatter(LogFormatter formatter) {
       
    }
    
    
}
