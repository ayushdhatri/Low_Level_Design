package Low_Level_Design.Problems.ATM.StateDesign.api;

import Low_Level_Design.Problems.ATM.StateDesign.DTO.CreateTransactionRequestDTO;
import Low_Level_Design.Problems.ATM.StateDesign.DTO.GetAtmAmountRequestDTO;
import Low_Level_Design.Problems.ATM.StateDesign.DTO.UpdateATMStateRequestDTO;

public interface BackendAPI {
    // this class should only be responsible for connecting to the backend and returning the response
    int createTransaction(CreateTransactionRequestDTO createTransactionDTO);

    boolean updateState(UpdateATMStateRequestDTO updateATMStateDTO);

    int getAtmAmount(GetAtmAmountRequestDTO getAtmAmountRequestDTO);
}
