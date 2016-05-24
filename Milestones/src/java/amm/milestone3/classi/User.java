package amm.milestone3.classi;

/**
 *
 * @author Riccardo Balia 65106
 */
public abstract class User {
    
    /* Attributi */
    public String name;
    public String surname;
    public String username;
    public String password;
    public Integer id;
    public AccountBalance accountBalance;
    
    
    /* Costruttore */
    public User(){
    }
    
    public User(String name, String surname, String username, String password, Integer id, Double balance)
    {
        this.name=name;
        this.surname=surname;
        this.username=username;
        this.password=password;
        this.id=id;
        this.accountBalance = new AccountBalance(balance);
    }
    /* Metodi */
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the ID to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the balance
    */ 
    public Double getAccountBalance() {
        return accountBalance.getBalance();
    }

    /**
     * @param balance the balance to set
    */ 
    public void setAccountBalance(Double balance) {
        this.accountBalance = new AccountBalance(balance);
    }

}