<%-- 
    Document   : login
    Created on : 19-apr-2016, 19.33.33
    Author     : Riccardo Balia 65106
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>LightersMania - Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Riccardo Balia">
        <meta name="keywords" content="login,LightersMania">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    <body>
    <div id="page" class="formPage">
        <header id="pages">
        <h1 id="title">Login</h1>
                    
        <nav id="navigation-top">
                    <ul>
                        <li><a href="descrizione.html">Home</a></li>
                        <li><a href="cliente.html">Compra</a></li>
                        <li><a href="venditore.html">Vendi</a></li>
                    </ul>
        </nav>
        </header>      
        
        <nav id="sidebarLeft"  class="sidebar">
        <h3>Navigazione</h3>
        <ul>
            <li><a href="descrizione.html">Pagina principale</a></li>
            <li><a href="cliente.html">Area Clienti</a></li>
            <li><a href="venditore.html">Area Venditori</a></li>
        </ul>
        </nav>
        
        <div id="content" class="form">
        <h3>Accedi</h3>
        <form action="login.html" method="post">
            
            <c:choose>   
            <c:when test="${loggedIn eq true}">
                <div class="correct">
                    ${messaggioLogin}
                </div>
                <div class="buttonLogin">
                    <input type="submit" name="SubmitLogout" value="Logout" class="button"/>
                </div>
            </c:when>
            <c:otherwise>
                <div class="labelUsername">
                    <label for="username">Username</label>
                </div>
                <div class="inputUsername">
                    <input type="text" name="Username" id="username"/><br/>
                </div>
                <div class="clearer"></div>
                <div class="labelPassword">
                    <label for="password">Password</label>
                </div>
                <div class="inputPassword">
                    <input type="password" name="Password" id="password"/><br/>
                </div>
                <div class="clearer"></div>

                <div class="errors errorLogin">
                        ${messaggio}
                </div>

                <div class="buttonLogin">
                    <input type="submit" name="Submit" value="Login" class="button"/>
                </div>

        </c:otherwise>
        </c:choose>
        
        </form>
        
        </div>    
        <footer></footer>
    </div>
    </body>
</html>

