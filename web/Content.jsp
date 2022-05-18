<%-- 
    Document   : Content
    Created on : Mar 15, 2022, 11:08:01 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Ngành truyền thông đa phương tiện đang tìm kiếm tài năng</title>
<!--        <link rel="shortcut icon" href="../favicon.ico" />
        <link rel="stylesheet" href="../css/bootstrap.min.css">
         Icons 
        <link rel="stylesheet" href="css/font-awesome.css">
        <link rel="stylesheet" href="../styleindex.css">-->
        <link rel="shortcut icon" href="./favicon.ico" />
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!-- Icons -->
    <link rel="stylesheet" href="css/font-awesome.css">
    <link rel="stylesheet" href="styleindex.css">
        <style>
            @media only screen and (max-width: 760px) {
            div img {
                width: 100%;
            }
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
            <div class="row">

                <nav class="navbar navbar-default">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                                data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>

                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li class="active"><a href="../index.html">Home <span class="sr-only">(current)</span></a></li>
                            <li class="dropdown"><a href="../about.html" class="dropbtn">About</a>
                                <div class="dropdown-content">
                                    <a href="../about.html">Lịch sử thành lập</a>
                                    <a href="../about/1.html">Triết lý đào tạo</a>
                                    <a href="../about/2.html">Giải thưởng và thành tích</a>
                                </div>
                            </li>
                            <li class="dropdown"><a href="ShowNewsServlet" class="dropbtn">News</a>
                                <div class="dropdown-content">
                                    <a href="ShowNewsServlet">Tim tức chung</a>
                                    <a href="#">Hoạt động sinh viên</a>
                                    <a href="#">Sự kiện</a>
                                </div>
                            </li>
                            <li><a href="../student/chooseCampus.jsp">Contact</a></li>
                            <li><a href="../academic/login.jsp">LogIn</a></li>

                        </ul>
                        <form class="navbar-form navbar-right">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Search">
                            </div>
                            <button type="submit" class="btn btn-default">Search</button>
                        </form>

                    </div>

                </nav>

            </div>
            <div style="border-top: 1px solid rgb(221, 221, 221); margin-bottom: 5%;">
                <header>
                    <h1>
                        ${News.title}
                    </h1>
                    <h5 style="color: rgb(206, 205, 205);">${News.createddate}</h5>
                    <h4 style="color: black;">
                    ${News.description}
                    </h4>
                    <!--<h1>Trần Quốc Khánh – K16, chuyên ngành Thiết kế mỹ thuật số</h1>-->
                    <p>${News.content}</p>
                </header>
            </div>
            <div class="copyright">
                © 2022 Bản quyền thuộc về Trường Đại học FPT.
            </div>
            <footer>
                <div class="container">
                    <div class="row">
                        <div class="col-md-3">
                            <h4>HÀ NỘI</h4>
                            <div class="textwidget">
                                <p>Khu Giáo dục và Đào tạo – Khu Công nghệ cao Hòa Lạc
                                    – Km29 Đại lộ Thăng Long,
                                    H. Thạch Thất,TP. Hà Nội
                                </p>
                                <p>Điện thoại: 024 7300 1866</p>
                                <p>Email: daihocfpt@fpt.edu.vn</p>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <h4>TP. HỒ CHÍ MINH</h4>
                            <div class="textwidget">
                                <p>Lô E2a-7, Đường D1 Khu Công nghệ cao,
                                    P. Long Thạnh Mỹ, TP. Thủ Đức,
                                    TP. Hồ Chí Minh
                                </p>
                                <p>Điện thoại: 028 7300 1866</p>
                                <p>Email: daihocfpt@fpt.edu.vn</p>
                            </div>
                        </div>
                        <div class="col-md-2">
                            <h4>ĐÀ NẴNG</h4>
                            <div class="textwidget">
                                <p>Khu đô thị công nghệ FPT Đà Nẵng,
                                    P. Hoà Hải, Q. Ngũ Hành Sơn,
                                    TP. Đà Nẵng
                                </p>
                                <p>Điện thoại: 0236 730 1866</p>
                                <p>Email: daihocfpt@fpt.edu.vn</p>
                            </div>
                        </div>
                        <div class="col-md-2">
                            <h4>CẦN THƠ</h4>
                            <div class="textwidget">
                                <p>Số 600 Đường Nguyễn Văn Cừ (nối dài),
                                    P. An Bình, Q. Ninh Kiều, TP. Cần Thơ
                                </p>
                                <p>Điện thoại: 0292 730 1866</p>
                                <p>Email: daihocfpt@fpt.edu.vn</p>
                            </div>
                        </div>
                        <div class="col-md-2">
                            <h4>QUY NHƠN</h4>
                            <div class="textwidget">
                                <p>
                                </p>
                                <p>Điện thoại: 0256 730 1866</p>
                                <p>Email: daihocfpt@fpt.edu.vn</p>
                            </div>
                        </div>
                    </div>
                </div>
            </footer>
        </div>
        <!-- JavaScript libs are placed at the end of the document so the pages load faster -->
        <script src="../js/Jquery.js"></script>
        <script src="../js/bootstrap.min.js"></script>

    </body>
</html>
