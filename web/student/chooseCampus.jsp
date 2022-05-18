<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--        <title>FPT University</title>-->
        <!--<link href="../myStyle.css" rel="stylesheet">-->
        <!--        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
                      crossorigin="anonymous">-->
        <link rel="shortcut icon" href="../favicon.ico"/>
        <title>Trường Đại Học FPT</title>

        <link rel="stylesheet" href="../css/bootstrap.min.css">
        <!-- Icons -->
        <link rel="stylesheet" href="css/font-awesome.css">
        <link rel="stylesheet" href="../styleindex.css">
        <style>
            #main .text-small{
                font-size:14px;
                width: 100%;
                white-space: nowrap;
            }
            .big {
                color: #fff;
                font-size: 60px;
            }
            .text-top-small {
                font-size: 12px;
                font-weight: bold;
                text-transform: uppercase;
                color: black;
            }
            #main p{
                margin: 0 0 10px;
            }
            .item h2 {
                padding: 0%;
                color: black;
            }
            .item a {
                text-decoration: none;
            }
            .item h2:hover {
                color: orangered;
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
            <!--menu content-->
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
                                    <a href="about.html">Lịch sử thành lập</a>
                                    <a href="../about/1.html">Triết lý đào tạo</a>
                                    <a href="../about/2.html">Giải thưởng và thành tích</a>
                                </div>
                            </li>
                            <li class="dropdown"><a href="../news.html" class="dropbtn">News</a>
                                <div class="dropdown-content">
                                    <a href="#">Tim tức chung</a>
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
            <div class="row">
                <div class="banner1">
                    <h1>Đăng ký</h1>
                </div>
            </div>
            <div class="row">
                <section id="reason">
                    <div class="container3">
                        <div class="text-center">
                            <h2>VÌ SAO <span style="font-size: 120%;">50.000</span> 
                                SINH VIÊN CHỌN ĐẠI HỌC FPT?</h2>
                        </div>
                        <div id="main" class="row">
                            <div class="col-md-2 col-sm-4 col-xs-6 col-md-offset-1 text-center">
                                <p class="big">5★</p>
                                <p class="text-top-small">Chất lượng<br> đào tạo</p>
                            </div>
                            <div class="col-md-2 col-sm-4 col-xs-6 text-center">
                                <img class="img-responsive" style="margin-left: auto;margin-right: auto; margin-top: 23px;margin-bottom: 21px;" 
                                     src="../images/img-top2-qtkd.png">
                                <p class="text-top-small">Quản trị kinh doanh<br>tốt nhất Việt Nam</p>
                            </div>
                            <div class="col-md-2 col-sm-4 col-xs-6 text-center">
                                <p class="big">98%</p>
                                <p class="text-top-small">Sinh viên có<br> việc làm ngay</p>
                            </div>
                            <div class="col-md-2 col-sm-6 col-xs-6 text-center">
                                <p class="big">19%</p>
                                <p class="text-top-small">Sinh viên có<br>việc làm tại nước ngoài</p>
                            </div>
                            <div class="col-md-2 col-sm-6 col-xs-12 text-center">
                                <img class="img-responsive" style="margin-left: auto;margin-right: auto; margin-top: 23px;margin-bottom: 21px;" 
                                     src="../images/img-salary.png"/>
                                <p class="text-top-small">LÀ MỨC LƯƠNG<br>TRUNG BÌNH</p>
                            </div>
                        </div>
                    </div>   
                </section>
            </div>
            <div class="container1">
                <div class="container-form">
                    <h4 class="error">${error}</h4>
                    <h1>FPT University</h1>
                    <p>FPT University opens its Enrollment page for students to register their study campus and their specialization.</p>
                    <hr>
                    <form action="ChooseCampusServlet" method="POST">
                        <div class="form-group">
                            <label>Select Campus</label>
                            <select class="form-control" name="campusId">
                                <option value="8">FU-Hòa Lạc</option>
                                <option value="9">FU-Hồ Chí Minh</option>
                                <option value="10">FU-Đà Nẵng</option>
                                <option value="11">FU-Cần Thơ</option>
                                <!--                                <option value="12">MSE</option>
                                                                <option value="13">FE-LAO</option>-->
                            </select>
                        </div>
                        <button type="submit" class="btn btn-primary my-botton">Next</button>
                    </form>
                </div>
                <div id="fb-root"></div>
                <script async defer crossorigin="anonymous" src="https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v13.0" nonce="JtdL8WDs"></script>
                <div id="comment_fb">
                    <div class="fb-comments" data-href="https://www.facebook.com/plugins/post.php?href=https%3A%2F%2Fwww.facebook.com%2Ftuananh462001%2Fposts%2F823304271628613&amp;show_text=true&amp;width=500&quot; width=&quot;500&quot; height=&quot;304&quot; style=&quot;border:none;overflow:hidden&quot; scrolling=&quot;no&quot; frameborder=&quot;0&quot; allowfullscreen=&quot;true&quot; allow=&quot;autoplay; clipboard-write; encrypted-media; picture-in-picture; web-share&quot;" data-width="1050" data-numposts="5"></div>
                </div>
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
                                <p>Khu đô thị mới An Phú Thịnh, Phường Nhơn Bình & Phường Đống Đa, TP. Quy
                                    Nhơn, Bình Định
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
        <script src="js/Jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
