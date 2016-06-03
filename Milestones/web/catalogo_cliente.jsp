<%-- 
    Document   : catalogo_cliente
    Created on : 2-mag-2016, 10.25.52
    Author     : Riccardo Balia 65106
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="content" class="catalogo">

    <h2>Accendini</h2>
    <p>Se ciò che cerchi è un accendino, sei nella sezione ideale, e troverai sicuramente ciò
    che stai cercando! Scegli con cura l'accendino che ti accompagnerà negli anni o quello
    che più si intona alla tua collezione personale</p>

    <!-- Generazione dinamica delle tabelle accendini --> 
    <div id="tabelleAccendini">
    <c:forEach var="objectLighter" items="${objectLighter}">
        <table>
            <tr>
                <td><img src="${objectLighter.imageURL}" alt="Errore durante il caricamento" height="157" width="110"/></td>
                <td class="nome">${objectLighter.name}</td>
            </tr>
            <tr class="pari">
                <td class="headerRiga">Quantità:</td> 
                <td>${objectLighter.availability} disponibili</td>
            </tr>
            <tr class="dispari">
                <td class="headerRiga">Prezzo:</td>
                <td>${objectLighter.price} $</td>
            </tr>
            <tr class="pari">
               <td class="headerRiga">Link:</td> 
               <td><a href="cliente.html?idObjbyLink=${objectLighter.ID}">Aggiungi al Carrello</a></td>
            </tr>
        </table>
    </c:forEach>
    </div>
    <p id="nessunAccendino" class="nessunaCorrispondenza"></p>
        <!-- Fine Generazione Dinamica -->

    <h2>Ricambi, Ricariche e Accessori</h2>
    <p>Vi offriamo solo il meglio, una vasta scelta di tutto ciò che può servire ai vostri accendini
    e accessori originali per la casa o l'outdoor coperti dalla garanzia LightersMania!</p>

    <!-- Generazione dinamica delle tabelle ricambi -->
    <div id="tabelleAccessori">
    <c:forEach var="objectAccessories" items="${objectAccessories}">
        
        <table>
            <tr>
                <td><img src="${objectAccessories.imageURL}" alt="Errore durante il caricamento" height="157" width="110"/></td>
                <td class="nome">${objectAccessories.name}</td>
            </tr>
            <tr class="pari">
                <td class="headerRiga">Quantità:</td> 
                <td>${objectAccessories.availability} disponibili</td>
            </tr>
            <tr class="dispari">
                <td class="headerRiga">Prezzo:</td>
                <td>${objectAccessories.price} $</td>
            </tr>
            <tr class="pari">
                <td class="headerRiga">Link:</td> 
                <td><a href="cliente.html?idObjbyLink=${objectAccessories.ID}">Aggiungi al Carrello</a></td>
            </tr>
        </table>

    </c:forEach>
    </div>
    <p id="nessunAccessorio" class="nessunaCorrispondenza"></p>
    <!-- Fine Generazione Dinamica -->
</div>
                