package Low_Level_Design.practice.atmLLD.chainofresponsibility;

import java.math.BigDecimal;

public abstract class NoteDispenser implements DispenseChain {
    protected DispenseChain nextChain;
    private final int noteValue;
    private int numNotes;

    public NoteDispenser(int noteValue, int numNotes) {
        this.noteValue = noteValue;
        this.numNotes = numNotes;
    }

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.nextChain = nextChain;
    }

    @Override
    public void dispense(BigDecimal amount) {
        int currentAmount = amount.intValue();

        if (currentAmount >= noteValue) {
            int numToDispense = Math.min(currentAmount / noteValue, this.numNotes);
            int remainingAmount = currentAmount - (numToDispense * noteValue);

            if (numToDispense > 0) {
                System.out.println("Dispensing " + numToDispense + " x $" + noteValue + " note(s)");
                this.numNotes -= numToDispense;
            }

            if (remainingAmount > 0) {
                if (this.nextChain != null) {
                    this.nextChain.dispense(BigDecimal.valueOf(remainingAmount));
                } else {
                    throw new IllegalStateException("Error: ATM cannot fulfill remaining $" + remainingAmount);
                }
            }
        } else if (this.nextChain != null) {
            this.nextChain.dispense(amount);
        } else {
            throw new IllegalStateException("Error: Cannot dispense amount $" + currentAmount);
        }
    }

    @Override
    public boolean canDispense(BigDecimal amount) {
        int currentAmount = amount.intValue();

        if (currentAmount < 0) return false;
        if (currentAmount == 0) return true;

        int numToUse = Math.min(currentAmount / noteValue, this.numNotes);
        int remainingAmount = currentAmount - (numToUse * noteValue);

        if (remainingAmount == 0) return true;
        if (this.nextChain != null) {
            return this.nextChain.canDispense(BigDecimal.valueOf(remainingAmount));
        }
        return false;
    }

    public int getNumNotes() {
        return numNotes;
    }

    public int getNoteValue() {
        return noteValue;
    }
}