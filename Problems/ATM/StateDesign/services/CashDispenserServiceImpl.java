package Low_Level_Design.Problems.ATM.StateDesign.services;

import Low_Level_Design.Problems.ATM.StateDesign.DTO.GetAtmAmountRequestDTO;
import Low_Level_Design.Problems.ATM.StateDesign.api.BackendAPI;
import Low_Level_Design.Problems.ATM.StateDesign.models.ATM;

public class CashDispenserServiceImpl implements CashDispenserService {
    private final BackendAPI backendAPI;

    public CashDispenserServiceImpl(BackendAPI backendAPI){
        this.backendAPI = backendAPI;
    }

    @Override
    public void dispenseCash(ATM atm, double amount) {
        double avlAtmAmount = this.backendAPI.getAtmAmount(new GetAtmAmountRequestDTO(atm.getAtmId()));
        if(avlAtmAmount < amount){
            throw new RuntimeException("ATM does not have enough cash");
        }
        System.out.println("Dispensing Cash");
        
    }
    
}
