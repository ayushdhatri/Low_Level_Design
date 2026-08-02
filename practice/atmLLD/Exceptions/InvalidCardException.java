package Low_Level_Design.practice.atmLLD.Exceptions;

public class InvalidCardException extends RuntimeException {
    public InvalidCardException(String message){
        super(message);
    }
    
}
