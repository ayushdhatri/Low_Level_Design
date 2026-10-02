package Low_Level_Design.Problems.DigitalWallet.services.strategy;

import java.math.BigDecimal;
public interface PaymentMethod {
    boolean selfTransfer(BigDecimal amount);

   
}
