<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert News</title>
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
                                <a class="nav-link" href="ShowListStudentFPTServlet?Spec=-1" class="dropbtn">Student FPT</a>
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
                            <li class="nav-item active">
                                <a class="nav-link" href="InsertNewsServlet">News</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="InsertNewsServlet">Admin</a>
                            </li>
                        </ul>
                    </div>
                </nav>
                <h2>Option</h2>
                <hr>
                <ul class="list-group">
                    <li class="list-group-item">
                        <form action="InsertNewServlet" method="Get">
                            <button type="submit" class="btn btn-info">Insert News</button>
                        </form>
                    </li>
                    <li class="list-group-item">
                        <form action="DeleteNewsServlet" method="Get">
                            <button type="submit" class="btn btn-info">Update/Delete</button>
                        </form>
                    </li>
                </ul>
                <div class="btn-group mt-3" role="group" aria-label="Basic outlined example">
                    <a href="../academic/login.jsp"><button type="button" class="btn btn-outline-primary">Logout</button></a>
                </div>
            </div>
        </div>        
    </body>
</html>
