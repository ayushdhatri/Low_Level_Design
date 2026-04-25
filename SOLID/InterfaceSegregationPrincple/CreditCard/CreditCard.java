package Low_Level_Design.SOLID.InterfaceSegregationPrincple.CreditCard;

public abstract class CreditCard {
    private String cardNumber;
    private String cardHolder;
    private String expiryDate;
    private int cvv;

    public abstract void swipeAndPay();
    public abstract void tapAndPay();
    public abstract void onlinePayment();
} 
