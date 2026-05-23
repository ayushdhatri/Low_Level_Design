package Low_Level_Design.Problems.ATM.StateDesign.Factory;

import Low_Level_Design.Problems.ATM.StateDesign.enums.CardType;
import Low_Level_Design.Problems.ATM.StateDesign.services.CardManagerService;
import Low_Level_Design.Problems.ATM.StateDesign.services.CreditCardManagerService;
import Low_Level_Design.Problems.ATM.StateDesign.services.DebitCardManagerService;

public class CardManagerFactory {
    public static CardManagerService getCardManager(CardType cardType)
    {
        CardManagerService cardManagerService = null;
        if(cardType.equals(CardType.DEBIT)){
            cardManagerService = new DebitCardManagerService();
        }
        else if(cardType.equals((cardType.CREDIT))){
            cardManagerService = new CreditCardManagerService();
        }
        else{
            throw new IllegalArgumentException("Invalid Card Type");
        }
        return cardManagerService;
    }
    
}
