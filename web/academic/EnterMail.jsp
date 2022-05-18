<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Register</title>
        <link href="../myStyle.css" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
              crossorigin="anonymous">
        <link rel="shortcut icon" href="../favicon.ico"/>
        <style>
            body{
                background-image: url(../images/36.jpg);
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="container-login">
                <h4 class="error">${error}</h4>
                <img src="../images/logo.jpg" alt="logo"/>
                <h1>Enter your email</h1>
                <form action="UpdatePassServlet" method="POST">
<!--                    <div class="form-group">
                        <label>Username</label>
                        <input type="text" class="form-control" placeholder="Enter username" name="username">
                    </div>-->
                    <div class="form-group">
                        <label>Email</label>
                        <input type="text" class="form-control" placeholder="Email" name="email">
                    </div>
                    <div class="form-group">
                        <label>Capcha: ${Capcha}</label>
                        <input type="hidden" name="cap" value="${Capcha}">
                        <input type="text" class="form-control" placeholder="Capcha" name="capcha">
                    </div>
                    <button type="submit" class="btn btn-primary">Send</button>
                </form>
            </div>
        </div>
    </body>
</html>
