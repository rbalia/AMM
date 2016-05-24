package amm.milestone3.classi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ricca
 */
public class UserFactory {
    
    private static UserFactory singleton;
    public String connectionString;

    public static UserFactory getInstance() {
        if (singleton == null) {
            singleton = new UserFactory();
        }
        return singleton;
    }

    
    /* Costruttore */
    public UserFactory()
    {
    
    }
    ArrayList<User> userList = new ArrayList<>();
    
    /* Metodi */
    //Restituisco venditore
    public SellerUser getSeller(String username, String password)
    {
        String query;
        try 
        {   
           
            String databaseUsername = "riccardobalia";
            String databasePassword = "0000";
            //Passo path, e le credenziali per l'accesso al database
            Connection conn = DriverManager.getConnection(connectionString,databaseUsername,databasePassword);
            
            //RICERCA TRA I VENDITORI 
            //Query per la ricerca tra Venditori
            query = "SELECT  Seller.id,Seller.name,Seller.surname,Seller.username,Seller.password,AccountBalance.balance " 
                   + "FROM Seller " 
                   +"JOIN AccountBalance ON Seller.IDACCOUNTBALANCE = AccountBalance.ID " 
                   + "WHERE Seller.username = ? AND Seller.password = ?";
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            // dati
            stmt.setString(1, username);
            stmt.setString(2, password);
            //Avvio la query
            ResultSet sellerResult = stmt.executeQuery();
            
            if(sellerResult.next())
            {
                SellerUser seller = new SellerUser();
                seller.setId(sellerResult.getInt("id"));
                seller.setName(sellerResult.getString("name"));
                seller.setSurname(sellerResult.getString("surname"));
                seller.setUsername(sellerResult.getString("username"));
                seller.setPassword (sellerResult.getString("password"));
                seller.setAccountBalance (sellerResult.getDouble("balance"));
    
                stmt.close();
                conn.close();
                
                return seller;
            }   
        }
        catch(SQLException e)
        {
           return null; 
        }
       return null;
    }
    
    public CustomerUser getCustomer(String username,String password){
            
        String query;
        try 
            {  
                    
            String databaseUsername = "riccardobalia";
            String databasePassword = "0000";
            //Passo path, e le credenziali per l'accesso al database
            Connection conn = DriverManager.getConnection(connectionString,databaseUsername,databasePassword);
                
            //RICERCA TRA I CLIENTI
            query = "SELECT  Customer.id,Customer.name,Customer.surname,Customer.username,Customer.password,AccountBalance.balance " 
                   + "FROM Customer " 
                   + "JOIN AccountBalance ON Customer.IDACCOUNTBALANCE = AccountBalance.ID " 
                   + "WHERE Customer.username = ? AND Customer.password = ?";
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            // dati
            stmt.setString(1, username);
            stmt.setString(2, password);
            //Avvio la query
            ResultSet customerResult = stmt.executeQuery();

            if(customerResult.next())
            {
                CustomerUser customer = new CustomerUser();
                customer.setId(customerResult.getInt("id"));
                customer.setName(customerResult.getString("name"));
                customer.setSurname(customerResult.getString("surname"));
                customer.setUsername(customerResult.getString("username"));
                customer.setPassword (customerResult.getString("password"));
                customer.setAccountBalance (customerResult.getDouble("balance"));

                stmt.close();
                conn.close();

                return customer;
            }
        }
        catch(SQLException e)
        {
           return null; 
        }
       return null;
    }
    
    //Cerco il cliente in base all'ID
    public CustomerUser getCustomerByID(Integer customerID){
            
        String query;
        try 
            {  
                    
            String databaseUsername = "riccardobalia";
            String databasePassword = "0000";
            //Passo path, e le credenziali per l'accesso al database
            Connection conn = DriverManager.getConnection(connectionString,databaseUsername,databasePassword);
                
            //RICERCA TRA I CLIENTI IN BASE ALL'ID
            query = "SELECT  Customer.id,Customer.name,Customer.surname,Customer.username,Customer.password,AccountBalance.balance " 
                   + "FROM Customer " 
                   + "JOIN AccountBalance ON Customer.IDACCOUNTBALANCE = AccountBalance.ID " 
                   + "WHERE Customer.id = ?";
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            //dati
            stmt.setInt(1, customerID);
            //Avvio la query
            ResultSet customerResult = stmt.executeQuery();

            if(customerResult.next())
            {
                CustomerUser customer = new CustomerUser();
                customer.setId(customerResult.getInt("id"));
                customer.setName(customerResult.getString("name"));
                customer.setSurname(customerResult.getString("surname"));
                customer.setUsername(customerResult.getString("username"));
                customer.setPassword (customerResult.getString("password"));
                customer.setAccountBalance (customerResult.getDouble("balance"));

                stmt.close();
                conn.close();

                return customer;
            }
        }
        catch(SQLException e)
        {
           return null; 
        }
       return null;
    }
    
    //Cerco il venditore in base all'ID
    public SellerUser getSellerByID(Integer sellerID){
            
        String query;
        try 
            {  
                    
            String databaseUsername = "riccardobalia";
            String databasePassword = "0000";
            //Passo path, e le credenziali per l'accesso al database
            Connection conn = DriverManager.getConnection(connectionString,databaseUsername,databasePassword);
                
            //RICERCA TRA I CLIENTI
            query = "SELECT  Seller.id,Seller.name,Seller.surname,Seller.username,Seller.password,AccountBalance.balance " 
                   + "FROM Seller " 
                   + "JOIN AccountBalance ON Seller.IDACCOUNTBALANCE = AccountBalance.ID " 
                   + "WHERE Seller.id = ?";
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            // dati
            stmt.setInt(1, sellerID);
            //Avvio la query
            ResultSet sellerResult = stmt.executeQuery();

            if(sellerResult.next())
            {
                SellerUser seller = new SellerUser();
                seller.setId(sellerResult.getInt("id"));
                seller.setName(sellerResult.getString("name"));
                seller.setSurname(sellerResult.getString("surname"));
                seller.setUsername(sellerResult.getString("username"));
                seller.setPassword (sellerResult.getString("password"));
                seller.setAccountBalance (sellerResult.getDouble("balance"));

                stmt.close();
                conn.close();

                return seller;
            }
        }
        catch(SQLException e)
        {
           return null; 
        }
       return null;
    }
    
    //Restituisco l'utente loggato
    public User getUser(String username, String password) 
    {
        
        User loggedUser = getSeller(username,password);
        
        if(loggedUser == null){
            loggedUser = getCustomer(username,password);
        }
        
        return loggedUser;
    }
    
    // ConnectionString
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    public String getConnectionString(){
	return this.connectionString;
    }
}

