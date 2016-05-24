package amm.milestone3.servlet;

import amm.milestone3.classi.ObjectSale;
import amm.milestone3.classi.User;
import amm.milestone3.classi.SellerUser;
import amm.milestone3.classi.CustomerUser;
import amm.milestone3.classi.ObjectFactory;
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
        
        HttpSession session = request.getSession(false);
        
        if(session==null || session.getAttribute("loggedIn") == null || session.getAttribute("loggedIn").equals(false) || session.getAttribute("loggedAsSeller") == null ||  !session.getAttribute("loggedAsSeller").equals(true))
        {
            request.setAttribute("messaggioValidazione", "Accesso Negato </br> Effettua il login come venditore");
        }
        else
        {
            if(session.getAttribute("loggedIn").equals(true))
            { 
                Integer sellerId = (Integer) (session.getAttribute("id"));
                request.setAttribute("objectLighter", ObjectFactory.getInstance().getObjectListByCategoryAndSellerID("lighters", sellerId)); 
                request.setAttribute("objectAccessories", ObjectFactory.getInstance().getObjectListByCategoryAndSellerID("accessories", sellerId));
                
                session.setAttribute("Seller", UserFactory.getInstance().getSellerByID((Integer) session.getAttribute("id")));
                
                //MODIFICA OGGETTO
                if(request.getParameter("SubmitEdit") != null)
                {
                    request.setAttribute("EditButton", true);
                    Integer EditObjectByID = Integer.parseInt(request.getParameter("objId"));
                    request.setAttribute("ModObj", ObjectFactory.getInstance().getObjectListByID(EditObjectByID));        
                }//Fine SubmitEdit!=null
                if(request.getParameter("EditConferm") != null)
                {
                    String name = request.getParameter("name");
                    String urlImage = request.getParameter("imageUrl");
                    String price = request.getParameter("price");
                    String availability = request.getParameter("availability");
                    String description = request.getParameter("description");
                    Integer ObjectID = Integer.parseInt(request.getParameter("objId"));
                    
                    request.setAttribute("ModObj", ObjectFactory.getInstance().getObjectListByID(ObjectID));  
                    request.setAttribute("EditConfermButtonMessage", "Il prodotto è stato modifcato con successo!"); 
                    
                        //INSERIMENTO CORRETTO
                        if(!"".equals(name) && !"".equals(urlImage) && !"".equals(price) && !"".equals(availability) && !"".equals(description))
                        {
                           request.setAttribute("EditConfermButton", true);
                           ObjectFactory.getInstance().editObject(ObjectID,name,urlImage,price,availability,description);
                        }
                        //INSERIMENTO ERRATO
                        if("".equals(name) || "".equals(urlImage) || "".equals(price) 
                                           || "".equals(availability) || "".equals(description))
                        {
                            request.setAttribute("EditButton", true);
                            request.setAttribute("messaggioErrore", "Tutti i campi sono obbligatori");
                        }
                }//Fine EditConferm!=null
                
                //ELIMINA OGGETTO
                if(request.getParameter("SubmitDelete") != null)
                {
                    request.setAttribute("DeleteButton", true);
                    Integer DeleteObjectByID = Integer.parseInt(request.getParameter("objId"));
                    request.setAttribute("DelObj", ObjectFactory.getInstance().getObjectListByID(DeleteObjectByID));
                }//Fine SubmitDelete!=null
                
                if(request.getParameter("DelConferm") != null)
                {
                    request.setAttribute("DeleteConfermButton", true);
                    Integer DeleteObjectByID = Integer.parseInt(request.getParameter("objId"));
                    request.setAttribute("DelObj", ObjectFactory.getInstance().getObjectListByID(DeleteObjectByID));
                    ObjectFactory.getInstance().deleteObject(DeleteObjectByID); 
                    request.setAttribute("DeleteConfermButtonMessage", "Il prodotto è stato eliminato con successo!");       
                }//Fine DelConferm != null
                
                //AGGIUNGI OGGETTO
                if(request.getParameter("SubmitAdd") != null)
                {
                    request.setAttribute("AddButton", true);
                }//Fine SubmitAdd!=null
                    
                    
                if(request.getParameter("SubmitSeller") != null)
                {
                    String name = request.getParameter("Name");
                    String urlImage = request.getParameter("UrlImmagine");
                    String prezzo = request.getParameter("Prezzo");
                    String quantita = request.getParameter("Quantita");
                    String categoria = request.getParameter("Categoria");
                    String descrizione = request.getParameter("Descrizione");

                    //INSERIMENTO CORRETTO
                    if(!"".equals(name) && !"".equals(urlImage) && !"".equals(prezzo) && !"".equals(quantita) && !"".equals(descrizione) && categoria!=null)
                    {

                        request.setAttribute("confirmedFlag", true);
                        request.setAttribute("messaggioConferma", "Nuova inserzione creata con successo");
                        
                        Integer sellerID = (Integer) (session.getAttribute("id"));
                        ObjectFactory.getInstance().addObject(name,urlImage,prezzo,quantita,descrizione,categoria,sellerID);

                        request.setAttribute("imageURL", urlImage);
                        request.setAttribute("name", name);
                        request.setAttribute("availability", quantita);
                        request.setAttribute("price", prezzo);
                        request.setAttribute("description", descrizione);
                        request.setAttribute("category", categoria);
                    }
                    
                    //INSERIMENTO ERRATO
                    if("".equals(name) || "".equals(urlImage) || "".equals(prezzo) || "".equals(quantita) || "".equals(descrizione)  || categoria==null)
                    {
                        request.setAttribute("AddButton", true);
                        request.setAttribute("messaggioErrore", "Tutti i campi sono obbligatori");
                    }
                }//Fine SubmitSeller!=null
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
