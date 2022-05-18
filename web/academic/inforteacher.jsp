<%-- 
    Document   : InforAdmin
    Created on : Mar 14, 2022, 12:11:41 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Information Teacher</title>
        <link href="../myStyle.css" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
              crossorigin="anonymous">
        <link rel="shortcut icon" href="../favicon.ico"/>
    </head>
    <body>
        <div class="container">
            <div class="container-form">
                <h1>Teacher Information </h1>
                <hr>
                <!--<form action="UpdateStudentServlet" method="Post">-->
                <div class="card" style="width: 100%;">
                    <div class="card-body">
                        <h4 class="card-title">Profile</h4>
                    </div>
                    <ul class="list-group list-group-flush"> 

                        <input type="hidden" name="id" value="${teacher.id}">
                        <li class="list-group-item">Fullname: ${teacher.name}</li>
                        <li class="list-group-item">Gender: 
                            <c:if test="${teacher.gender == true}">Male</c:if>
                            <c:if test="${teacher.gender == false}">Female</c:if>
                            </li>
                            <li class="list-group-item">ID Card: ${teacher.cardNo}</li>
                        <li class="list-group-item">Phone: ${teacher.phone}</li>
                        <li class="list-group-item">Address: ${teacher.addr}</li>
                        <li class="list-group-item">Email: ${teacher.email}</li>
                        <li class="list-group-item"> Class:<br>
                            <c:forEach items="${ListClass}" var="ca">
                                <input type="checkbox" name="class" <c:forEach items="${ListByTea}" var="by">
                                           <c:if test="${by.name eq ca.name}">checked</c:if>
                                       </c:forEach>>${ca.name}<br>
                            </c:forEach>
                        </li>
                        <li class="list-group-item"> Subject:<br>
                            <c:forEach items="${ListSuject}" var="sb">
                                <input type="checkbox" name="class" <c:forEach items="${ListSubByTe}" var="st">
                                           <c:if test="${st.name eq sb.name}">checked</c:if>
                                       </c:forEach>>${sb.name}<br>
                            </c:forEach>
                        </li>
                    </ul>
                    <form action="UpdateTeacherServlet" method="Post">
                        <input type="hidden" value="${teacher.id}" name="teacherId" />
                        <button type="submit" class="btn btn-success botton-academic">Update</button>
                    </form>
                </div>   
            </div>
        </div>
    </body>
</html>
