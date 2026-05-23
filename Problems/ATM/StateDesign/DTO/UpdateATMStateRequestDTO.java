package Low_Level_Design.Problems.ATM.StateDesign.DTO;

import Low_Level_Design.Problems.ATM.StateDesign.enums.ATMState;

public class UpdateATMStateRequestDTO {
    private final String atmId;
    private final ATMState state;

    public UpdateATMStateRequestDTO(String atmId, ATMState state){
        this.atmId = atmId;
        this.state = state;
    }

    public String getAtmId(){
        return this.atmId;
    }

    public ATMState getAtmState(){
        return this.state;
    }


    
}
