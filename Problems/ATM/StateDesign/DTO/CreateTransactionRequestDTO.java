package Low_Level_Design.Problems.ATM.StateDesign.DTO;

public class CreateTransactionRequestDTO {
     private final String atmId;

    public CreateTransactionRequestDTO(String atmId){
        this.atmId = atmId;
    }

    public String getAtmId(){
        return this.atmId;
    }
    
}
