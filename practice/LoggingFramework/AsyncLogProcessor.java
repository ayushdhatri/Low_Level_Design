package Low_Level_Design.practice.LoggingFramework;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import Low_Level_Design.practice.LoggingFramework.entities.LogMessage;
import Low_Level_Design.practice.LoggingFramework.strategies.appender.LogAppender;

public class AsyncLogProcessor {
    private final ExecutorService executor;

    public AsyncLogProcessor(){
        this.executor = Executors.newSingleThreadExecutor(runnable ->{
            Thread thread = new Thread(runnable, "AsyncLogProcessor");
            thread.setDaemon(true);
            return thread;
        });
    }

    public void process(LogMessage logMessage, List<LogAppender> appenders){
        if(executor.isShutdown()){
            System.out.println("Logger is shut down. Cannot process log message");
            return;
        }

        // submit a new task to executor
        executor.submit(()-> {
            for(LogAppender appender : appenders){
                appender.append(logMessage);
            }
        });
    }

    public void stop(){
        executor.shutdown();
        try{
            if(executor.awaitTermination(2, TimeUnit.SECONDS)){
                System.err.println("Logger executor did not terminate in the specified time");
                executor.shutdownNow();
            }
        }
        catch(InterruptedException ex){
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }



    
}
