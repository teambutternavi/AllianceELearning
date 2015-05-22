<%-- 
    Document   : register
    Created on : May 19, 2015, 2:42:36 PM
    Author     : Ted Ian Osias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <form>
            <div class="form-group">
                <!--<label for="inputFullname"></label>-->
                <input type="text" class="form-control input-lg" id="inputEnrolKey" name="enrolKey" required autofocus placeholder="username"">
            </div>
            <div class="form-group">
                <!--<label for="inputFullname"></label>-->
                <input type="text" class="form-control input-lg" id="inputEnrolKey" name="enrolKey" required autofocus placeholder="*******">
            </div>
            <div class="checkbox">
                <label>
                    <input type="checkbox"> Remember me?
                </label>
            </div>
            <button type="submit" id="okbtn" class="btn btn-primary btn-lg btn-block" name="submit">Login</button>
            <br>
            <div>
                <a href="#" class="login-url">Forgot Password?</a>
            </div>
            <div>
                <a href="#" class="login-url">Not enrolled yet?</a>
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

<div class="reg-content container-fluid">
    <div class="row">

        <div class="col-sm-6 reg-left">
            <div class="row">
                <div class=" col-sm-offset-4 col-sm-6 reg-form-box">
                    <form role="form" method="post">
                        <h2>Enrollment</h2>
                        <div class="form-group">
                            <!--<label for="inputFullname"></label>-->
                            <input type="text" class="form-control input-lg" id="inputEnrolKey" name="enrolKey" required autofocus placeholder="enrolment key">
                            <small class="pull-right">this is given by an official instructor</small>
                        </div>
                        <div class="form-group">
                            <!--<label for="inputFullname"></label>-->
                            <input type="text" class="form-control input-lg" id="inputUsername" name="username" required autofocus placeholder="account username">
                        </div>
                        <div class="form-group">
                            <!--<label for="inputFullname"></label>-->
                            <input type="password" class="form-control input-lg lg" id="inputPassword" name="password" required autofocus placeholder="new password">
                        </div>
                        <div class="form-group">
                            <!--<label for="inputFullname"></label>-->
                            <input type="password" class="form-control input-lg" id="inputConfirmPassword" name="cpassword" required autofocus placeholder="confirm password">
                        </div>
                        <button type="submit" id="okbtn" class="btn btn-primary btn-lg" name="submit">Proceed</button>
                    </form>

                </div>
            </div>
        </div>
        <div class="col-sm-6 reg-right">
            <div class="row dashed-bottom">
                <div class="col-sm-offset-1 col-sm-8 no-key">
                    <h2 class="dont-have-key">Don't have an enrolment key?</h2>
                    <p class="dont-have-key-sub">Lorem ipsum dolor sit amet, consectetur adipiscing elit.
                        Maecenas a neque at justo suscipit iaculis in in nunc.
                        Nunc ac sem iaculis, tempor sapien at, cursus sem.In
                        vestibulum lectus ac nunc facilisis porttitor.</p>
                    <button type="submit" id="okbtn" class="btn btn-primary btn-lg" name="submit">Learn More</button>
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