<%-- 
    Document   : cliente
    Created on : 19-apr-2016, 19.52.41
    Author     : Riccardo Balia 65106
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>LightersMania - Catalogo</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Riccardo Balia">
        <meta name="keywords" content="Lighters,Accendini,LightersMania,Catalogo">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    <body>
    <div id="page">
        <header id="pages">                        
            <h1 id="title">Catalogo Online</h1>
        
        <nav id="navigation-top">
            <ul>
                <li><a href="descrizione.html">Home</a></li>
                <li><a href="login.html">Login</a></li>
            </ul>
        </nav>
        </header>

        <nav id="sidebarLeft" class="sidebar">

        <h3>Navigazione</h3>
        <ul>
            
            <li><a href="descrizione.html">Pagina principale</a></li>
            <li><a href="login.html">Area di Accesso</a></li>
        </ul>
        </nav>
        
        <div id="sidebarRight"> 
        <%-- Se l'utente è loggato mostra dati utente --%>
        <c:if test="${(loggedIn eq true) && (loggedAsCustomer eq true)}">
            <h3>Bentornato!</h3> 
            ${Customer.name} ${Customer.surname}<br/>
            <p>ID: ${Customer.id}</p>
            <h4>Saldo:</h4>
            ${Customer.accountBalance} $
        </c:if>
        </div>
        
        
        <c:choose>
        <%-- Se l'utente è loggato può interagire con le pagine Cliente --%>
        <c:when test="${(loggedIn eq true) && (loggedAsCustomer eq true)}">
            <c:choose> 
            <%-- Se l'utente ha aggiunto qualcosa al carrello, mostra carrello --%>
            <c:when test="${(idObject!=null) && (BuyConfirmFlag eq false)}">
                <%@ include file="carrello_cliente.jsp" %> <%-- INCLUDE CARRELLO --%> 
            </c:when>
            
            <%-- Se l'utente conferma l'acquisto e ha soldi mostra conferma --%>
            <c:when test="${((idObject!=null)) && (BuyConfirmFlag eq true) && (Customer.accountBalance gt Goods.price) }">
                <div id="content" class="form">
                <h3>Conferma acquisto</h3>
                <div class="confermForm">
                <div class="correct">
                ${BuyConfermSuccess}<br/>
                Prodotto acquistato: ${Goods.name}
                
                <p><a href="cliente.html">Torna all'area clienti</a></p>
                    
                </div>
                </div>
                </div>
            </c:when>
            
            <%-- Se l'utente è loggato ma non ha soldi a sufficienza mostra errore --%>
            <c:when test="${((idObject!=null)) && (BuyConfirmFlag eq true) && (Customer.accountBalance lt Goods.price)}">
                <div id="content" class="form">
                <h3>Conferma acquisto</h3>
                <div class="confermForm">
                <div class="errors">
                ${BuyConfermFail}
                
                <p><a href="cliente.html">Torna all'area clienti</a></p>
                </div>
                </div>
                </div>
            </c:when>
            
            <%-- Pagina principale cliente.html senza ancora nulla selezionato --%>
            <c:when test="${idObject==null}">
              <%@ include file="catalogo_cliente.jsp" %> <%-- INCLUDE CATOLOGO --%> 
            </c:when>
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
