package Low_Level_Design.Problems.ATM.StateDesign.models;

public class ATM {
    private final String atmId;

    public ATM(String atmId){
        this.atmId = atmId;
    }

    public String getAtmId(){
        return this.atmId;
    }
}
