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
 * @author Riccardo Balia 65106
 */
public class ObjectFactory{
    
    private static ObjectFactory singleton;
    public String connectionString;

    public static ObjectFactory getInstance() {
        if (singleton == null) {
            singleton = new ObjectFactory();
        }
        return singleton;
    }

    /* Costruttore */
    public ObjectFactory()
    {  }
   
    
    //Restituisco l'id del venditore di un oggetto   
    public Integer getIdSellerFromObject(Integer objectID) 
    {
        String query;
        try 
            {          
            String databaseUsername = "riccardobalia";
            String databasePassword = "0000";
            //Passo path, e le credenziali per l'accesso al database
            Connection conn = DriverManager.getConnection(connectionString,databaseUsername,databasePassword);
                
            //RICERCA VENDITORE TRA GLI OGGETTI IN BASE ALL' ID DELL'OGGETTO
            query = "SELECT  idSeller " 
                   + "FROM ObjectSale " 
                   + "WHERE ObjectSale.id = ?";
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            //Dati
            stmt.setInt(1, objectID);
            //Avvio la query
            ResultSet objectResult = stmt.executeQuery();

            if(objectResult.next())
            {   
                Integer sellerID = (objectResult.getInt("idSeller"));
   

                stmt.close();
                conn.close();

                return sellerID;
            }
        }
        catch(SQLException e)
        {
           return null; 
        }
       return null;
    }
    
    //Restituisco tutti gli oggetti
    public ArrayList<ObjectSale> getObjectList() 
    { 
        ArrayList<ObjectSale> objectList = new ArrayList<>();

        String query;
        try 
            {          
            String databaseUsername = "riccardobalia";
            String databasePassword = "0000";
            //Passo path, e le credenziali per l'accesso al database
            Connection conn = DriverManager.getConnection(connectionString,databaseUsername,databasePassword);
                
            //RICERCA TUTTI GLI OGGETTI
            query = "SELECT  * " 
                   + "FROM ObjectSale ";
            //Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            //Avvio la query
            ResultSet customerResult = stmt.executeQuery();

            while(customerResult.next())
            {   
                ObjectSale objByID = new ObjectSale();
                objByID.setId(customerResult.getInt("id"));
                objByID.setName(customerResult.getString("name"));
                objByID.setImageURL(customerResult.getString("imageUrl"));
                objByID.setDescription(customerResult.getString("description"));
                objByID.setPrice(customerResult.getDouble("price"));
                objByID.setAvailability(customerResult.getInt("availability"));
                objByID.setCategory(customerResult.getString("category"));

                objectList.add(objByID);  
            }
            stmt.close();
            conn.close();

            return objectList;
        }
        catch(SQLException e)
        {
           return null; 
        }

    }
    
    //Restituisco l'oggetto che corrispondono a un id   
    public ObjectSale getObjectListByID(Integer targetID) 
    {
        String query;
        try 
            {          
            String databaseUsername = "riccardobalia";
            String databasePassword = "0000";
            //Passo path, e le credenziali per l'accesso al database
            Connection conn = DriverManager.getConnection(connectionString,databaseUsername,databasePassword);
                
            //RICERCA TRA I GLI OGGETTI IN BASE ALL' ID
            query = "SELECT  * " 
                   + "FROM ObjectSale " 
                   + "WHERE ObjectSale.id = ?";
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            //Dati
            stmt.setInt(1, targetID);
            //Avvio la query
            ResultSet customerResult = stmt.executeQuery();

            if(customerResult.next())
            {   
                ObjectSale objByID = new ObjectSale();
                objByID.setId(customerResult.getInt("id"));
                objByID.setName(customerResult.getString("name"));
                objByID.setImageURL(customerResult.getString("imageUrl"));
                objByID.setDescription(customerResult.getString("description"));
                objByID.setPrice(customerResult.getDouble("price"));
                objByID.setAvailability(customerResult.getInt("availability"));
                objByID.setCategory(customerResult.getString("category"));

                stmt.close();
                conn.close();

                return objByID;
            }
        }
        catch(SQLException e)
        {
           return null; 
        }
       return null;
    }
    
    //Restituisco gli oggetti che corrispondono a una categoria
    public ArrayList<ObjectSale> getObjectListByCategory(String targetCategory) {
        
        ArrayList<ObjectSale> matchedObjects = new ArrayList<>();

        String query;
        try 
            {          
            String databaseUsername = "riccardobalia";
            String databasePassword = "0000";
            //Passo path, e le credenziali per l'accesso al database
            Connection conn = DriverManager.getConnection(connectionString,databaseUsername,databasePassword);
                
            //RICERCA GLI OGGETTI CON UNA DETERMINATA CATEGORIA
            query = "SELECT  * " 
                   + "FROM ObjectSale " 
                   + "WHERE ObjectSale.category = ?";
            //Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            //Dati
            stmt.setString(1, targetCategory);
            //Avvio la query
            ResultSet result = stmt.executeQuery();

            while(result.next())
            {   
                ObjectSale objByCategory = new ObjectSale();
                objByCategory.setId(result.getInt("id"));
                objByCategory.setName(result.getString("name"));
                objByCategory.setImageURL(result.getString("imageUrl"));
                objByCategory.setDescription(result.getString("description"));
                objByCategory.setPrice(result.getDouble("price"));
                objByCategory.setAvailability(result.getInt("availability"));
                objByCategory.setCategory(result.getString("category"));

                matchedObjects.add(objByCategory);  
            }
            stmt.close();
            conn.close();

            return matchedObjects;
        }
        catch(SQLException e)
        {
           return null; 
        }

    }
    
    //Restituisco gli oggetti che corrispondono a una categoria e sono di un determinato venditore
    //(E' una modifica di getObjectListByCategory() )
    public ArrayList<ObjectSale> getObjectListByCategoryAndSellerID(String targetCategory, Integer sellerID) {
        
        ArrayList<ObjectSale> matchedObjects = new ArrayList<>();

        String query;
        try 
            {          
            String databaseUsername = "riccardobalia";
            String databasePassword = "0000";
            //Passo path, e le credenziali per l'accesso al database
            Connection conn = DriverManager.getConnection(connectionString,databaseUsername,databasePassword);
                
            //RICERCA GLI OGGETTI CON UNA DETERMINATA CATEGORIA
            query = "SELECT  * " 
                   + "FROM ObjectSale " 
                   + "WHERE ObjectSale.IdSeller = ? AND ObjectSale.category = ? ";
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            //Dati
            stmt.setInt(1, sellerID);
            stmt.setString(2, targetCategory);
            
            //Avvio la query
            ResultSet result = stmt.executeQuery();

            while(result.next())
            {   
                ObjectSale objByIDSeller = new ObjectSale();
                objByIDSeller.setId(result.getInt("id"));
                objByIDSeller.setName(result.getString("name"));
                objByIDSeller.setImageURL(result.getString("imageUrl"));
                objByIDSeller.setDescription(result.getString("description"));
                objByIDSeller.setPrice(result.getDouble("price"));
                objByIDSeller.setAvailability(result.getInt("availability"));
                objByIDSeller.setCategory(result.getString("category"));

                matchedObjects.add(objByIDSeller);  
            }
            stmt.close();
            conn.close();

            return matchedObjects;
        }
        catch(SQLException e)
        {
           return null; 
        }

    }
    
    //Cancello l'oggetto selezionato.
    public void deleteObject(Integer targetID) 
    {
        String query;
        try 
            {          
            String databaseUsername = "riccardobalia";
            String databasePassword = "0000";
            //Passo path, e le credenziali per l'accesso al database
            Connection conn = DriverManager.getConnection(connectionString,databaseUsername,databasePassword);
                
            //ELIMINO L'OGGETTO IN BASE ALL' ID
            query = "DELETE FROM ObjectSale "
                  + "WHERE id = ? ";
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            //Dati
            stmt.setInt(1, targetID);
            //Avvio la query
            stmt.executeUpdate();
            
            stmt.close();
            conn.close();
            
        }
        catch(SQLException e)
        {
            
        }
    }
    
    //Modifica oggetto selezionato
    public void editObject(Integer targetID, String name,String urlImage, String price, String availability,String description) 
    {
        String query;
        try 
            {          
            String databaseUsername = "riccardobalia";
            String databasePassword = "0000";
            //Passo path, e le credenziali per l'accesso al database
            Connection conn = DriverManager.getConnection(connectionString,databaseUsername,databasePassword);
                
            //MODIFICO L'OGGETTO IN BASE ALL' ID
            /*Con min e step come proprietà degli input sull'HTML generato mi assicuro di ricevere interi e decimali
           come stringa che successivamente assegno nel formato corretto nella query*/
            query = "UPDATE ObjectSale "
                  + "SET ObjectSale.name = ?, "
                      + "ObjectSale.imageUrl = ?, "
                      + "ObjectSale.description = ?, "
                      + "ObjectSale.price = ?, "
                      + "ObjectSale.availability = ? "
                  + "WHERE id = ? ";
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            //Dati
            stmt.setString(1, name);
            stmt.setString(2, urlImage);
            stmt.setString(3, description);
            stmt.setDouble(4, Double.valueOf(price));
            stmt.setInt(5, Integer.valueOf(availability));
            stmt.setInt(6, targetID);
            //Avvio la query
            stmt.executeUpdate();
            
            stmt.close();
            conn.close();
            
        }
        catch(SQLException e)
        {
            
        }
    }
    
    //Modifica la disponibilità dell'oggetto selezionato
    //E' una modifica di editObject(), si occupa di decrementare la disponibilità dell'oggetto
    public void decreaseObjectAvailability(Integer targetID,Integer availability) 
    {
        String query;
        availability--;
        try 
            {          
            String databaseUsername = "riccardobalia";
            String databasePassword = "0000";
            //Passo path, e le credenziali per l'accesso al database
            Connection conn = DriverManager.getConnection(connectionString,databaseUsername,databasePassword);
            //Aggiorno oggetto con disponibilita--    
            query = "UPDATE ObjectSale "
                  + "SET ObjectSale.availability = ? "
                  + "WHERE id = ? ";
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            //Dati
            stmt.setInt(1, availability);
            stmt.setInt(2, targetID);
            //Avvio la query
            stmt.executeUpdate();
            
            stmt.close();
            conn.close();
            
        }
        catch(SQLException e)
        {
            
        }
    }
    
    //Aggiunge un oggetto al database
    public void addObject(String name,String urlImage, String price, String availability,String description,String category, Integer sellerID) 
    {
        String query;
        try 
            {          
            String databaseUsername = "riccardobalia";
            String databasePassword = "0000";
            //Passo path, e le credenziali per l'accesso al database
            Connection conn = DriverManager.getConnection(connectionString,databaseUsername,databasePassword);
                
            //CREO UN NUOVO OGGETTO
            /*Con min e step come proprietà degli input sull'HTML generato mi assicuro di ricevere interi e decimali
            come stringa che successivamente assegno nel formato corretto nella query*/
            query = " INSERT INTO OBJECTSALE ( id , name , imageURL , description , price , availability , category , idSeller ) "
                  + "VALUES ( default , ? , ? , ? , ? , ? , ? , ? ) " ;

            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            //Dati
            stmt.setString(1, name);
            stmt.setString(2, urlImage);
            stmt.setString(3, description);
            stmt.setDouble(4, Double.valueOf(price));
            stmt.setInt(5, Integer.valueOf(availability));
            stmt.setString(6, category);
            stmt.setInt(7, sellerID);

            //Avvio la query
            stmt.executeUpdate();
            
            stmt.close();
            conn.close();
            
        }
        catch(SQLException e)
        {
            
        }
    }
    
    //Transizione: Il Cliente tenta di acquistare un oggetto.
    public void buyObject (Integer objectID, Integer customerID) throws SQLException{
        
        String databaseUsername = "riccardobalia";
        String databasePassword = "0000";
        //Passo path, e le credenziali per l'accesso al database
        Connection conn = DriverManager.getConnection(connectionString,databaseUsername,databasePassword);
        
        try 
        {
            
            
            conn.setAutoCommit(false);
            //Ottengo i dati del cliente che effettua l'acquisto, l'oggetto acquistato e il venditore
            Integer sellerID = ObjectFactory.getInstance().getIdSellerFromObject(objectID); 
            CustomerUser customer = UserFactory.getInstance().getCustomerByID(customerID);
            SellerUser seller = UserFactory.getInstance().getSellerByID(sellerID);
            ObjectSale onCartObject = ObjectFactory.getInstance().getObjectListByID(objectID);
           
            
            //Se ci sono più oggetti dello stesso tipo decrementa la disponibilità
            if(onCartObject.getAvailability() > 1) //ObjectFactory.getInstance().decreaseObjectAvailability(objectID, onCartObject.getAvailability());(impossibile fare rollback)
            {
                Integer availabilityDecresed = onCartObject.getAvailability();
                availabilityDecresed = availabilityDecresed - 1;

                String decreaseQuery = "UPDATE ObjectSale "
                      + "SET ObjectSale.availability = ? "
                      + "WHERE id = ? ";
                //Prepared Statement
                PreparedStatement stmtDecrese = conn.prepareStatement(decreaseQuery);
                //Dati
                stmtDecrese.setInt(1, availabilityDecresed);
                stmtDecrese.setInt(2, objectID);
                //Avvio la query
                stmtDecrese.executeUpdate();
                
                stmtDecrese.close();
            }    
            //Se c'è un solo oggetto a disposizione, si cancella dal database
            if(onCartObject.getAvailability() == 1)//ObjectFactory.getInstance().deleteObject(objectID); (impossibile fare rollback) 
            {
                         
                //ELIMINO L'OGGETTO IN BASE ALL' ID
                String deleteQuery = "DELETE FROM ObjectSale "
                             + "WHERE id = ? ";
                // Prepared Statement
                PreparedStatement stmtDelete = conn.prepareStatement(deleteQuery);
                //Dati
                stmtDelete.setInt(1, objectID);
                //Avvio la query e chiudo
                stmtDelete.executeUpdate();
                stmtDelete.close();
            }
        
            String SellerAccountBalanceIDQuery = 
                    "SELECT  idAccountBalance " 
                    + "FROM Seller " 
                    + "WHERE Seller.id = ?";
            String CustomerAccountBalanceIDQuery = 
                    "SELECT  idAccountBalance " 
                    + "FROM Customer " 
                    + "WHERE Customer.id = ?";
            PreparedStatement stmtCustomerBalanceID = conn.prepareStatement(CustomerAccountBalanceIDQuery);
            PreparedStatement stmtSellerBalanceID = conn.prepareStatement(SellerAccountBalanceIDQuery);
            

            stmtSellerBalanceID.setInt(1, sellerID);
            stmtCustomerBalanceID.setInt(1, (customer.getId()) );
            
            ResultSet res1 = stmtSellerBalanceID.executeQuery();
            ResultSet res2 = stmtCustomerBalanceID.executeQuery();
            
            Integer SellerAccountBalanceID = null;
            Integer CustomerAccountBalanceID = null;
            
            if(res1.next())
            {
               SellerAccountBalanceID = (res1.getInt("idAccountBalance")); 
               stmtSellerBalanceID.close();    
            } 
             
            if(res2.next())
            {
               CustomerAccountBalanceID = (res2.getInt("idAccountBalance")); 
               stmtCustomerBalanceID.close();    
            }
             
            
            
            //Stringhe per l'aggiornamento del database
            String editSellerQuery =   "UPDATE AccountBalance "
                                     + "SET balance = ? "
                                     + "WHERE AccountBalance.id = ? ";
            String editCustomerQuery = "UPDATE AccountBalance "
                                     + "SET balance = ? "
                                     + "WHERE AccountBalance.id = ? ";
            
            //Prepared Statement
            PreparedStatement stmtCustomer = conn.prepareStatement(editSellerQuery);
            PreparedStatement stmtSeller = conn.prepareStatement(editCustomerQuery);

            //Soldi per il Venditore
            //Double sellerMoney = (seller.getAccountBalance() + onCartObject.getPrice() );
            Double sellerMoney = ((seller.getAccountBalance()*100) + (onCartObject.getPrice() * 100));
           
            //Soldi per il Cliente
            Double customerMoney = ((customer.getAccountBalance()*100)-(onCartObject.getPrice()*100));
            
            sellerMoney=sellerMoney/100;
            customerMoney=customerMoney/100;
            
            //dati per tabella Venditore
            stmtSeller.setDouble(1, sellerMoney);
            stmtSeller.setInt(2, SellerAccountBalanceID);
            //Dati per tabella Cliente
            stmtCustomer.setDouble(1, customerMoney);
            stmtCustomer.setInt(2, CustomerAccountBalanceID);
            
            //Avvio la query
            stmtCustomer.executeUpdate();
            stmtSeller.executeUpdate();
            
            
            
            
                if(customerMoney < 0)
                    conn.rollback();
                
            stmtCustomer.close();
            stmtSeller.close();
            
                      
            conn.commit();
        }
        catch(SQLException e)
        {
            
            try
            {
                conn.rollback();
            }catch(SQLException e2)
            {
                
            }
        }
        finally
        {
            conn.setAutoCommit(true);
            conn.close();
        }
    }
  
    
    // ConnectionString
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    public String getConnectionString(){
	return this.connectionString;
    }
}
