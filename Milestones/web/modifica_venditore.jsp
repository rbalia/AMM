<%-- 
    Document   : modifica_venditore
    Created on : 21-mag-2016, 15.53.42
    Author     : Riccardo Balia 65106
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:when test="${(EditConfermButton eq true)}">
    <div id="content" class="formThreeColSeller">
        <h3>Modifica confermata</h3>
        <div class="confermForm">
            <div class="correct">
                ${EditConfermButtonMessage}<br/>
                Prodotto modificato: ${ModObj.name}<br/>
                <p><a href="venditore.html">Torna all'area venditori</a></p>
            </div>
            
        </div>
    </div>
</c:when>
<c:when test="${(EditButton eq true)}">
    <div id="content" class="formThreeColSeller">
        <h2>Modifica prodotto</h2>
        <form action="venditore.html" method="post">
            <div class="errors">    
                <p>${messaggioErrore}</p>
            </div>
            <div class="askConferm"> 
                <table class="confermTable">
                    <tr>
                        <td class="headerRiga">Immagine:</td>
                        <td class="headerRiga">Nome:</td>

                    </tr>
                    <tr>
                        <td><input type="url" name="imageUrl" id="username" value="${ModObj.imageURL}"/></td>
                        <td><input type="text" name="name" id="username" value="${ModObj.name}"</td>
                    </tr>
                    <tr class="pari">
                        <td class="headerRiga">Quantità:</td> 
                        <td><input type="number" name="availability" min="1" id="username" value="${ModObj.availability}"/></td>
                    </tr>
                    <tr class="dispari">
                        <td class="headerRiga">Prezzo:</td>
                        <td><input type="number" name="price" min="0" step="any" id="username" value="${ModObj.price}" /></td>
                    </tr>
                    <tr class="pari">
                        <td class="headerRiga">Descrizione:</td>
                        <td><textarea rows="6" cols="16" name="description" id="descrizione" class="modificaOggetto">${ModObj.description}</textarea></td>
                    </tr>
                </table>
                   
                <p>Confermare le modifiche al prodotto?</p>
                <input type="hidden" name="objId" value="${ModObj.ID}" />
                <input type="submit" name="EditConferm" value="Conferma" class="button" />
            </div>
        </form>
    </div>     
</c:when>

