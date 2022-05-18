<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Student FPT</title>
        <link href="../myStyle.css" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
              crossorigin="anonymous">
        <link rel="shortcut icon" href="../favicon.ico"/>
        
        <style>
            body{
                background-image: url(../images/HCM-scaled.jpeg);
            }
            .button {
                line-height: 24px;
            }
            .button--orange {
                border-color: #f05123;
                color: #f05123;
            }
            .botto--outline {
                border: 1px solid rgba(255,255,255,0.8);
                background: transparent;
            }
            li a, .dropbtn {
                display: inline-block;
                color: white;
                text-align: center;
                padding: 14px 16px;
                text-decoration: none;
            }
            li a:hover, .dropdown:hover .dropbtn {
                background-color: #F05123;
                color: white;
                font-weight: bold;
            }
            li.dropdown {
                display: inline-block;
            }

            .dropdown-content {
                display: none;
                position: absolute;
                background-color: #F05123;
                min-width: 160px;
                box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
                z-index: 1;
            }

            .dropdown-content a {
                color: black;
                padding: 12px 16px;
                text-decoration: none;
                display: block;
                text-align: left;
            }

            .dropdown-content a:hover {
                background-color: #F05123;
                color: white;
            }

            .dropdown:hover .dropdown-content {
                display: block;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="container-form">
                <h1>List Student FPT </h1>
                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link" href="ShowListStudentRegisterServlet">Student Register</a>
                            </li>
                            <li class="nav-item dropdown" >
                                <a class="nav-link active" href="ShowListStudentFPTServlet?Spec=-1" class="dropbtn">Student FPT</a>
                                <div class="dropdown-content">
                                    <a href="ShowListStudentFPTServlet?Spec=1">Kỹ Thuật Phần Mềm</a>
                                    <a href="ShowListStudentFPTServlet?Spec=2">An Toàn Thông Tin</a>
                                    <a href="ShowListStudentFPTServlet?Spec=3">Quản Trị Kinh Doanh</a>
                                </div>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link" href="ClassTimeTableServlet?Spec=-1" class="dropbtn">Class Timetable</a>
                                <div class="dropdown-content">
                                    <a href="ClassTimeTableServlet?Spec=1">Kỹ Thuật Phần Mềm</a>
                                    <a href="ClassTimeTableServlet?Spec=2">An Toàn Thông Tin</a>
                                    <a href="ClassTimeTableServlet?Spec=3">Quản Trị Kinh Doanh</a>
                                </div>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="MoveOutClassServlet">Class</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="ReviewWebServlet">Review</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="InforTeacherServlet">Teacher</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="InsertNewsServlet">News</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="InforAdminServlet">Admin</a>
                            </li>
                        </ul>
                    </div>
                </nav>
                <hr>
                <form class="navbar-form navbar-right">
                            <div class="form-group">
                                <input type="text" name="seName" value="${seName}" class="form-control" placeholder="Search">
                                <select name="chuyen">
                                    <option value="-1">-------------All-------------</option>
                                    <c:forEach items="${special}" var="special">
                                        <option <c:if test="${special.nameSpecialized eq code}">selected</c:if> value="${special.nameSpecialized}">${special.code}</option>
                                    </c:forEach>
                                </select>
                                <select name="campN">
                                    <option value="7">-------------All-------------</option>
                                    <c:forEach items="${Camp}" var="cam">
                                        <option <c:if test="${cam.id eq camP}">selected</c:if> value="${cam.id}">${cam.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                    <a href="ShowListStudentFPTServlet?Spec=-1"><button type="submit" class="btn btn-default">Search</button></a>
                </form>
                <c:if test="${Key ne null}">${Key}</c:if>
                <ul class="list-group">
                    <c:forEach var="student" items="${listFPT}" 
                               begin="${pageStart}" end="${pageEnd}">
                        <form action="InformationStudentServlet" method="POST">
                            <li class="list-group-item">${student.firstName} ${student.lastName}
                                <input type="hidden" value="${student.id}" name="studentId" />
                                <button type="submit" class="btn btn-info">Information</button>
                            </li>
                        </form>
                    </c:forEach>
                </ul>
                <nav aria-label="Page navigation example">
                    <ul class="pagination mt-4">
                        <c:if test = "${prev eq true}">
                            <li class="page-item"><a class="page-link" href="ShowListStudentFPTServlet?page=${p-1}&Spec=${spec}">Previous</a></li>
                            </c:if>
                            <c:forEach var="i" begin="${btnStart}" end="${btnEnd}">
                            <li class="page-item"><a class="page-link" href="ShowListStudentFPTServlet?page=${i}&Spec=${spec}">${i}</a></li>
                            </c:forEach>
                            <c:if test = "${next eq true}" >
                            <li class="page-item"><a class="page-link" href="ShowListStudentFPTServlet?page=${p+1}&Spec=${spec}">Next</a></li>
                            </c:if>
                    </ul>
                </nav>
                <div class="btn-group mt-3" role="group" aria-label="Basic outlined example">
                    <a href="../academic/login.jsp"><button type="button" class="btn btn-outline-primary">Logout</button></a>
                </div>
            </div>
        </div>
    </body>
</html>
