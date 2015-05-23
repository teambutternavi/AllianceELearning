<%-- 
    Document   : index
    Created on : May 19, 2015, 2:22:11 PM
    Author     : Ted Ian Osias
--%>

<%@page import="AES.Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    System.out.println("Nisud sa index");
%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Alliance E-Learning</title>

    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/site.css">
</head>
<body>

<div class="log-slider">
    <div class="col-sm-2">
        <a href="#"><img src="img/menu.png" class="img-responsive menu-btn slide-menu-burger slider-menu"></a>
    </div>
    <div class="col-sm-offset-6 col-sm-4">
        <h1 class="login-text">Login</h1>
    </div>
    <div class="col-sm-12">
        <br>
        <br>
        <form method="POST" action="dashboard.htm">
            <div class="form-group">
                <input type="text" class="form-control input-lg" id="inputEnrolKey" name="username" required autofocus placeholder="username"">
            </div>
            <div class="form-group">
                <input type="password" class="form-control input-lg" id="inputEnrolKey" name="password" required autofocus placeholder="*******">
            </div>
            <div class="checkbox">
                <label>
                    <input type="checkbox" name="rememberOp"> Remember me?
                </label>
            </div>
            <button type="submit" id="okbtn" class="btn btn-primary btn-lg btn-block" name="submit">Login</button>
            <br>
            <div>
                <a href="test.htm" class="login-url">Forgot Password?</a>
            </div>
            <div>
                <a href="register.htm" class="login-url">Not enrolled yet?</a>
            </div>
        </form>
    </div>
</div>

<header class="container-fluid topmost">
    <div class="container site-branding">
        <div class="row">
            <div class="col-md-1">
                <img src="img/logo.png" class="img-responsive">
            </div>
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="#" class="social-a"><img src="img/fb.png" class="head-social"></a>
                </li>
                <li>
                    <a href="#" class="social-a"><img src="img/tw.png" class="head-social"></a>
                </li>
                <li>
                    <a href="#"class="social-a"><img src="img/vm.png" class="head-social"></a>
                </li>
            </ul>
        </div>
    </div>

</header>
<div class="navbar navbar-inverse bs-docs-nav" role="banner">
    <div class="container">
        <nav class="collapse navbar-collapse bs-navbar-collapse" role="navigation">
            <ul class="nav navbar-nav navbar-left">
                <li>
                    <a href="#">Course</a>
                </li>
                <li class="active">
                    <a href="#">Profile</a>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="#"><img src="img/search.png" class="img-responsive menu-btn"></a>
                </li>
                <li>
                    <a href="#" id="slider-menu"><img src="img/menu.png" class="img-responsive menu-btn slider-menu"></a>
                </li>
            </ul>
        </nav>
    </div>
</div>

<div class="content container">
    <div class="row">
        <div class="col-sm-10 col-sm-offset-1">
            <h5>Courses > Java > Lesson 1</h5>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-offset-1 col-sm-4">
            <h2>Introduction</h2>
        </div>
        <div class="col-sm-offset-3 col-sm-3">
            <h2 class="text-right">Chapter 1</h2>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-10 col-sm-offset-1 dashed presentation-area">
            <div class="row">
                <div class="col-sm-offset-1 col-sm-10">
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed nec nisl blandit ipsum consectetur luctus.
                    Ut ut vestibulum nunc, a hendrerit elit. Cras erat nunc, rhoncus at diam ultricies,
                    lobortis luctus ex. Maecenas sagittis, nunc et facilisis blandit, ex neque efficitur tellus, ac dictum lectus
                    enim vel odio. Nullam po suere mi libero, at vestibulum orci vestibulum ut.

                    <div class="presentation-box">
                        <h1 class="text-center">PRESENTATION AREA</h1>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>

<footer role="footer" class="container-fluid">
    <div class="container">
        <div class="row">
            <div class="col-sm-3">
                <div class="row">
                    <div class="col-sm-6 footer-nav">
                        <h4>The Site</h4>
                        <ul class="list-unstyled">
                            <li>
                                <a href="#">Home</a>
                            </li>
                            <li>
                                <a href="#">Course</a>
                            </li>
                            <li>
                                <a href="#">More Info</a>
                            </li>
                            <li>
                                <a href="#">Help</a>
                            </li>
                        </ul>
                    </div>
                    <div class="col-sm-6 footer-nav">
                        <h4>User</h4>
                        <ul class="list-unstyled">
                            <li>
                                <a href="#">Login</a>
                            </li>
                            <li>
                                <a href="#">Enrol me</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-sm-6 dashed-left dashed-right">
                <div class="row">
                    <div class="col-sm-8 col-sm-offset-2">
                        <div class="row">
                            <div class="col-sm-10 dev-team">
                                <img class="img-responsive butter-logo pull-left" src="img/bn.png">
                                <h5>Designed and Developed by</h5>
                                <h3>ButterNavi Int'l</h3>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-6 col-sm-offset-3">
                                <img class="img-responsive asi-logo" src="img/asi_logo.png">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="row">
                    <div class="col-sm-10 col-sm-offset-2 about-us">
                        <h4>About Us</h4>
                        <p class="text-justify">Lorem ipsum dolor sit amet, consectetur adipiscing elit. In tincidunt tortor ac urna rhoncus semper. In feugiat, urna in malesuada cursus, </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</footer>
<div class="container-fluid second-footer">
    <div class="container">
        <div class="row">
            <div class="col-sm-12">
                <ul class="list-inline sfooter-links">
                    <li>
                        <a href="#">DMCA POLICY</a>
                    </li>
                    <li>
                        <a href="#">TERMS OF USE</a>
                    </li>
                    <li>
                        <a href="#">PRIVACY STATEMENT</a>
                    </li>
                </ul>
                <p>All Rights Reserved. All trademarks mentioned are the property of their respective owners.</p>
            </div>
        </div>
    </div>
</div>

<script src="js/jquery-2.1.3.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/site.js"></script>
</body>
</html>