/**
 * Write a description of class BankCard here.
 *
 * @author (Ashish Ghimire)
 * @version (a version number or a date)
 */
public class BankCard
{
    //encapsulated instance variables
    private int cardId;
    private String clientName;
    private String issuerBank;
    private String bankAccount;
    private int balanceAmount;
    public BankCard(int cardId,String issuerBank,String bankAccount,int balanceAmount)//constructor with 4 parameters
    {
        this.cardId=cardId;
        this.issuerBank=issuerBank;
        this.bankAccount=bankAccount;
        this.balanceAmount=balanceAmount;
        this.clientName="";
    }
    //getter methods
    public int getCardId()
    {
    return this.cardId;
    }
    public String getClientName()
    {
    return clientName;
    }
    public String getIssuerBank()
    {
        return issuerBank;
    }
    public String getBankAccount()
    {
    return bankAccount;
    }
    public int getBalanceAmount()
    {
        return balanceAmount;
    }
    //setter Methods
    public void setClientName(String clientName)
    {
       this.clientName=clientName;
    }
    public void setBalanceamount(int balanceAmount)
    {
        this.balanceAmount=balanceAmount;
    }
    //display method
    public void display()
    {
    if(clientName.equals(""))
    {
    System.out.println("No clientName found in Database Please Enter Your Account Name Correctly");
    }
    else{
    System.out.println("CardId: "+cardId);
    System.out.println("ClientName :"+clientName);
    System.out.println("IssuerBank : "+issuerBank);
    System.out.println("BankAccount : "+bankAccount);
    System.out.println("BalanceAmount : "+balanceAmount);
        }
    }
}
