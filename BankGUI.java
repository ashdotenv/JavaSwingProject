import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.BorderFactory;


public class BankGUI   {
    private JFrame f1;
    private JPanel dpanel, cpanel, wpanel,clpanel;
    private JLabel  l1, l2, l3, l4, l5, l6, l7, l8,l10,l11;
    private JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8,tf9, tf10, tf11, tf12, tf13, tf14,tf15, tf16, tf17,tf18,tf20,tf22;
    private JButton bt1, bt2, bt3,bt4,bt5;
    private JComboBox<String> c1, c2, c3, c4, c5, c6;
    private Font  midt, bigt;
    final static int INVALID = -1;
    ArrayList<BankCard> cards = new ArrayList<BankCard>();
    // DebitCard Area
    public int getCardID_debit() {
        int Card = INVALID;
        try {
            Card = Integer.parseInt(tf1.getText().trim());
            if (Card <= 0) {
                Card = INVALID;
            }
        } catch (Exception ae) {
            JOptionPane.showMessageDialog(null, "INVALID ERROR" + "\n" + "Please enter valid Card ID",
                    "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
        }
        return Card;
    }


    public int getcarDId() {
        int cardid = INVALID;
        try {
            cardid = Integer.parseInt(tf18.getText());
            if (cardid <= 0) {
                JOptionPane.showMessageDialog(null, "INVALID INPUT" + "\n" + "CardId cant be less than 1",
                        "ERROR MESSAGE", JOptionPane.INFORMATION_MESSAGE);


            }
        } catch (Exception ae) {
            JOptionPane.showMessageDialog(null, "INVALID INPUT" + "\n" + "Please enter a valid Card ID",
                    "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
        }
        return cardid;
    }


    public String getNameOfClient() {
        String Name = tf2.getText();
        return Name;
    }
    public String getBankIssuerInfo() {
        return tf3.getText().trim();
    }


    public String getAccountOfBank() {
        if(tf4.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "INVALID INPUT" + "\n" + "Fill Account Name Properly",
            "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return tf4.getText().trim();
    }    


    public double getAmountBalance() {
        int balance = INVALID;
        try {
            balance = Integer.parseInt(tf5.getText().trim());
            if (balance <= 0) {
                balance = INVALID;


            }
        } catch (Exception ae) {
            JOptionPane.showMessageDialog(null, "INVALID INPUT" + "\n" + "Please enter valid Card ID",
                    "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);


        }
        return balance;
    }


    public int getPinNumber() {
        int pin = INVALID;
        try {
            pin = Integer.parseInt(tf6.getText().trim());
            if (pin <= 0) {
                pin = INVALID;
            }
        } catch (Exception ae) {
            JOptionPane.showMessageDialog(null, "INVALID INPUT" + "\n" + "Please enter valid Pin Number",
                    "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
        }
        return pin;
    }
   


    public void addDebit() {
        String clientName = getNameOfClient();
        String issuerBank = getBankIssuerInfo();
        String Account = getAccountOfBank();
        double balance = getAmountBalance();
        int card = getCardID_debit();
        int pin = getPinNumber();


        if (clientName.isEmpty() || issuerBank.isEmpty() || Account.isEmpty()) {
            JOptionPane.showMessageDialog(null, "INVALID INPUT" + "\n" + "Fields cannot be empty",
                    "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);


            return;
        }
        if (balance < 0) {
            JOptionPane.showMessageDialog(null,
                    "INVALID INPUT" + "\n" + "Balance Amount cannot be less than 0", "ERROR MESSAGE",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }


        if (card <= 0) {
            JOptionPane.showMessageDialog(null, "INVALID INPUT" + "\n" + "CardId cannot be less than 1",
                    "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
            return;
        }


        if (pin <= 0) {
            JOptionPane.showMessageDialog(null,
                    "INVALID INPUT" + "\n" + "Pin Number cannot be less than 0",
                    "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
        }
        if (checkCardIdUnique(card) == true) {
            cards.add(new DebitCard((int) balance, "" + card, Integer.parseInt(Account), issuerBank, clientName, pin));
            JOptionPane.showMessageDialog(null,
                    "Debit Card Added!",
                    "   INFO   ",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "card id should be unique",
                    "Error box", JOptionPane.ERROR_MESSAGE);
        }


    }


    public boolean checkCardIdUnique(int cardId) {
        boolean result = true;
        for (BankCard obj : cards) {
            if (obj instanceof DebitCard) {
                DebitCard cards = (DebitCard) obj;
                if (cards.getCardId() == cardId) {
                    result = false;
                }
            }
        }
        return result;
    }


    public boolean checkCreditCardIdUnique(int cardId) {
        boolean result = true;
        for (BankCard obj : cards) {
            if (obj instanceof CreditCard) {
                CreditCard cards = (CreditCard) obj;
                if (cards.getCardId() == cardId) {
                    result = false;
                }
            }
        }
        return result;
    }


    public void displayDebit() {
        for (BankCard obj : cards) {
            if (obj instanceof DebitCard) {
                DebitCard debitCard = (DebitCard) obj;
                debitCard.display();
            }
        }
    }


    public void CreditDisplay() {
        for (BankCard obj : cards) {
            if (obj instanceof CreditCard) {
                CreditCard creditCard = (CreditCard) obj;
                creditCard.display();
            }


        }
    }


    //Debit Card Ends
    // Credit Card Area
    public int getCreditCardID() {
        int cardid = INVALID;
        try {
            cardid = Integer.parseInt(tf7.getText().trim());
            if (cardid <= 0) {
                cardid = INVALID;


            }
        } catch (Exception ae) {
            JOptionPane.showMessageDialog(null, "INVALID ERROR" + "\n" + "Please enter valid CardID",
                    "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
        }
        return cardid;
    }


    public String getCreditClientName() {
        return tf8.getText().trim();
    }


    public String getCreditIssuerBank() {
        return tf9.getText().trim();
    }


    public String getCreditBankAccount() {


     return tf10.getText().trim();


    }


    public double getCreditBalanceAmount() {
        int balanceAmount = INVALID;
        try {
            balanceAmount = Integer.parseInt(tf11.getText().trim());
            if (balanceAmount < 0) {
                balanceAmount = INVALID;
            }
        } catch (Exception ae) {
            JOptionPane.showMessageDialog(null, "INVALID INPUT" + "\n" + "Please enter valid Card ID",
                    "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
        }
        return balanceAmount;
    }


    public int getCVCNumber() {
        int CVCNumber = INVALID;
        try {
            CVCNumber = Integer.parseInt(tf12.getText());
            if (CVCNumber < 0) {
                CVCNumber = INVALID;
            }
        } catch (Exception ae) {
            JOptionPane.showMessageDialog(null, "INVALID INPUT" + "\n" + "Enter a valid CVC Number",
                    "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
        }


        return CVCNumber;
    }


    public double getInterestRate() {
        double rate = INVALID;
        try {
            rate = Double.parseDouble(tf13.getText());
            if (rate <= 0) {
                rate = INVALID;
            }
        } catch (Exception ae) {
            JOptionPane.showMessageDialog(null, "INVALID INPUT" + "\n" + "Please enter valid Interest Rate",
                    "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
        }


        return rate;
    }
    public String getExpirationDate() {
        String date = "";
        String year = c6.getSelectedItem().toString();
        String month = c5.getSelectedItem().toString();
        String day = c4.getSelectedItem().toString();


        if (year.equals("YEAR") || month.equals("MONTH") || day.equals("DAY")) {
            date = null;
        } else {
            date = (year + "-" + month + "-" + day);
        }
        return date;
    }
    public void addCredit() {
        String clientName = getCreditClientName();
        String issuerBank = getCreditIssuerBank();
        String Account = getCreditBankAccount();
        int card = getCreditCardID();
        double balance = getCreditBalanceAmount();
        double rate = getInterestRate();
        int CVCNumber = getCVCNumber();
        String expirationDate = getExpirationDate();


        if (clientName.isEmpty() || issuerBank.isEmpty() || Account.isEmpty()) {
            JOptionPane.showMessageDialog(null, "INVALID INPUT" + "\n" + "Fields cannot be empty",
                    "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);


            return;
        }


        if (CVCNumber <= 0) {
            JOptionPane.showMessageDialog(null,
                    "INVALID INPUT" + "\n" + "CVC Number cannot be less than 1", "ERROR MESSAGE",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (balance < 0) {
            JOptionPane.showMessageDialog(null,
                    "INVALID INPUT" + "\n" + "Balance Amount cannot be less than 0", "ERROR MESSAGE",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }


        if (expirationDate == null) {
            JOptionPane.showMessageDialog(null, "INVALID INPUT" + "\n" + "Enter Valid Expiration Date",
                    "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
            return;
        }


        if (card <= 0) {
            JOptionPane.showMessageDialog(null, "INVALID INPUT" + "\n" + "CardId cannot be less than 1",
                    "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
            return;
        }


        if (rate <= 0) {
            JOptionPane.showMessageDialog(null,
                    "INVALID INPUT" + "\n" + "Rate cannot be less than 1",
                    "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (checkCreditCardIdUnique(card) == true) {
            cards.add(new CreditCard(Integer.parseInt(clientName), issuerBank, Account, "" + card, (int) balance,
                    CVCNumber, rate, expirationDate));
            JOptionPane.showMessageDialog(null,
                    "INFO" + "\n" + "Client Name: " + clientName + "\n" + "Card ID : " + card
                            + "Issuer Bank: "
                            + issuerBank + "\n" + "Bank Account: " + Account + "\n" + "BalanceAmount: " + balance + "\n"
                            + "CVC Number: " + CVCNumber + "\n" + "Interest Rate: " + rate + "\n" + "Expiration Date: "
                            + expirationDate,
                    "DETAILS OF CARD", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Card ID must be unique",
                    "Error box", JOptionPane.ERROR_MESSAGE);
        }
    }


    // Credit Card Ends Here
    // Withdrawl
    public int getWCardId() {
        int cardId = INVALID;
        try {
            cardId = Integer.parseInt(tf14.getText().trim());
            if (cardId <= 0) {
                cardId = INVALID;
            }
        } catch (Exception ae) {
            JOptionPane.showMessageDialog(null, "INVALID INPUT" + "\n" + "Please enter valid Card Id",
                    "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
        }
        return cardId;
    }


    public int getWithdrawlAmount() {
        int withdrawamount = INVALID;
        try {
            withdrawamount = Integer.parseInt(tf15.getText().trim());
            if (withdrawamount <= 0) {
                withdrawamount = INVALID;
            }
        } catch (Exception ae) {
            JOptionPane.showMessageDialog(null, "INVALID INPUT" + "\n" + "Please enter valid withdrawal amount",
                    "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
        }
        return withdrawamount;
    }


    public int getPinnumber() {
        int pinNumber = INVALID;
        try {
            pinNumber = Integer.parseInt(tf16.getText().trim());
            if (pinNumber <= 0) {
                pinNumber = INVALID;
            }
        } catch (Exception ae) {
            JOptionPane.showMessageDialog(null, "INVALID INPUT" + "\n" + "Please enter valid Pin Number",
                    "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
        }
        return pinNumber;
    }


       
        public String getWithdrawalDate() {
            String date = "";
            String year = c3.getSelectedItem().toString();
            String month = c2.getSelectedItem().toString();
            String day = c1.getSelectedItem().toString();
            if (year.equals("YEAR") || month.equals("MONTH") || day.equals("DAY")) {
                date = null;
            } else {
                date = (year + "-" + month + "-" + day);
            }
            return date;
        }




    public void Withdraw() {


        int pinNo = getPinnumber();
        int withdrawAmount = getWithdrawlAmount();
        String withdrawalDate = getWithdrawalDate();
        int caRdId = getWCardId();


        if (getWithdrawlAmount() == INVALID) {
            JOptionPane.showMessageDialog(null,
                    "INVALID INPUT" + "\n" + "Withdraw Amount cannot be less than 1", "ERROR MESSAGE",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }


        if (getPinnumber() <= 0) {
            JOptionPane.showMessageDialog(null, "INVALID INPUT" + "\n" + "Pin Number cannot be less than 0",
                    "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(getPinNumber()!=pinNo){
            JOptionPane.showMessageDialog(null, "INVALID INPUT" + "\n" + "Pin Number doesn't Match",
                    "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
            return;
        }
       
        if (getWithdrawalDate() == null) {
            JOptionPane.showMessageDialog(null, "INVALID INPUT" + "\n" + "Enter Valid Withdrawal Date",
                    "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (getWCardId() == INVALID) {
            JOptionPane.showMessageDialog(null, "INVALID INPUT" + "\n" + "Enter Valid Card ID",
                    "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (getWithdrawlAmount()==INVALID||getWithdrawlAmount() > getAmountBalance()) {
            JOptionPane.showMessageDialog(null,
                    "INVALID INPUT" + "\n" +"Sorry You Only Have $"+ getAmountBalance() + " Right Now" ,"ERROR MESSAGE",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
       
        for (BankCard obj : cards) {
            if (obj instanceof DebitCard) {
                DebitCard debitCard = (DebitCard) obj;
                if (caRdId==getWCardId()) {
                    debitCard.withdraw(withdrawAmount,pinNo,withdrawalDate);
                    JOptionPane.showMessageDialog(null, "Withdrawal Successful ",
                            "Withdraw", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(null, "CARD ID NOT FOUND" + "\n" + "Enter correct Card ID",
                            "NOT FOUND", JOptionPane.WARNING_MESSAGE);
                }


            }
        }


    }


    // #endregion


    // #region for credit limit
    public int getCardid() {
        int cardid = INVALID;
        try {
            cardid = Integer.parseInt(tf17.getText());
            if (cardid <= 0) {
                JOptionPane.showMessageDialog(null, "INVALID INPUT" + "\n" + "CardId cannot be less than 1",
                        "ERROR MESSAGE", JOptionPane.INFORMATION_MESSAGE);


            }
        } catch (Exception ae) {
            JOptionPane.showMessageDialog(null, "INVALID INPUT" + "\n" + "Please enter valid Card ID",
                    "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
        }
        return cardid;
    }


    public double getCreditLimit() {
        double creditLimit = INVALID;
        try {
            creditLimit = Double.parseDouble(tf22.getText());
            if (creditLimit <= 0) {
                creditLimit = INVALID;
            }
        } catch (Exception ae) {
            JOptionPane.showMessageDialog(null, "INVALID INPUT" + "\n" + "Please enter valid CreditLimit",
                    "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
        }


        return creditLimit;
    }


    public int getGracePeriod() {
        int graceperiod = INVALID;
        try {
            graceperiod = Integer.parseInt(tf22.getText());
            if (graceperiod <= 0) {
                graceperiod = INVALID;
            }
        } catch (Exception ae) {
            JOptionPane.showMessageDialog(null, "INVALID INPUT" + "\n" + "Please enter valid GracePeriod",
                    "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
        }
        return graceperiod;
    }


    public void creditLimit() {
        int cardid =getWCardId();
        double creditlimit = getCreditLimit();
        int gracePeriod = getGracePeriod();
        if (cardid == INVALID) {
            JOptionPane.showMessageDialog(null, "INVALID INPUT" + "\n" + "CardId cannot be less than 1",
                    "ERROR MESSAGE", JOptionPane.INFORMATION_MESSAGE);
            return;
        }


        if (creditlimit == INVALID) {


            JOptionPane.showMessageDialog(null, "INVALID INPUT" + "\n" + "Credit Limit cannot be less than 1",
                    "ERROR MESSAGE", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (gracePeriod == INVALID) {


            JOptionPane.showMessageDialog(null, "INVALID INPUT" + "\n" + "Grace Period cannot be less than 1",
                    "ERROR MESSAGE", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        for (BankCard obj : cards) {
            if (obj instanceof CreditCard) {
                CreditCard creditCard = (CreditCard) obj;
                if (creditCard.getCardId() == cardid) {
                    creditCard.setCreditLimit((int) creditlimit, gracePeriod);
                    JOptionPane.showMessageDialog(null, "Credit Limit has been set",
                            "Credit Limit", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "CARD ID NOT FOUND" + "\n" + "Enter correct Card ID",
                            "NOT FOUND", JOptionPane.WARNING_MESSAGE);
                }


            }
        }
    }
    // #endregion


    // #region for cancel credit card
    public int getCancelCardId() {
        int cardId = INVALID;
        try {
            cardId = Integer.parseInt(tf1.getText());
            if (cardId <= 0) {
                cardId = INVALID;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "INVALID INPUT" + "\n" + "Please enter valid card Id",
                    "ERROR MESSAGE", JOptionPane.INFORMATION_MESSAGE);
        }
        return cardId;
    }


    public void cancelCreditCard() {
        boolean isfound = false;
        int cardID = getCancelCardId();


        for (BankCard obj : cards) {
            if (obj instanceof CreditCard) {
                CreditCard creditCard = (CreditCard) obj;
                if (creditCard.getCardId() == cardID) {
                    isfound = true;
                    creditCard.cancelCreditCard();
                    break;
                }
            }
        }
        if (isfound == true) {
            JOptionPane.showMessageDialog(null, "Canceled credit card", "success box",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(wpanel, "cardId doesnt match", "error Box",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }


    public BankGUI() {


        bigt = new Font(Font.DIALOG, Font.BOLD, 60);
        midt = new Font(Font.DIALOG, Font.ROMAN_BASELINE, 20);


        String day[] = { "Day", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
                "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" };
        String month[] = { "Month", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug",
                "Sep", "Oct", "Nov", "Dec" };
        String year[] = {"Year", "2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010",
        "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000" };


        dpanel = new JPanel();
        dpanel.setBackground(Color.white);
        dpanel.setLayout(null);


        l1 = new JLabel("Card ID : ");
        l1.setBounds(15, 14, 200, 30);
        l1.setFont(midt);
        dpanel.add(l1);


        l2 = new JLabel("Client Name: ");
        l2.setBounds(15, 59, 200, 30);
        l2.setFont(midt);
        dpanel.add(l2);


        l3 = new JLabel("Issuer Bank: ");
        l3.setBounds(15, 98, 200, 30);
        l3.setFont(midt);
        dpanel.add(l3);


        l4 = new JLabel("Bank Account: ");
        l4.setBounds(15, 133, 200, 30);
        l4.setFont(midt);
        dpanel.add(l4);


        l5 = new JLabel("Balance Amount: ");
        l5.setBounds(16, 176, 200, 30);
        l5.setFont(midt);
        dpanel.add(l5);


        l6 = new JLabel("Pin Number: ");
        l6.setBounds(17, 214, 200, 30);
        l6.setFont(midt);
        dpanel.add(l6);


        tf1 = new JTextField();
        tf1.setBorder(BorderFactory.createLineBorder(Color.black));
        tf1.setBounds(225, 14, 200, 30);
        dpanel.add(tf1);


        tf2 = new JTextField();
        tf2.setBorder(BorderFactory.createLineBorder(Color.black));
        tf2.setBounds(225, 50, 200, 30);
        dpanel.add(tf2);


        tf3 = new JTextField();
        tf3.setBorder(BorderFactory.createLineBorder(Color.black));
        tf3.setBounds(225, 90, 200, 30);
        dpanel.add(tf3);


        tf4 = new JTextField();
        tf4.setBorder(BorderFactory.createLineBorder(Color.black));
        tf4.setBounds(225, 130, 200, 30);
        dpanel.add(tf4);


        tf5 = new JTextField();
        tf5.setBorder(BorderFactory.createLineBorder(Color.black));
        tf5.setBounds(225, 170, 200, 30);
        dpanel.add(tf5);


        tf6 = new JTextField();
        tf6.setBorder(BorderFactory.createLineBorder(Color.black));
        tf6.setBounds(225, 210, 200, 30);
        dpanel.add(tf6);


        bt1 = new JButton("Add Debit Card");
        bt1.setBounds(35, 249, 200, 40);
        bt1.setFont(midt);
        bt1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                addDebit();
            }
        });
        dpanel.add(bt1);


        bt2 = new JButton("Display");
        bt2.setBounds(260, 249, 200, 40);
        bt2.setFont(midt);
        bt2.addActionListener((e) -> {
                displayDebit();
        });
        dpanel.add(bt2);


        bt3 = new JButton("Clear");
        bt3.setBounds(470, 249, 200, 40);
        bt3.setFont(midt);
        dpanel.add(bt3);
        bt3.addActionListener((e) -> {
                tf1.setText("");
                tf2.setText("");
                tf3.setText("");
                tf4.setText("");
                tf5.setText("");
                tf6.setText("");


        });


        cpanel = new JPanel();
        cpanel.setBackground(Color.white);
        cpanel.setLayout(null);


       
        l1 = new JLabel("Card ID : ");
        l1.setBounds(10, 10, 200, 30);
        l1.setFont(midt);
        cpanel.add(l1);


        l2 = new JLabel("Client Name: ");
        l2.setBounds(10, 50, 200, 30);
        l2.setFont(midt);
        cpanel.add(l2);


        l3 = new JLabel("Issuer Bank: ");
        l3.setBounds(10, 90, 200, 30);
        l3.setFont(midt);
        cpanel.add(l3);


        l4 = new JLabel("Bank Account: ");
        l4.setBounds(10, 130, 200, 30);
        l4.setFont(midt);
        cpanel.add(l4);


        l5 = new JLabel("Balance Amount: ");
        l5.setBounds(10, 170, 200, 30);
        l5.setFont(midt);
        cpanel.add(l5);


        l6 = new JLabel("CVC Number: ");
        l6.setBounds(10, 210, 200, 30);
        l6.setFont(midt);
        cpanel.add(l6);


        l7 = new JLabel("Interest Rate: ");
        l7.setBounds(10, 250, 200, 30);
        l7.setFont(midt);
        cpanel.add(l7);


        l8 = new JLabel("Expiration Date: ");
        l8.setBounds(10, 290, 200, 30);
        l8.setFont(midt);
        cpanel.add(l8);


        tf7 = new JTextField();
        tf7.setBorder(BorderFactory.createLineBorder(Color.black));
        tf7.setBounds(220, 10, 200, 30);
        cpanel.add(tf7);


        tf8 = new JTextField();
        tf8.setBorder(BorderFactory.createLineBorder(Color.black));
        tf8.setBounds(220, 50, 200, 30);
        cpanel.add(tf8);


        tf9 = new JTextField();
        tf9.setBorder(BorderFactory.createLineBorder(Color.black));
        tf9.setBounds(220, 90, 200, 30);
        cpanel.add(tf9);


        tf10 = new JTextField();
        tf10.setBorder(BorderFactory.createLineBorder(Color.black));
        tf10.setBounds(220, 130, 200, 30);
        cpanel.add(tf10);


        tf11 = new JTextField();
        tf11.setBorder(BorderFactory.createLineBorder(Color.black));
        tf11.setBounds(220, 170, 200, 30);
        cpanel.add(tf11);


        tf12 = new JTextField();
        tf12.setBorder(BorderFactory.createLineBorder(Color.black));
        tf12.setBounds(220, 210, 200, 30);
        cpanel.add(tf12);


        tf13 = new JTextField();
        tf13.setBorder(BorderFactory.createLineBorder(Color.black));
        tf13.setBounds(220, 250, 200, 30);
        cpanel.add(tf13);


        c4 = new JComboBox<>(day);
        c4.setBounds(215, 290, 75, 30);
        cpanel.add(c4);


        c5 = new JComboBox<>(month);
        c5.setBounds(285, 290, 90, 30);
        cpanel.add(c5);


        c6 = new JComboBox<>(year);
        c6.setBounds(370, 290, 85, 30);
        cpanel.add(c6);


        bt1 = new JButton("Add Credit Card");
        bt1.setBounds(10, 330, 200, 40);
        bt1.setFont(midt);
        bt1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                addCredit();
            }
        });
        cpanel.add(bt1);


        bt2 = new JButton("Display");
        bt2.setBounds(220, 330, 200, 40);
        bt2.setFont(midt);
        bt2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                CreditDisplay();
            }
        });
        cpanel.add(bt2);


        bt3 = new JButton("Clear");
        bt3.setBounds(650, 330, 100, 40);
        bt3.setFont(midt);
        bt3.addActionListener((e) -> {
                tf7.setText("");
                tf8.setText("");
                tf9.setText("");
                tf10.setText("");
                tf11.setText("");
                tf12.setText("");
                tf13.setText("");
                c4.setSelectedIndex(0);
                c5.setSelectedIndex(0);
                c6.setSelectedIndex(0);
        });
        cpanel.add(bt3);
       
        wpanel = new JPanel();
        wpanel.setBackground(Color.BLUE);
        wpanel.setLayout(null);


   


        l1 = new JLabel("Card ID : ");
        l1.setBounds(10, 15, 200, 30);
        l1.setFont(midt);
        wpanel.add(l1);


        l2 = new JLabel("Withdrawal Amount: ");
        l2.setBounds(10, 65, 200, 30);
        l2.setFont(midt);
        wpanel.add(l2);


        l3 = new JLabel("Date of Withdrawal: ");
        l3.setBounds(10, 115, 200, 30);
        l3.setFont(midt);
        wpanel.add(l3);


        l4 = new JLabel("Pin Number: ");
        l4.setBounds(10, 165, 200, 30);
        l4.setFont(midt);
        wpanel.add(l4);


        tf14 = new JTextField();
        tf14.setBorder(BorderFactory.createLineBorder(Color.black));
        tf14.setBounds(220, 15, 200, 30);
        wpanel.add(tf14);


        tf15 = new JTextField();
        tf15.setBorder(BorderFactory.createLineBorder(Color.black));
        tf15.setBounds(220, 65, 200, 30);
        wpanel.add(tf15);


        c1 = new JComboBox<>(day);
        c1.setBounds(215, 115, 75, 30);
        wpanel.add(c1);


        c2 = new JComboBox<>(month);
        c2.setBounds(285, 115, 90, 30);
        wpanel.add(c2);


        c3 = new JComboBox<>(year);
        c3.setBounds(370, 115, 85, 30);
        wpanel.add(c3);


        tf16 = new JTextField();
        tf16.setBorder(BorderFactory.createLineBorder(Color.black));
        tf16.setBounds(220, 165, 200, 30);
        wpanel.add(tf16);


        bt1 = new JButton("Withdraw");
        bt1.setBounds(60, 210, 200, 40);
        bt1.setFont(midt);
       
        wpanel.add(bt1);
        bt1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                Withdraw();
            }
        });


        bt3 = new JButton("Clear");
        bt3.setBounds(280, 210, 200, 40);
        bt3.setFont(midt);
        bt3.addActionListener((e) -> {
                tf14.setText("");
                tf15.setText("");
                tf16.setText("");
                c1.setSelectedIndex(0);
                c2.setSelectedIndex(0);
                c3.setSelectedIndex(0);
        });
        wpanel.add(bt3);
       
        clpanel = new JPanel();
        clpanel.setBorder(BorderFactory.createTitledBorder("Credit Limt"));
        clpanel.setBackground(Color.yellow);
        l1 = new JLabel("Card ID : ");
        l1.setBounds(20,80,120,40);
        clpanel.setLayout(null);
        l1.setFont(midt);
        clpanel.add(l1);
       
        l10 = new JLabel("Credit Limit : ");
        l10.setBounds(20,160,120,40 );
        l10.setFont(midt);
        clpanel.add(l10);


        l11 = new JLabel("Grace Period : ");
        l11.setBounds(20, 230, 150,40);
        l11.setFont(midt);
        clpanel.add(l11);


        tf18 = new JTextField();
        tf20 = new JTextField();
        tf22 = new JTextField();
        tf18.setBounds(160,80,200,40);
        tf20.setBounds(160,170,200,40);
        tf22.setBounds(160,230,200,40);
        tf18.setBorder(BorderFactory.createLineBorder(Color.black));
        tf20.setBorder(BorderFactory.createLineBorder(Color.black));
        tf22.setBorder(BorderFactory.createLineBorder(Color.black));
        clpanel.add(tf18);
        clpanel.add(tf20);
        clpanel.add(tf22);


        bt4 = new JButton("Set Cedit Limit");
        bt4.setFont(midt);
        bt4.setBounds(160,290 , 190,50);
        clpanel.add(bt4);
        bt4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent pa) {
                creditLimit();
            }
        });
       
        f1 = new JFrame();
        f1.setTitle("Bank GUI");
        f1.setFont(bigt);
        f1.setSize(1800, 900);
        f1.setLayout(new GridLayout(2, 2));
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        bt5 = new JButton("Cancel Credit Card");
        bt5.setBounds(430, 330, 210, 40);
        bt5.setFont(midt);
        cpanel.add(bt5);
        bt5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                cancelCreditCard();
            }
        });




        cpanel.setBorder(BorderFactory.createTitledBorder("Credit Card"));
        wpanel.setBorder(BorderFactory.createTitledBorder("Withdraw "));
        dpanel.setBorder(BorderFactory.createTitledBorder("Debit Card"));
        dpanel.setFont(bigt);




        wpanel.setBackground(Color.yellow);
        cpanel.setBackground(Color.yellow);
        dpanel.setBackground(Color.YELLOW);
        f1.add(dpanel);
        f1.add(cpanel);
        f1.add(wpanel);
        f1.add(clpanel);
        f1.setVisible(true);


    }
   
    public static void main(String[] args) {
        new BankGUI();


    }


}

