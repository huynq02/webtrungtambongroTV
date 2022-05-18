<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Admin</title>
        <link href="../myStyle.css" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
              crossorigin="anonymous">
        <link rel="shortcut icon" href="../favicon.ico"/>
        <style>
            body{
                background-image: url(../images/HCM-scaled.jpeg);
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="container-login">
                <h4 class="error">${error}</h4>
<!--                <img src="../images/logo.jpg" alt="logo"/>-->
                <h1>Update Admin</h1>
                <form action="UpdateAdminServlet" method="POST">
                    <div class="form-group">
                        <label>Username</label>
                        <input type="text" class="form-control" name="username" value="${academic.username}">
                    </div>
                    <div class="form-group">
                        <label>Email</label>
                        <input type="text" class="form-control"  name="email" value="${academic.email}">
                    </div>
                    <div class="form-group">
                        <label>PassWord</label>
                        <input type="password" class="form-control" name="pass" value="${academic.pass}">
                    </div>
                    <div class="form-group">
                        <label>Confirm PassWord</label>
                        <input type="password" class="form-control" name="pass1" value="${academic.pass}">
                    </div>
                    <div class="form-group">
                        <label>Capcha Code: ${Capcha}</label>
                        <input type="hidden" name="capcha" value="${Capcha}"> 
                    </div>
                    <div class="form-group">
                        <label>Enter Capcha:</label>
                        <input type="text" class="form-control" name="cap">
                    </div>
                    <input type="hidden" name="id" value="${academic.id}">
                    <button type="submit" class="btn btn-primary">Save</button>
                </form>
            </div>
        </div>
    </body>
</html>
