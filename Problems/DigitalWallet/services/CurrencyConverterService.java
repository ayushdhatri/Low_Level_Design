package Low_Level_Design.Problems.DigitalWallet.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

import Low_Level_Design.Problems.DigitalWallet.enums.Currency;

public class CurrencyConverterService {
    private static final Map<Currency, BigDecimal> exchangeRates = Map.of(
        Currency.USD, BigDecimal.ONE,
        Currency.INR, new BigDecimal("83")
    );

    public static BigDecimal convert(BigDecimal amount, Currency sourceCurrency, Currency targetCurrency){
        BigDecimal sourcRate = exchangeRates.get(sourceCurrency);
        BigDecimal targetRate = exchangeRates.get(targetCurrency);
        if(sourcRate == targetRate)return amount;
        return amount.multiply(targetRate).divide(sourcRate, 2, RoundingMode.HALF_UP);

    }

    
}
