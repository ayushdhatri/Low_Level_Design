package Low_Level_Design.practice.atmLLD.Exceptions;

public class InvalidPinException extends RuntimeException {
    public InvalidPinException(String message){
        super(message);
    }
}
