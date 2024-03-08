
public class DebitCard extends BankCard
{
    private int pinNumber; 
    private int withdrawalAmount;
    private String dateOfWithdrawal;
    private boolean hasWithdrawn;
    public DebitCard(int cardId,String bankAccount,int balanceAmount,String issuerBank,String clientName,int pinNumber)
    {
        super( cardId,issuerBank, bankAccount,balanceAmount);
        setClientName(clientName);
        this.withdrawalAmount=0;
        this.dateOfWithdrawal="";
        this.pinNumber=pinNumber;
        this.hasWithdrawn=false;
    }
    //getter methods
    public int getPinNumber()
    {
        return this.pinNumber;
    }
    public int getWithdrawalAmount()
    {
        return this.withdrawalAmount;
    }
    public String getDateOfWithdrawal()
    {
        return this.dateOfWithdrawal;
    }
    public boolean getHasWithdrawn()
    {
        return this.hasWithdrawn;
    }
    //setter method
    public void setWithdrawalAmount(int withdrawalAmount)
    {
        this.withdrawalAmount=withdrawalAmount;
    }
    //withdraw method
    public void withdraw(int withdrawalAmount,int pinNumber,String dateOfWithdrawal)
    {
        if(this.pinNumber==pinNumber)
        
        {
            if(getBalanceAmount()>=withdrawalAmount){
            setWithdrawalAmount(withdrawalAmount);
            this.dateOfWithdrawal=dateOfWithdrawal;
            this.hasWithdrawn=true;
            setBalanceamount(getBalanceAmount()-withdrawalAmount);
            System.out.println("You Currently have "+getBalanceAmount()+"in your account");
        }
        else{
        System.out.println("Your current balanceamount is "+getBalanceAmount()+" Sorry we cannot process your transaction"); 
        }
    }
        else{
        System.out.println("Sorry your Pin Number doesn't match.try again");
        }
    }
    //display method
        public void display()
        {
            super.display();
            if(this.hasWithdrawn==true){
                System.out.println("Your debitcard  pin is "+this.pinNumber+" please don't share this");
                System.out.println("The amount was withdrawn at "+this.dateOfWithdrawal);
                System.out.println("Withdrawn Amount is "+this.withdrawalAmount);
            }
            else{
                System.out.println("There was no Withdrawal Made");
            }
        }
}