<%-- 
    Document   : venditore
    Created on : 20-mag-2016, 15.12.29
    Author     : ricca
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>LightersMania - Area Venditore</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Riccardo Balia">
        <meta name="keywords" content="Lighters,Accendini,LightersMania,Vendita">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    <body>
    <div id="page">
        <header id="pages">
        <h1 id="title">Area Venditore</h1>
            <nav id="navigation-top">
                <ul>
                    <li><a href="descrizione.html">Home</a></li>
                    <li><a href="login.html">Login</a></li>
                </ul>
            </nav>
        
        </header>        
        
        <nav id="sidebarLeft"  class="sidebar">
        <h3>Navigazione</h3>
        <ul>
            <li><a href="descrizione.html">Pagina principale</a></li>
            <li><a href="login.html">Area di Accesso</a></li>
        </ul>
        </nav>
                <div id="sidebarRight">   
        <c:if test="${(loggedIn eq true) && (loggedAsSeller eq true)}">
            <h3>Bentornato</h3> 
            ${Seller.name} ${Seller.surname}<br/>
            <p>ID: ${Seller.id}</p>
            <h4>Saldo:</h4>
            ${Seller.accountBalance} $
        </c:if>
        </div>
        
        
        
        <c:choose>
        <%-- Se l'utente è loggato può interagire con le pagine Venditore --%>
        <c:when test="${(loggedIn eq true) && (loggedAsSeller eq true)}">
            <c:choose>
            
                <%-- Se l'utente ha scelto di eliminare un elemento --%>
                <%@ include file="cancella_venditore.jsp" %> <%-- INCLUDE SEZIONE DI ELIMINAZIONE OGGETTO --%> 

                <%-- Se l'utente ha scelto di modificare un elemento --%>
                <%@ include file="modifica_venditore.jsp" %> <%-- INCLUDE SEZIONE DI MODIFICA OGGETTO --%> 
                
                <%-- Se l'utente ha scelto di creare un nuovo elemento --%>
                <%@ include file="crea_venditore.jsp" %> <%-- INCLUDE SEZIONE DI CREAZIONE OGGETTO --%> 

                <%-- Pagina principale venditore.html senza ancora nulla selezionato --%>
                <c:otherwise>
                <div id="content">
                    <form action="venditore.html" method="post" class="invisibleFormAdd">
                <input type="submit" name="SubmitAdd" value="Aggiungi una nuova inserzione" class="buttonAdd" />
                        </form>
                <h2>I tuoi Accendini</h2>
                <!-- Generazione dinamica delle tabelle accendini --> 
                <c:forEach var="objectLighter" items="${objectLighter}">
                    <table>
                        <tr>
                            <td><img src="${objectLighter.imageURL}" alt="Errore durante il caricamento" height="157" width="110"/></td>
                            <th class="nome">${objectLighter.name}</th>
                        </tr>
                        <tr class="pari">
                            <th>Quantità:</th> 
                            <td>${objectLighter.availability} disponibili</td>
                        </tr>
                        <tr class="dispari">
                            <th>Prezzo:</th>
                            <td>${objectLighter.price} $</td>
                        </tr>
                        <tr>

                            <td>
                                <form action="venditore.html" method="post" class="invisibleForm">
                                    <input type="hidden" name="objId" value="${objectLighter.ID}" /> 
                                    <input type="submit" name="SubmitDelete" value="Elimina" class="button , buttonModSeller" />
                                </form>
                            </td>
                            <td>
                                <form action="venditore.html" method="post" class="invisibleForm">
                                    <input type="hidden" name="objId" value="${objectLighter.ID}" />
                                    <input type="submit" name="SubmitEdit" value="Modifica" class="button , buttonModSeller" />
                                </form>
                            </td>
                        </tr>
                    </table>

                </c:forEach>
                <c:if test="${(empty objectLighter)}">
                    <p>Nessun oggetto in vendita</p>
                </c:if>

            <!-- Fine Generazione Dinamica -->

                <h2>I tuoi Accessori</h2>
                <!-- Generazione dinamica delle tabelle ricambi -->
                <c:forEach var="objectAccessories" items="${objectAccessories}">
                    <table>
                        <tr>
                            <td><img src=${objectAccessories.imageURL} alt="Errore durante il caricamento" height="157" width="110"/></td>
                            <th class="nome">${objectAccessories.name}</th>
                        </tr>
                        <tr class="pari">
                            <th>Quantità:</th> 
                            <td>${objectAccessories.availability} disponibili</td>
                        </tr>
                        <tr class="dispari">
                            <th>Prezzo:</th>
                            <td>${objectAccessories.price} $</td>
                        </tr>
                        <tr>

                            <td>
                                <form action="venditore.html" method="post" class="invisibleForm">
                                    <input type="hidden" name="objId" value="${objectAccessories.ID}" />
                                    <input type="submit" name="SubmitDelete" value="Elimina" class="button , buttonModSeller" />
                                </form>
                            </td>
                            <td>
                                <form action="venditore.html" method="post" class="invisibleForm">
                                    <input type="hidden" name="objId" value="${objectAccessories.ID}" />
                                    <input type="submit" name="SubmitEdit" value="Modifica" class="button , buttonModSeller" />
                                </form>
                            </td>
                        </tr>
                    </table>

                </c:forEach>
                <c:if test="${(empty objectAccessories)}">
                    <p>Nessun oggetto in vendita</p>
                </c:if>
                <!-- Fine Generazione Dinamica -->
            </div>
                </c:otherwise>
            </c:choose>
        </c:when>
        
        <%-- Se l'utente non è loggato mostra errore --%>
        <c:otherwise>
            <div id="content" class="form">  
                <h3>Compra</h3>
                <div class="confermForm">
                    <div class="errors errorVenditore">
                    ${messaggioValidazione}
                    </div>
                </div>
            </div>
        </c:otherwise>                   
        </c:choose>
        
    
    <footer></footer>         
    </div>     
    </body>
</html>