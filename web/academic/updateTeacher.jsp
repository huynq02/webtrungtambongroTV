<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Teacher FPT</title>
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
                <form action="SaveTeacherServlet" method="POST">
                    <div class="card-body">
                        <h3 class="card-title">Profile</h3>
                    </div>
                    <div class="form-group">
                        <label>Name</label>
                        <input type="text" class="form-control input-student" value="${teacher.name}" name="name">
                    </div>
                    <div class="form-group">
                        <label>ID Card</label>
                        <input type="text" class="form-control input-student" value="${teacher.cardNo}" name="idCard">
                    </div>
                    <div class="form-group">
                        <label>Gender</label>
                        <div>
                            <input type="radio" name="gender" value="1" class="gender"<c:if test="${teacher.gender == true}">checked</c:if>> Male
                            <input type="radio" name="gender" value="0" class="gender"<c:if test="${teacher.gender == false}">checked</c:if>>Female
                            </div>
                        </div>
                        <div class="form-group">
                            <label>Address</label>
                            <input type="text" class="form-control input-student" value="${teacher.addr}" name="address">
                    </div>
                    <div class="form-group">
                        <label>Telephone</label>
                        <input type="text" class="form-control input-student" value="${teacher.phone}" name="telephone">
                    </div>
                    <div class="form-group">
                        <label>Email</label>
                        <input type="email" class="form-control input-student" value="${teacher.email}" name="email">
                    </div>
                    <div class="form-group">
                        <label>Class</label><br>
                        <c:forEach items="${ListClass}" var="ca">
                                <input type="checkbox" name="class" <c:forEach items="${ListByTea}" var="by">
                                           <c:if test="${by.name eq ca.name}">checked</c:if>
                                       </c:forEach> value="${ca.id}">${ca.name}<br>
                        </c:forEach>
                    </div>
                    <div class="form-group">
                        <label>Subject</label><br>
                        <c:forEach items="${ListSuject}" var="sb">
                                <input type="checkbox" name="sub" <c:forEach items="${ListSubByTe}" var="st">
                                           <c:if test="${st.name eq sb.name}">checked</c:if>
                                       </c:forEach> value="${sb.id}">${sb.name}<br>
                        </c:forEach>
                    </div>
                    
                    <input type="hidden" name="teacherId" value="${teacher.id}"/>
                    <button type="submit" class="btn btn-success botton-academic" >Save</button>
                </form>
            </div>
        </div>        
    </body>
</html>
