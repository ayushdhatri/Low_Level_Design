package Low_Level_Design.practice.atmLLD.state;

public interface ATMState {
    void enterPin();
    void selectAmount();
    void dispenseCash();
    void cancel();
}
