package Low_Level_Design.Problems.ATM.StateDesign.enums;

public enum ATMState {
    READ_FOR_TRANSACTION,
    READ_CARD_DETAILS_AND_PIN,
    DISPENSING_CASH,
    EJECTING_CARD,
    READING_CASH_WITHDRAW_DETAILS
}
