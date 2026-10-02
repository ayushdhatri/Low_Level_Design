package Low_Level_Design.Problems.DigitalWallet.services.strategy;

import java.math.BigDecimal;
public interface IPaymentMethod {
    String getId();
    void charge(BigDecimal amount);
}
