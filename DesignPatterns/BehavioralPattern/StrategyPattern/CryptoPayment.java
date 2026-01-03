package Low_Level_Design.DesignPatterns.BehavioralPattern.StrategyPattern;


import java.util.*;

class CryptoPayment implements PaymentStrategy {
    
    private static final List<String> SUPPORTED_CRYPTO = Arrays.asList("BTC", "ETH", "USDT");
    
    @Override
    public boolean validate(Map<String, String> paymentDetails) {
        String walletAddress = paymentDetails.get("wallet_address");
        String cryptoType = paymentDetails.get("crypto_type");
        
        if (walletAddress == null || cryptoType == null) {
            return false;
        }
        
        return walletAddress.length() > 20 && SUPPORTED_CRYPTO.contains(cryptoType);
    }
    
    @Override
    public PaymentResult processPayment(double amount, Map<String, String> paymentDetails) {
        if (!validate(paymentDetails)) {
            return new PaymentResult("failed", "Invalid cryptocurrency details");
        }
        
        String walletAddress = paymentDetails.get("wallet_address");
        String cryptoType = paymentDetails.get("crypto_type");
        
        System.out.println("Processing " + cryptoType + " payment of $" + amount);
        System.out.println("Wallet: " + walletAddress.substring(0, 10) + "..." 
                         + walletAddress.substring(walletAddress.length() - 10));
        
        // Simulate crypto exchange API call
        String transactionId = "CR_" + cryptoType + "_" + (int)amount;
        
        return new PaymentResult("success", "", transactionId, amount, getPaymentMethodName());
    }
    
    @Override
    public String getPaymentMethodName() {
        return "Cryptocurrency";
    }
}