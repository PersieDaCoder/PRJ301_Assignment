<%-- 
    Document   : index
    Created on : Jan 31, 2023, 11:01:37 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="styleLogin.css">
    </head>
    <body>
        <div class="Box">
        <div class="leftBox">
            <img id="logo" src="./img/logo.png" alt="">
            <div class="title">
                <h2>Hãy mua cây như mua cần</h2>    
            </div>
        </div>
        <div class="rightBox">
            <form class="logIn" action="LogInServlet" method="POST">
                <h1>LOG IN</h1>
                <input type="text" name="txtAccount" placeholder="    Input Account">
                <input type="password" name="txtPassword" placeholder="    Input Password">
                <!--<input type="submit">-->
                <input type="submit" value="Log In" name="Submit" />
                <h4>You don't have account</h4>
                <a href="registerPage.html">Click to Register</a>
            </form>
        </div>
    </div>
    </body>
</html>
