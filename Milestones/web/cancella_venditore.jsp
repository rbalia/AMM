<%-- 
    Document   : cancella_venditore
    Created on : 20-mag-2016, 17.54.54
    Author     : Riccardo Balia 65106
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:when test="${(DeleteConfermButton eq true)}">
    <div id="content" class="formThreeCol">
        <h3>Conferma acquisto</h3>
        <div class="confermForm">
            <div class="correct">
                ${DeleteConfermButtonMessage}<br/>
                Prodotto eliminato: ${DelObj.name}<br/>
                <p><a href="venditore.html">Torna all'area venditori</a></p>
            </div>
            
        </div>
    </div>
</c:when>
<c:when test="${(DeleteButton eq true)}">
    <div id="content" class="formThreeCol">
        <h2>Conferma cancellazione</h2>
        <form action="venditore.html" method="post">

            <table class="confermTable">
                <tr>
                    <td><img src="${DelObj.imageURL}" alt="Errore durante il caricamento" height="157" width="110"/></td>
                    <td class="nome">${DelObj.name}</td>
                </tr>
                <tr class="pari">
                    <td class="headerRiga">Quantità:</td> 
                    <td>${DelObj.availability} disponibili</td>
                </tr>
                <tr class="dispari">
                    <td class="headerRiga">Prezzo:</td>
                    <td>${DelObj.price} $</td>
                </tr>
                <tr class="pari">
                    <td class="headerRiga">Descrizione:</td>
                    <td>${DelObj.description}</td>
                </tr>
            </table>
            <div class="askConferm">        
                Sei sicuro di voler eliminare il prodotto dal negozio?<br/> 
                <input type="hidden" name="objId" value="${DelObj.ID}" />
                <input type="submit" name="DelConferm" value="Conferma" class="button" />
            </div>
        </form>
    </div>     
</c:when>
