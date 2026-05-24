package Low_Level_Design.Problems.ATM.StateDesign.models;

import Low_Level_Design.Problems.ATM.StateDesign.DTO.UpdateATMStateRequestDTO;
import Low_Level_Design.Problems.ATM.StateDesign.api.BackendAPI;
import Low_Level_Design.Problems.ATM.StateDesign.api.NodeBackendAPI;
import Low_Level_Design.Problems.ATM.StateDesign.state.ReadForTransactionState;
import Low_Level_Design.Problems.ATM.StateDesign.state.State;

public class ATM {
    private final String atmId;
    private State state;
    private BackendAPI atmBackendAPI;

    public ATM(String atmId){
        this.atmId = atmId;
        this.state = new ReadForTransactionState(this);
        this.atmBackendAPI = new NodeBackendAPI();
    }

    public String getAtmId(){
        return this.atmId;
    }

    public State getAtmState(){
        return this.state;
    }

    public void changeState(State newState){
        this.state = newState;
       // now call the server to persist the state on the server also
        this.atmBackendAPI.updateState(new UpdateATMStateRequestDTO(atmId, state.getState()));

    }
}
