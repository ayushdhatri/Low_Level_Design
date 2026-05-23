package Low_Level_Design.Problems.ATM.StateDesign.api;

import Low_Level_Design.Problems.ATM.StateDesign.DTO.CreateTransactionRequestDTO;
import Low_Level_Design.Problems.ATM.StateDesign.DTO.GetAtmAmountRequestDTO;
import Low_Level_Design.Problems.ATM.StateDesign.DTO.UpdateATMStateRequestDTO;

public class NodeBackendAPI implements BackendAPI {
    // here we will do doing all the actual backend api for outer interaction
    // this class should only be responsible for connecting to backend and returning the response
    public int createTransaction(CreateTransactionRequestDTO createTransactionDTO){
        // validation 
        
        if(createTransactionDTO.getAtmId() == null || createTransactionDTO.getAtmId().isEmpty()){
            throw new IllegalArgumentException("ATM ID cannot be null or empty");
        }
        // Connect to the backend

        // to mimic the backend call lets return a new random transaction id
        int txnId = (int) (Math.random() * 1000);
        return txnId;
        // but in real world this way it does not happen, because an api request expects alot of things 
        // such as header, reqeust body if any, etc..

    }

    @Override
    public boolean updateState(UpdateATMStateRequestDTO updateATMStateDTO) {
       // it is going to call the backend send this dto in request body 
       // if bank is able to update the state of atm it will return true 
       return true;
    }

    @Override
    public int getAtmAmount(GetAtmAmountRequestDTO getAtmAmountRequestDTO) {
        // it will call the bank server with following atmId and fetch the details
        return 10000;
    }
    
}
