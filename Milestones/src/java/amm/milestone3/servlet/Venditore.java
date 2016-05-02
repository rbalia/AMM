package amm.milestone3.servlet;

import amm.milestone3.classi.ObjectSale;
import amm.milestone3.classi.User;
import amm.milestone3.classi.SellerUser;
import amm.milestone3.classi.CustomerUser;
import amm.milestone3.classi.UserFactory;

import java.io.IOException;
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
@WebServlet(name = "Venditore", urlPatterns = {"/venditore.html"})
public class Venditore extends HttpServlet {

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
        
            //double total = 44;
            //String total2 = String.valueOf(total);
        
        HttpSession session = request.getSession(false);
        
        /*User current = new SellerUser();
        current = (SellerUser) request.getAttribute("Venditore");
        if(request.getAttribute("Venditore") instanceof SellerUser){}*/
        
        if(session==null || session.getAttribute("loggedIn") == null || session.getAttribute("loggedIn").equals(false) || session.getAttribute("loggedAsSeller") == null ||  !session.getAttribute("loggedAsSeller").equals(true))
        {
            request.setAttribute("messaggioValidazione", "Accesso Negato </br> Effettua il login come venditore");
        }
        else
        {
            if(session.getAttribute("loggedIn").equals(true))
            { 
                session.getAttribute("Venditore");
                if(request.getParameter("SubmitSeller") != null)
                {
                    String name = request.getParameter("Name");
                    String urlImage = request.getParameter("UrlImmagine");
                    String prezzo = request.getParameter("Prezzo");
                    String quantita = request.getParameter("Quantita");
                    String descrizione = request.getParameter("Descrizione");


                    //INSERIMENTO CORRETTO
                    if(!"".equals(name) && !"".equals(urlImage) && !"".equals(prezzo) && !"".equals(quantita) && !"".equals(descrizione))
                    {

                       request.setAttribute("confirmedFlag", true);
                       request.setAttribute("messaggioConferma", "Nuova inserzione creata con successo");

                       request.setAttribute("imageURL", urlImage);
                       request.setAttribute("name", name);
                       request.setAttribute("availability", quantita);
                       request.setAttribute("price", prezzo);
                       request.setAttribute("description", descrizione);


                    }
                    //INSERIMENTO ERRATO
                    if("".equals(name) || "".equals(urlImage) || "".equals(prezzo) 
                                       || "".equals(quantita) || "".equals(descrizione))
                    {
                        request.setAttribute("confirmedFlag",  false);
                        request.setAttribute("messaggioErrore", "Tutti i campi sono obbligatori");
                    }
                }
            }
        }
        request.getRequestDispatcher("venditore.jsp").forward(request, response);
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
