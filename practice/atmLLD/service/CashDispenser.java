package Low_Level_Design.practice.atmLLD.service;

import java.math.BigDecimal;

import Low_Level_Design.practice.atmLLD.chainofresponsibility.DispenseChain;

public class CashDispenser {
    private final DispenseChain chain;
    public CashDispenser(DispenseChain chain){
        this.chain = chain;
    }
    public synchronized void dispenseCash(BigDecimal amount){
        chain.dispense(amount);
    }
    public synchronized boolean canDispenseCash(BigDecimal amount){
        if (amount.remainder(new BigDecimal("10")).compareTo(BigDecimal.ZERO) != 0) {
            return false;
        }
        return chain.canDispense(amount);
    }
    
}
