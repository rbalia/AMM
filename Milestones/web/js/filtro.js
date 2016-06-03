/*
    Author:  Riccardo Balia 65106
      Date:  28/05/2016
*/
/* Script per acquisizione del filtro e il popolamento in modo dinamico della pagina cliente*/


$(document).ready(function ()
{        
    $("#filter").keyup(function ()
    {
    //Prende il testo 
    var testo = $("#filter").val();
    
    $.ajax({
        url: "filter.json",
        data: { 
            command: "filtrate",
            filter: testo
        },
        dataType: 'json',
        
        success: function(data, state) {
            updateObject(data);
        },
        error: function (data, state) {
            $("#tabelleAccendini").empty();
            $("#tabelleAccessori").empty();
            $("#tabelleAccendini").append("Errore");
            $("#tabelleAccessori").append("Errore");
        }
        
    });

 
    //Funzione aggiornamento 
    function updateObject(filterResult)
    {
               // Cancella le liste precaricate
               $("#tabelleAccendini").empty();
               $("#tabelleAccessori").empty();
               
               //Restituisci gli oggetti passati dalla servlet
               for(var objectSale in filterResult)
               {


                //Creo le variabili per una nuova tabella
                var newTable = document.createElement("table");
                    //Nodo che condiene l'immagine e il nome
                    var trImmagineNome = document.createElement("tr");
                        var tdImage = document.createElement("td");
                           var image = document.createElement("img");
                           image.setAttribute("src", filterResult[objectSale].imageURL);
                           image.setAttribute("height", "157");
                           image.setAttribute("width", "110");
 
                        var tdName = document.createElement("td");
                        tdName.setAttribute("class", "nome");
                            var textNome = document.createTextNode(filterResult[objectSale].name);
 
 
                    //Nodo che contiene la quantità di prodotto disponibile        
                    var trQuantita = document.createElement("tr");
                    trQuantita.setAttribute("class","pari");
                        var tdQuantita = document.createElement("td");
                        tdQuantita.setAttribute("class","headerRiga");
                            var textQuantita = document.createTextNode("Quantità:");
 
                        var tdValoreQuantita = document.createElement("td");
                            var textValoreQuantita = document.createTextNode(filterResult[objectSale].availability + " disponibili");
 
                    //Nodo che contiene il prezzo        
                    var trPrezzo = document.createElement("tr");
                    trPrezzo.setAttribute("class","dispari");
                        var tdPrezzo = document.createElement("td");
                        tdPrezzo.setAttribute("class","headerRiga");
                            var textPrezzo = document.createTextNode("Prezzo:");
 
                        var tdValorePrezzo = document.createElement("td");
                            var textValorePrezzo = document.createTextNode(filterResult[objectSale].price + " $");
 
                    //Nodo che  contiene il link per l'acquisto
                    var trLink = document.createElement("tr");
                    trLink.setAttribute("class","pari");
                        var tdLink = document.createElement("td");
                        tdLink.setAttribute("class","headerRiga");
                            var textLink = document.createTextNode("Link:");
 
                        var tdValoreLink = document.createElement("td");
                            var aElement = document.createElement("a");
                            aElement.setAttribute("href","cliente.html?idObjbyLink="+ filterResult[objectSale].ID);
                                var textInA = document.createTextNode("Aggiungi al Carrello");
 
 
                    //Compongo le variabili per formare la struttura della tabella
                    tdImage.appendChild(image);
                    tdName.appendChild(textNome);
                        trImmagineNome.appendChild(tdImage);
                        trImmagineNome.appendChild(tdName);
                            newTable.appendChild(trImmagineNome);
 
                    tdQuantita.appendChild(textQuantita);
                    tdValoreQuantita.appendChild(textValoreQuantita);
                        trQuantita.appendChild(tdQuantita);
                        trQuantita.appendChild(tdValoreQuantita);
                            newTable.appendChild(trQuantita);
 
                    tdPrezzo.appendChild(textPrezzo);
                    tdValorePrezzo.appendChild(textValorePrezzo);
                        trPrezzo.appendChild(tdPrezzo);
                        trPrezzo.appendChild(tdValorePrezzo);
                            newTable.appendChild(trPrezzo);
 
                    tdLink.appendChild(textLink);
                        aElement.appendChild(textInA);
                    tdValoreLink.appendChild(aElement);
                        trLink.appendChild(tdLink);
                        trLink.appendChild(tdValoreLink);
                            newTable.appendChild(trLink);
                            
                    //Nel caso di nessuna corrispondenza in ricerche precedenti resetto lo spazio di notifica
                    $("#nessunAccendino").empty();
                    $("#nessunAccessorio").empty();
                    // Aggiungo la tabella alla pagine
                    if(filterResult[objectSale].category === "lighters")
                        $("#tabelleAccendini").append(newTable);
                        $("#tabelleAccendini").append(" "); 
                    if(filterResult[objectSale].category === "accessories")
                        $("#tabelleAccessori").append(newTable);
                        $("#tabelleAccessori").append(" "); 
                }//Fine for
                    
                if(!$.trim($("#tabelleAccendini").html()))
                {       
                    $("#nessunAccendino").empty();
                    $("#nessunAccendino").append("Nessuna corrispondenza");       
                }
                if(!$.trim($("#tabelleAccessori").html()))
                {
                    $("#nessunAccessorio").empty();
                    $("#nessunAccessorio").append("Nessuna corrispondenza");
                }
    }//Fine funzione di aggiornamento

    });
});

