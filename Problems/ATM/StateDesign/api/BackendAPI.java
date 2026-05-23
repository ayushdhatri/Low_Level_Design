package Low_Level_Design.Problems.ATM.StateDesign.api;

import Low_Level_Design.Problems.ATM.StateDesign.DTO.CreateTransactionDTO;
import Low_Level_Design.Problems.ATM.StateDesign.DTO.UpdateATMStateDTO;

public interface BackendAPI {
    // this class should only be responsible for connecting to the backend and returning the response
    int createTransaction(CreateTransactionDTO createTransactionDTO);

    boolean updateState(UpdateATMStateDTO updateATMStateDTO);

}
