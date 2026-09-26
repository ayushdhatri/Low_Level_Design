package Low_Level_Design.practice.Splitwise.Exception;

public class ResourceNotFound extends RuntimeException {

    public ResourceNotFound(String resourceId){
        super("Resource not foudnd with id : " + resourceId);
    }
    
}
