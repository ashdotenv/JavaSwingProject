 public class CreditCard extends BankCard
{
    //instance variables
    private int CVCNumber;
    private double creditLimit;
    private double interestRate;
    private String expirationDate;
    private int gracePeriod;
    private boolean isGranted;
    //constructor 
    public CreditCard(int cardId, String clientName, String issuerBank, String bankAccount, int balanceAmount, int CVCNumber,double interestRate, String expirationDate) {
        super(cardId,issuerBank, bankAccount, balanceAmount);
        super.setClientName(clientName);
        this.CVCNumber = CVCNumber;
        this.interestRate = interestRate;
        this.expirationDate = expirationDate;
        this.isGranted = false;
    }
    //getter methods
    public int getCVCNumber() {
        return this.CVCNumber;
    }

    public double getCreditLimit() {
        return this.creditLimit;
    }

    public double getInterestRate() {
        return this.interestRate;
    }

    public String getExpirationDate() {
        return this.expirationDate;
    }

    public int getGracePeriod() {
        return this.gracePeriod;
    }
    public boolean getisGranted() {
        return isGranted;
    }

    //setter method
    public void setCreditLimit(double newCreditLimit, int newGracePeriod) {
        if (newCreditLimit <= 2.5 * super.getBalanceAmount()) {
            this.creditLimit = newCreditLimit;
            this.gracePeriod = newGracePeriod;
            this.isGranted = true;
        } else{
            System.out.println("Credit cannot be processed");
        }
    }
    //cancelmethod
    public void cancelCreditCard() {
        this.CVCNumber = 0;
        this.creditLimit = 0;
        this.gracePeriod = 0;
        this.isGranted = false;
    }
    //display method
    public void display(){
        if (isGranted)
        {
            super.display();
            System.out.println("CVC Number: " + CVCNumber);
            System.out.println("Credit Limit: " + creditLimit);
            System.out.println("Grace Period: " + gracePeriod);
            System.out.println("Interest Rate: " + interestRate);
            System.out.println("Expiration Date: " + expirationDate);
    }
        else{
        System.out.println("This credit card wasn't granted");
        }
    }

}