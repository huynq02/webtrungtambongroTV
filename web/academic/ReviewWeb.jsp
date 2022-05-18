<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Review Website</title>
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
        <script
            src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js">
        </script>    
    </head>
    <body>
        <div class="container">
            <div class="container-form">
                <h1>List Student </h1>
                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link" href="ShowListStudentRegisterServlet">Student Register<span class="sr-only">(current)</span></a>
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
                                <a class="nav-link" href="ReviewWebServlet" class="dropbtn">Class Timetable</a>
                                <div class="dropdown-content">
                                    <a href="ShowListStudentFPTServlet?Spec=1">Kỹ Thuật Phần Mềm</a>
                                    <a href="ShowListStudentFPTServlet?Spec=2">An Toàn Thông Tin</a>
                                    <a href="ShowListStudentFPTServlet?Spec=3">Quản Trị Kinh Doanh</a>
                                </div>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="MoveOutClassServlet">Class</a>
                            </li>
                            <li class="nav-item active">
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
                <div class="row">
                    <div class="col-xl-3 col-md-6 mb-4">
                        <div class="card border-left-success shadow h-100 py-2">
                            <div class="card-body">
                                <div class="row no-gutters align-items-center">
                                    <div class="col mr-2">
                                        <div class="text-xs font-weight-bold text-success text-uppercase mb-1">
                                            Visited<br> Wed</div>

                                        <div class="h5 mb-0 font-weight-bold text-gray-800">1000</div>
                                    </div>
                                    <div class="col-auto">
                                        <i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-3 col-md-6 mb-4">
                        <div class="card border-left-success shadow h-100 py-2">
                            <div class="card-body">
                                <div class="row no-gutters align-items-center">
                                    <div class="col mr-2">
                                        <div class="text-xs font-weight-bold text-success text-uppercase mb-1">
                                            Total Register</div>
                                        <div class="h5 mb-0 font-weight-bold text-gray-800">${totalReg}</div>
                                    </div>
                                    <div class="col-auto">
                                        <i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-3 col-md-6 mb-4">
                        <div class="card border-left-success shadow h-100 py-2">
                            <div class="card-body">
                                <div class="row no-gutters align-items-center">
                                    <div class="col mr-2">
                                        <div class="text-xs font-weight-bold text-success text-uppercase mb-1">
                                            Total Student</div>
                                        <div class="h5 mb-0 font-weight-bold text-gray-800">${totalStu}</div>
                                    </div>
                                    <div class="col-auto">
                                        <i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-3 col-md-6 mb-4">
                        <div class="card border-left-success shadow h-100 py-2">
                            <div class="card-body">
                                <div class="row no-gutters align-items-center">
                                    <div class="col mr-2">
                                        <div class="text-xs font-weight-bold text-success text-uppercase mb-1">
                                            Total Comment</div>
                                        <div class="h5 mb-0 font-weight-bold text-gray-800">1</div>
                                    </div>
                                    <div class="col-auto">
                                        <i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xl-12 col-md-8 mb-8">
                        <canvas id="horizontalBar"></canvas>
                    </div>
<!--                    <div class="col-xl-12 col-md-4 mb-4">
                        <canvas id="doughnutChart"></canvas>
                    </div>    -->
                </div>  

                <div class="btn-group mt-3" role="group" aria-label="Basic outlined example">
                    <a href="../academic/login.jsp"><button type="button" class="btn btn-outline-primary">Logout</button></a>
                </div>
            </div>
        </div> 
        <script>
            new Chart(document.getElementById("horizontalBar"), {
                "type": "horizontalBar",
                "data": {
                    "labels": ["Vs", "Tr", "Ts", "Tre", ],
                    "datasets": [{
                            "label": "Compare",
                            "data": [1000, 4, 20, 250],
                            "fill": false,
                            "backgroundColor": ["rgba(255, 99, 132, 0.2)", "rgba(255, 159, 64, 0.2)",
                                "rgba(255, 205, 86, 0.2)", "rgba(75, 192, 192, 0.2)", "rgba(54, 162, 235, 0.2)",
                                "rgba(153, 102, 255, 0.2)", "rgba(201, 203, 207, 0.2)"
                            ],
                            "borderColor": ["rgb(255, 99, 132)", "rgb(255, 159, 64)", "rgb(255, 205, 86)",
                                "rgb(75, 192, 192)", "rgb(54, 162, 235)", "rgb(153, 102, 255)", "rgb(201, 203, 207)"
                            ],
                            "borderWidth": 1
                        }]
                },
                "options": {
                    "scales": {
                        "xAxes": [{
                                "ticks": {
                                    "beginAtZero": true
                                }
                            }]
                    }
                }
            });
            var ctxD = document.getElementById("doughnutChart").getContext('2d');
            var myLineChart = new Chart(ctxD, {
                type: 'doughnut',
                data: {
                    labels: ["Red", "Green", "Yellow", "Grey", "Dark Grey"],
                    datasets: [{
                            data: [300, 50, 100, 40, 120],
                            backgroundColor: ["#F7464A", "#46BFBD", "#FDB45C", "#949FB1", "#4D5360"],
                            hoverBackgroundColor: ["#FF5A5E", "#5AD3D1", "#FFC870", "#A8B3C5", "#616774"]
                        }]
                },
                options: {
                    responsive: true
                }
            });
        </script>
    </body>
</html>

