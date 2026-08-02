package Low_Level_Design.practice.atmLLD.chainofresponsibility;

import java.math.BigDecimal;

public interface DispenseChain {
    void setNextChain(DispenseChain nextChain);
    void dispense(BigDecimal amount);
    boolean canDispense(BigDecimal amount);
}
