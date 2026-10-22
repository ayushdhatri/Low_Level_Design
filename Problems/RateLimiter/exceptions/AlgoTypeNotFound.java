package Low_Level_Design.Problems.RateLimiter.exceptions;

import Java.JavaLearnings.PART4.ExceptionalHandling.Exceptions.RunTime.Runtime;

public class AlgoTypeNotFound extends RuntimeException {
    
    public AlgoTypeNotFound(String algoType){
        super("Algo with type : " + algoType + " not foundssss");
    }
    
}
