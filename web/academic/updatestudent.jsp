<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Student FPT</title>
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
            <div class="container-form">
                <h1>Update Information Student</h1>
                <hr>
                <form action="SaveStudentServlet" method="POST">
                    <img class="card-img-top" style="width: 200px;" src="${image.url}"
                         alt="Card image cap">
                    <div class="card-body">
                        <h3 class="card-title">Profile</h3>
                    </div>
                    <div class="form-group">
                        <label>First Name</label>
                        <input type="text" class="form-control input-student" value="${student.firstName}" name="firstname">
                    </div>
                    <div class="form-group">
                        <label>Last Name</label>
                        <input type="text" class="form-control input-student" value="${student.lastName}" name="lastname">
                    </div>
                    <div class="form-group">
                        <label>ID Card</label>
                        <input type="text" class="form-control input-student" value="${student.cardNo}" name="idCard">
                    </div>
                    <div class="form-group">
                        <label>Date Of Birth</label>
                        <input type="date" class="form-control input-student" value="${student.DOB}" name="dob">
                    </div>
                    <div class="form-group">
                        <label>Gender</label>
                        <div>
                            <input type="radio" name="gender" value="1" class="gender"<c:if test="${student.gender == true}">checked</c:if>> Male
                            <input type="radio" name="gender" value="0" class="gender"<c:if test="${student.gender == false}">checked</c:if>>Female
                            </div>
                        </div>
                        <div class="form-group">
                            <label>Address</label>
                            <input type="text" class="form-control input-student" value="${student.address}" name="address">
                    </div>
                    <div class="form-group">
                        <label>Telephone</label>
                        <input type="text" class="form-control input-student" value="${student.telephone}" name="telephone">
                    </div>
                    <div class="form-group">
                        <label>Email</label>
                        <input type="email" class="form-control input-student" value="${student.email}" name="email">
                    </div>
                    <br>
                    <h3>Parent</h3><hr>
                    <div class="form-group">
                        <label>Name</label>
                        <input type="text" class="form-control input-student" value="${parent.pname}" name="parentname">
                    </div>
                    <div class="form-group">
                        <label>Phone number</label>
                        <input type="text" class="form-control input-student" value="${parent.phone}" name="parentphone" >
                    </div>
                    <div class="form-group">
                        <label>Address</label>
                        <input type="text" class="form-control input-student"  value="${parent.add}" name="paddress" >
                    </div>
                    <div class="form-group">
                        <label>Email</label>
                        <input type="text" class="form-control input-student" value="${parent.email}" name="parentmail" >
                    </div>
                    <div class="form-group">
                        <label>Job</label>
                        <input type="text" class="form-control input-student" value="${parent.job}" name="parentjob" >
                    </div>
                    <div class="form-group">
                        <label>Place of Work</label>
                        <input type="text" class="form-control input-student" value="${parent.placeWork}" name="pow" >
                    </div>
                    <input type="hidden" name="studentId" value="${student.id}"/>
                    <button type="submit" class="btn btn-success botton-academic" >Save</button>
                </form>
            </div>
        </div>        
    </body>
</html>
