package Low_Level_Design.Problems.ATM.StateDesign.api;

public class NodeBackendAPI implements BackendAPI {
    // here we will do doing all the actual backend api for outer interaction
    // this class should only be responsible for connecting to backend and returning the response
    public int createTransaction(String atmId){
        // this will call the backend to create the transaction
        return 0;

    }
    
}
