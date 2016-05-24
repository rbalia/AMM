package amm.milestone3.classi;

/**
 *
 * @author Riccardo Balia 65106
 */
public class AccountBalance {
   
    public Integer ID;
    public Double balance;
    
    public AccountBalance()
    {}
    public AccountBalance(Double balance)
    {
        this.balance=balance;
    }
    /**
     * @return the balance
     */
    public Double getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(Double balance) {
        this.balance = balance;
    }
    
}
