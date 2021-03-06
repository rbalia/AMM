<%-- 
    Document   : crea_venditore
    Created on : 21-mag-2016, 18.22.57
    Author     : Riccardo Balia 65106
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


            <c:when test="${confirmedFlag eq true}">
            <div id="content" class="form">
                <h3>Vendi</h3>
                <div class="confermForm">
                <div class="correct">
                    ${messaggioConferma}
                </div>
                <div class="confermTable">
                <table class="confermTable">
                <tr>
                    <td><img src="${imageURL}" alt="Errore durante il caricamento" height="157" width="110"/></td>
                    <td class="nome">${name}</td>
                </tr>
                <tr class="pari">
                    <td class="headerRiga">Quantità:</td> 
                    <td>${availability} disponibili</td>
                    </tr>
                <tr class="dispari">
                    <td class="headerRiga">Prezzo:</td>
                    <td>${price} $</td>
                    </tr>
                <tr class="pari">
                    <td class="headerRiga">Categoria:</td>
                    <td>${category}</td>
                    </tr>
                <tr class="dispari">
                    <td class="headerRiga">Descrizione:</td>
                    <td>${description}</td>
                </tr>
                </table>
                </div>
                    <div class="correct">
                    <p><a href="venditore.html">Torna all'area venditori</a></p>
                    </div>
                </div>
            </div>
            </c:when>
            <%--Se l'utente non è loggato--%>
            <c:when test="${AddButton eq true}">     
            <div id="content" class="form">
                <h3>Vendi</h3>
                Inserisci le specifiche del prodotto che desideri vendere, ti contatteremo per confermare la tua richiesta.
                <form action="venditore.html" method="post">
                    <div class="labelSeller"><label for="name">Nome:</label></div>
                    <div class="inputSeller"><input type="text" name="Name" id="name"/></div>
                    <div class="clearer"></div>

                    <div class="labelSeller"><label for="urlImmagine">URL foto:</label></div>
                    <div class="inputSeller"><input type="url" name="UrlImmagine" id="urlImmagine"/></div>
                    <div class="clearer"></div>

                    <div class="labelSeller"><label for="prezzo">Prezzo:</label></div>
                    <div class="inputSeller"><input type="number" name="Prezzo" min="0" step="any" id="prezzo" value="0.00"/></div>
                    <div class="clearer"></div>

                    <div class="labelSeller"><label for="quantita">Disponibilit&aacute;:</label></div>
                    <div class="inputSeller"><input type="number" min="1" name="Quantita" id="quantita"/></div>
                    <div class="clearer"></div>
                    
                    <div class="labelSeller"><label for="accendino">Categoria:</label></div>
                    <div class="inputSeller"><input type="radio" name="Categoria" id="accendino" value="lighters">Accendino</div>
                    <div class="labelCategoriaHidden"><label for="accessorio">Categoria:</label></div>
                    <div class="inputSeller"><input type="radio" name="Categoria" id="accessorio" value="accessories">Accessorio</div>
                    <div class="clearer"></div>
                    
                    <div class="labelDescrizione"><label for="descrizione">Descrizione:</label></div>
                    <div class="inputSeller"><textarea rows="3" cols="16" name="Descrizione" id="descrizione"></textarea></div>
                    <div class="clearer"></div>

                    
                    <div class="errors errorVenditore">
                        ${messaggioErrore}
                    </div>



                    <div class="buttonVendita">
                        <input type="reset" value="Cancella tutto" class="button" />
                        <input type="submit" name="SubmitSeller" value="Crea inserzione" class="button" />
                    </div>

                </form>
            </div>
        </c:when>



