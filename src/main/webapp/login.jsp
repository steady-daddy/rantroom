<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Login - RantRoom</title>

        <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<!--        <link href="${contextPath}/resources/css/common.css" rel="stylesheet">-->
        <link href="${contextPath}/resources/css/style.css" rel="stylesheet">
        <!--web-fonts-->
        <link href='//fonts.googleapis.com/css?family=Jura:400,300,500,600' rel='stylesheet' type='text/css'>
        <!--//web-fonts-->
        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>

    <body>
        <header id="header">
            <nav class="navbar navbar-default">
                <div class="container">
                    <div class="navbar-header">
                      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                      </button>
                      <a class="navbar-brand" href="./home"><img class="logo" alt="RantRoom logo" src="${contextPath}/resources/images/rantroomlogo2.png" /></a>
                    </div>
                    <div class="navbar-collapse collapse" id="bs-example-navbar-collapse-1" aria-expanded="false">
                      <ul class="nav navbar-nav navbar-right">
                            <li><a href="${contextPath}/login">Login</a></li>
                            <li><a id="signup-link" class="btn btn-default home-links" href="${contextPath}/registration">Sign Up</a></li>
                      </ul>
                    </div><!-- /navbar-collapse -->
                </div><!-- /container -->
            </nav>
        </header>
        <div class="container" id="sub-content">
            <div class="row">
                <div class="col-sm-4 col-sm-offset-4">
<!--                    <h2 class="home-h2">Welcome to RantRoom</h2>-->
                </div>
            </div>
            <div class="row">                
                <div class="col-sm-4 col-sm-offset-4">
                    <div class= "form-body">
                        <h3>Login</h3>
                        <span style="color: #01DF01;">${message}</span>
                        <div class="login-form">
                            <form method="POST" action="${contextPath}/login">
                                <div class="form-group ${error != null ? 'has-error' : ''}">
                                    <div>
                                        <label>USERNAME:</label>
                                        <input name="username" type="text" class="form-control">
                                    </div>
                                    <div>
                                        <label>PASSWORD:</label>
                                        <input name="password" type="password" class="form-control">
                                    </div>    
                                    <span>${error}</span>
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                                    <button type="submit">Sign In</button>
                                    
                                </div>
                            </form>
                            <h4 class="text-center" style="font-size: 12px"><a href="${contextPath}/registration">Not a Member?</a></h4>
                        </div><!--log-in-form-->                       
                    </div><!--form-body-->
                </div><!--col-sm-4-->  
            </div><!--row-->    
        </div><!-- container -->
        <div class="copyright">
            <p> &copy; 2018 Team RantRoom. All rights reserved | Designed by <a href="http://www.khansaad.com/" target="_blank" >Saad </a>| Mentored by <a href="http://www.roosnam.com/" target="_blank" >Mansoor</a></p>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
    </body>
</html>
