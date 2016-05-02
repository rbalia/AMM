<%-- 
    Document   : venditore
    Created on : 19-apr-2016, 19.53.11
    Author     : Riccardo Balia 65106
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>LightersMania - Area Vendite</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Riccardo Balia">
        <meta name="keywords" content="Lighters,Accendini,LightersMania,Vendita">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    <body>
    <div id="page" class="formPage">
        <header id="pages">
        <h1 id="title">Area Vendite</h1>
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
        
        <div id="content" class="form">

        <h3>Vendi</h3>
        <c:choose>   
        <c:when test="${(loggedIn eq true) && loggedAsSeller eq true}">
            Inserisci le specifiche del prodotto che desideri vendere, ti contatteremo per confermare la tua richiesta.
        
            <c:choose>   
            <c:when test="${confirmedFlag eq true}">

                <div class="confermForm">
                <div class="correct">
                    ${messaggioConferma}
                </div>
                <table class="confermTable">
                <tr>
                    <td><img src="${imageURL}" alt="Errore durante il caricamento" height="157" width="110"/></td>
                    <th class="nome">${name}</th>
                </tr>
                <tr class="pari">
                    <th>Quantità:</th> 
                    <td>${availability} disponibili</td>
                    </tr>
                <tr class="dispari">
                    <th>Prezzo:</th>
                    <td>${price} $</td>
                    </tr>
                <tr class="pari">
                    <th>Descrizione:</th>
                    <td>${description}</td>
                </tr>
                </table>
                </div>
            </c:when>
            <c:otherwise>     
                <form action="venditore.html" method="post">
                    <div class="labelNome"><label for="name">Nome:</label></div>
                    <div class="inputNome"><input type="text" name="Name" id="name"/></div>
                    <div class="clearer"></div>

                    <div class="labelUrl"><label for="urlImmagine">URL foto:</label></div>
                    <div class="inputUrl"><input type="url" name="UrlImmagine" id="urlImmagine"/></div>
                    <div class="clearer"></div>

                    <div class="labelPrezzo"><label for="prezzo">Prezzo:</label></div>
                    <div class="inputPrezzo"><input type="number" name="Prezzo" id="prezzo" value="0.00"/></div>
                    <div class="clearer"></div>

                    <div class="labelDisponibilita"><label for="quantita">Disponibilit&aacute;:</label></div>
                    <div class="inputDisponibilita"><input type="number" name="Quantita" id="quantita"/></div>
                    <div class="clearer"></div>

                    <div class="labelDescrizione"><label for="descrizione">Descrizione:</label></div>
                    <div class="inputDescrizione"><textarea rows="3" cols="16" name="Descrizione" id="descrizione"></textarea></div>
                    <div class="clearer"></div>

                    <div class="errors errorVenditore">
                        ${messaggioErrore}
                    </div>



                    <div class="buttonVendita">
                        <input type="reset" value="Cancella tutto" class="button" />
                        <input type="submit" name="SubmitSeller" value="Crea inserzione" class="button" />
                    </div>

                </form>
            </c:otherwise>
            </c:choose>
        </c:when>
        <c:otherwise>
            <div class="confermForm">
            <div class="errors errorVenditore">
            ${messaggioValidazione}
            </div>
            </div>
        </c:otherwise>
        
        </c:choose>
        </div>  

        <footer></footer>
    </div>
    </body>
</html>

