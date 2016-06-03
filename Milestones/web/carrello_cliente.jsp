<%-- 
    Document   : carrello_cliente
    Created on : 2-mag-2016, 10.12.53
    Author     : Riccardo Balia 65106
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div id="content" class="formThreeCol">
    <h3>Conferma acquisto</h3>
    Dai un ultima revisione all'articolo che vuoi comprare e conferma
     <form method="post">
                    
        <table class="confermTable">
            <tr>
                <td><img src="${Goods.imageURL}" alt="Errore durante il caricamento" height="157" width="110"/></td>
                <td class="nome">${Goods.name}</td>
            </tr>
            <tr class="pari">
                <td class="headerRiga">Quantità:</td> 
                <td>${Goods.availability} disponibili</td>
            </tr>
            <tr class="dispari">
                <td class="headerRiga">Prezzo:</td>
                <td>${Goods.price} $</td>
            </tr>
            <tr class="pari">
                <td class="headerRiga">Descrizione:</td>
                <td>${Goods.description}</td>
            </tr>
        </table>
        <div class="buttonLogin">    
            <input type="hidden" name="objId" value="${Goods.ID}" />
            <input type="hidden" name="objPrice" value="${Goods.price}" />
            <input type="hidden" name="objAvailability" value="${Goods.availability}" />
            <input type="submit" name="BuyConferm" value="Conferma" class="button" />
        </div>
    </form>
</div> 
