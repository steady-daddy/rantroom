<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

        <title>Home - RantRoom</title>

        <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
        <link href="${contextPath}/resources/css/style.css" rel="stylesheet">

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
					  <a class="navbar-brand" href="${contextPath}/home"><img class="logo" alt="RantRoom logo" src="${contextPath}/resources/images/rantroomlogo2.png" /></a>
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

        <div id="sub-content">
            <div class="container">
                <div class="row">
                    <div class="col-sm-3">
<!--                        <h3 class="home-h2" style="text-align: left;">RantRoom</h3>-->
                    </div>
                </div>    
                <div class="row">
                    <div class="col-sm-4 col-sm-offset-4">
<!--
                        <a href="${contextPath}/registration" class="btn btn-default home-links" style="margin-right:30px;">NEW MEMBER</a>
                        <a href="${contextPath}/login" class="btn btn-default home-links">EXISTING MEMBER</a>
-->
                    </div>
                    <!--<div class="col-sm-2 col-sm-offset-2">
                         <a href="${contextPath}/registration" class="home-links" style="">NEW MEMBER</a>
                    </div>-->
                </div>
                <div class="row">
                    <div class="col-sm-4 col-sm-offset-4">
                        <div class="copyright">
                            <p> &copy; 2018 Team RantRoom. All rights reserved | Designed by <a href="http://www.khansaad.com/" target="_blank" >Saad</a>| Mentored by <a href="http://www.roosnam.com/" target="_blank" >Mansoor</a></p>
                        </div>
                    </div>    
                </div>    
            </div><!-- /container -->
        </div><!-- main -->
    
        
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
    </body>
</html>
