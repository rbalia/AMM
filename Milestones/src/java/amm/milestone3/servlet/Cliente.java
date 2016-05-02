package amm.milestone3.servlet;

import amm.milestone3.classi.ObjectSale;
import amm.milestone3.classi.ObjectFactory;
import amm.milestone3.classi.User;
import amm.milestone3.classi.SellerUser;
import amm.milestone3.classi.CustomerUser;


import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;	

/**
 *
 * @author ricca
 */
@WebServlet(name = "Cliente", urlPatterns = {"/cliente.html"})
public class Cliente extends HttpServlet {

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
   
        HttpSession session = request.getSession(false);
        
        if(session==null || session.getAttribute("loggedIn") == null || session.getAttribute("loggedIn").equals(false) || session.getAttribute("loggedAsCustomer") == null ||  !session.getAttribute("loggedAsCustomer").equals(true) )
        {
            request.setAttribute("messaggioValidazione", "Accesso Negato <br/> Effettua il login come cliente");
        }
        else
        {
            request.setAttribute("objectLighter", ObjectFactory.getInstance().getObjectListByCategory("lighters")); 
            request.setAttribute("objectAccessories", ObjectFactory.getInstance().getObjectListByCategory("accessories")); 
            session.getAttribute("Customer");
            
            
            if(request.getParameter("idObjbyLink")!=null){
                Integer GoodsID = Integer.valueOf(request.getParameter("idObjbyLink"));
                request.setAttribute("idObject", GoodsID);
                request.setAttribute("Goods", ObjectFactory.getInstance().getObjectListByID(GoodsID));
            }
            if(request.getParameter("BuyConferm") != null)
            {
                request.setAttribute("BuyConfirmFlag", true);
                request.setAttribute("BuyConfermSuccess", "Congratulazioni! Hai completato il tuo acquisto");
                request.setAttribute("BuyConfermFail", "Ci dispiace, ma non hai abbastanza soldi per confermare il tuo acquisto");
            }
            else{
                request.setAttribute("BuyConfirmFlag", false);
                request.getAttribute("Goods");
            }
            
            
            
            //request.getAttribute("ObjectID");
            /*if(idObject!=null && Customer.accountBalance > Objects.price)
            {
            }
            else{
                if }*/
            
            }
      
      request.getRequestDispatcher("cliente.jsp").forward(request, response);
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
