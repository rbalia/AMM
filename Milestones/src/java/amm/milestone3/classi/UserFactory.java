package amm.milestone3.classi;

import java.util.ArrayList;

/**
 *
 * @author ricca
 */
public class UserFactory {
    
    private static UserFactory singleton;
    //public  User[] users;

    public static UserFactory getInstance() {
        if (singleton == null) {
            singleton = new UserFactory();
        }
        return singleton;
    }

    public static Object getIstance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /* Costruttore */
    public UserFactory()
    {
    
    }
    ArrayList<User> userList = new ArrayList<>();

    //Restituisco tutti gli utenti
    public ArrayList<User> getUserList() {

        //ArrayList<User> userList = new ArrayList<>();
        //Utente 1 - Venditore
        User user1 = new SellerUser();
        user1.setName("Marco");
        user1.setSurname("Porcu");
        user1.setUsername("markp");
        user1.setPassword("pass0");
        user1.setId(0);
        user1.setAccountBalance(54.8);
        userList.add(user1);
        
        //Utente 2 - Venditore
        User user2 = new SellerUser();
        user2.setName("Federico");
        user2.setSurname("Caddeo");
        user2.setUsername("Caddish");
        user2.setPassword("pass1");
        user2.setId(1);
        user2.setAccountBalance(34.9);
        userList.add(user2);
        
        //Utente 3 - Venditore
        User user3 = new SellerUser();
        user3.setName("Giacomo");
        user3.setSurname("Balia");
        user3.setUsername("Jack");
        user3.setPassword("pass2");
        user3.setId(2);
        user3.setAccountBalance(76.1);
        userList.add(user3);
        
        //Utente 4 - Cliente
        User user4 = new CustomerUser();
        user4.setName("Riccardo");
        user4.setSurname("Benzoni");
        user4.setUsername("Horrorscopo");
        user4.setPassword("pass3");
        user4.setId(3);
        user4.setAccountBalance(106.6);
        userList.add(user4);
        
        //Utente 5 - Cliente
        User user5 = new CustomerUser();
        user5.setName("Fabrizio");
        user5.setSurname("Salis");
        user5.setUsername("Bixio71");
        user5.setPassword("pass4");
        user5.setId(4);
        user5.setAccountBalance(13.5);
        userList.add(user5);
        
        //Utente 6 - Cliente
        User user6 = new CustomerUser();
        user6.setName("Mauro");
        user6.setSurname("Zedda");
        user6.setUsername("MauZ");
        user6.setPassword("pass5");
        user6.setId(5);
        user6.setAccountBalance(78.0);
        userList.add(user6);
        
        if (userList!=null)
        {
            return userList;
        }
        else
            return null;
        
        /*PROVA SEMPLICE
        User user = new SellerUser();
        user.setName("Marco");
        user.setSurname("Porcu");
        user.setUsername("markp");
        user.setPassword("pass0");
        user.setID(1);
        user.setAccountBalance(5.6);
        
        ArrayList<User> userList = new ArrayList<>();
        
        userList.add(user);
        
        return userList;*/
    }
    public User getSeller(int id)
    {
        for(User u : userList)
        {
            if(u.id == id)
                return u;
        }
        
        return null;
    }
}
