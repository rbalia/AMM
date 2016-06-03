package amm.milestone3.servlet;

import amm.milestone3.classi.User;
import amm.milestone3.classi.SellerUser;
import amm.milestone3.classi.CustomerUser;
import amm.milestone3.classi.ObjectFactory;
import amm.milestone3.classi.ObjectSale;
import amm.milestone3.classi.UserFactory;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Riccardo Balia 65106
 */
@WebServlet(name = "Login", urlPatterns = {"/login.html"}, loadOnStartup = 0)
public class Login extends HttpServlet {
    
    private static final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String DB_CLEAN_PATH = "../../web/WEB-INF/db/ammdb";
    private static final String DB_BUILD_PATH = "WEB-INF/db/ammdb";
    
    @Override 
    public void init(){
        String dbConnection = "jdbc:derby:" + this.getServletContext().getRealPath("/") + DB_CLEAN_PATH;
        //String dbConnection = "jdbc:derby://localhost:1527/ammdb";

        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObjectFactory.getInstance().setConnectionString(dbConnection);
        UserFactory.getInstance().setConnectionString(dbConnection);
    }
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
   
        //CREAZIONE SESSIONE
        HttpSession session = request.getSession(true); 
        
        //Se non sono loggato:
        if(session==null || session.getAttribute("loggedIn") == null || session.getAttribute("loggedIn").equals(false))
        {
            //LOGIN
            if(request.getParameter("Submit") != null)
            {
                // Preleva i dati inviati - si basa sul name in HTML
                String username = request.getParameter("Username");
                String password = request.getParameter("Password");


                //ArrayList<User> userList = UserFactory.getInstance().getUserList();
                User u  = UserFactory.getInstance().getUser(username,password);
                
                    //LOGIN CORRETTO
                    if(u!=null)
                    {
                        //Utente autenticato
                        session.setAttribute("loggedIn", true);
                        session.setAttribute("id", u.getId());

                        if(u instanceof SellerUser) 
                        {
                            //Passo i dati alla pagina di welcome per il venditore
                            Integer sellerId = (Integer) (session.getAttribute("id"));
                            request.setAttribute("objectLighter", ObjectFactory.getInstance().getObjectListByCategoryAndSellerID("lighters", sellerId)); 
                            request.setAttribute("objectAccessories", ObjectFactory.getInstance().getObjectListByCategoryAndSellerID("accessories", sellerId));
                                
                            session.setAttribute("Seller", u);
                            session.setAttribute("loggedAsSeller", true);
                            request.getRequestDispatcher("venditore.jsp").forward(request, response);
                        }
                        else
                            if(u instanceof CustomerUser)
                            {
                                //Passo i dati per la visualizzazione degli oggetti in vendita (Il primo passaggio da login a cliente non li visualizza) 
                                request.setAttribute("objectLighter", ObjectFactory.getInstance().getObjectListByCategory("lighters")); 
                                request.setAttribute("objectAccessories", ObjectFactory.getInstance().getObjectListByCategory("accessories")); 
                                
                                session.setAttribute("Customer", u);
                                session.setAttribute("loggedAsCustomer", true);
                                request.getRequestDispatcher("cliente.jsp").forward(request, response);  
                            }                 
                    }
                    //UTENTE NON TROVATO
                    if(u==null) 
                        request.setAttribute("messaggio", "Credenziali non valide");

                    //NESSUN INPUT
                     if("".equals(username) && "".equals(password)) 
                        request.setAttribute("messaggio", "Inserire delle credenziali");
            }
        }
        //Se sono loggato:
        else
        { 
            request.setAttribute("messaggioLogin", "Hai già effetuato il login!</br>Vuoi uscire?");
            
            //LOGOUT
            if(request.getParameter("SubmitLogout") != null)
            {
            session.setAttribute("loggedIn", false);
            session.invalidate();
            }
        }
        request.getRequestDispatcher("login.jsp").forward(request, response);
        
    }
    


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
