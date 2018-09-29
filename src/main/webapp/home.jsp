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
                    <div class="row">
                        <div class="col-sm-3">
                            <div class="navbar-header">
                              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                              </button>
                              <a class="navbar-brand" href="./home"><img class="logo" alt="RantRoom logo" src="${contextPath}/resources/images/rantroomlogo_bl.png" /></a>
                            </div>
                        </div>    
                        <div class="col-sm-9">
                            <div class="row navbar-collapse collapse" id="bs-example-navbar-collapse-1" aria-expanded="false">                                
                                <div class="col-sm-8 menu">    
                                      <ul class="nav navbar-nav">
                                        <li><a href="home.html">Home</a></li>
                                        <li></li>
                                        <li><a href="#">Rants</a></li> 
                                        <li class="dropdown">
                                          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Categories <span class="caret"></span></a>
                                            <ul class="dropdown-menu sublist" role="menu">
                                                    <li><a href="#">Politics</a></li>
                                                    <li><a href="#">Technology</a></li>
                                                    <li><a href="#">Sports</a></li>
                                                    <li><a href="#">Social Issues</a></li>
                                                    <li><a href="#">Social Media</a></li>
                                                    <li><a href="#">Work</a></li>
                                                    <li><a href="#">Religion</a></li>
                                            </ul>
                                        </li>
                                        <li class="dropdown">
                                          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">About <span class="caret"></span></a>
                                            <ul class="dropdown-menu sublist" role="menu">
                                                    <li><a href="#">About</a></li>
                                                    <li><a href="#">Rules</a></li> 
                                            </ul>
                                        </li>  
                                      </ul>
                                </div><!--inner col-sm-8--> 
                                <div class="col-sm-4">                                    
                                      <ul class="nav navbar-nav navbar-right menu">
                                            <li><a href="${contextPath}/login">Login</a></li>
                                            <li><a class="home-links" href="${contextPath}/registration">Sign Up</a></li>
                                      </ul>     
                                </div><!--inner col-sm-4--> 
                            </div><!--inner-row-->
                        </div><!--outer col-sm-8-->   
                    </div><!--outer-row-->    
                </div><!--container-->
			</nav>
		</header>
        
        <div id="main">
            <div class="container" id="sub-content">
                <div class="row">
                    <div>
                        <p id="intro">Welcome to RantRoom. A a public forum for people to rant about anything under the sun. Here, you can speak your heart out with complete anonymity. So, what are you waiting for? Sign up instantly and start ranting.</p>
                    </div>                    
                </div>
                <div class="row">
                    <div class="col-sm-8 col-sm-4">                        
				
				        <div id="confessions-list" class="list">
                            <div class="list-item" style="">
                                <div class="list-content">
                                    <h3><a href="https://rantrampage.com/story-mercurial-vapor-14649">Rant 1</a></h3>
                                    <p><i class="fa fa-quote-left text-quote-icon"></i> &nbsp;Some ranting about rant so that I learn how to rant and then post more rant and more rant and continue ranting..ha ha ha</p>                                    
                                </div><!-- list-content -->
                            </div><!--list-item -->
                            <div class="list-item" style="">
                                <div class="list-content">
                                    <h3><a href="https://rantrampage.com/story-i-hate-myself-17613">Rant 2</a></h3>
                                    <p><i class="fa fa-quote-left text-quote-icon"></i> &nbsp;Some ranting about rant so that I learn how to rant and then post more rant and more rant and continue ranting..ha ha ha</p>                                    
                                </div><!-- list-content -->
                            </div><!--list-item -->
                            <div class="list-item" style="">
                                <div class="list-content">
                                    <h3><a href="https://rantrampage.com/story-sexist-dad-13094">Rant 3</a></h3>
                                    <p><i class="fa fa-quote-left text-quote-icon"></i> &nbsp;Some ranting about rant so that I learn how to rant and then post more rant and more rant and continue ranting..ha ha ha</p>
                                </div><!-- list-content -->
                            </div><!--list-item -->
                            <div class="list-item" style="">
                                <div class="list-content">
                                    <h3><a href="https://rantrampage.com/story-beziez-13588">Rant 4</a></h3>
                                    <p><i class="fa fa-quote-left text-quote-icon"></i> &nbsp;Some ranting about rant so that I learn how to rant and then post more rant and more rant and continue ranting..ha ha ha</p>                                   
                                </div><!-- list-content -->
                            </div><!--list-item -->
                            <div class="list-item" style="">
                                <div class="list-content">
                                    <h3><a href="https://rantrampage.com/story-there-is-no-god-95547">Rant 5</a></h3>
                                    <p><i class="fa fa-quote-left text-quote-icon"></i> &nbsp;Some ranting about rant so that I learn how to rant and then post more rant and more rant and continue ranting..ha ha ha</p>                                    
                                </div><!-- list-content -->
                            </div><!--list-item -->
                            <div class="list-item" style="">
                                <div class="list-content">
                                    <h3><a href="https://rantrampage.com/story-you-dumb-motherfucker-28067">Rant 6</a>
                                    </h3><p><i class="fa fa-quote-left text-quote-icon"></i> &nbsp;Some ranting about rant so that I learn how to rant and then post more rant and more rant and continue ranting..ha ha ha</p>
                                </div><!-- list-content -->
                            </div><!--list-item -->
                            <div class="list-item" style="">
                                <div class="list-content">
                                    <h3><a href="https://rantrampage.com/story-my-cousin-12506">Rant 7 </a></h3>
                                    <p><i class="fa fa-quote-left text-quote-icon"></i> &nbsp;Some ranting about rant so that I learn how to rant and then post more rant and more rant and continue ranting..ha ha ha</p>                                   
                                </div><!-- list-content -->
                            </div><!--list-item -->
                        </div><!-- rants-list -->
                    </div> <!-- col-sm-8 -->   
                </div> <!-- row -->   
            </div><!-- /container -->
            </div><!-- main -->

            <!-- footer -->
            <footer id="footer" class="text-center">
          <div class="container social">

            <div class="col-sm-12">                
              <a href="#" class="icon-circle fb" target="_blank">
                <img class="logo" alt="Facebook" src="./resources/social/facebook_transparent-1c6a690dcde061958f50f712404c764613cc193d3f69e81734c8c9a7f36131e4.png" />
              </a>

              <a href="#" class="icon-circle tw" target="_blank">
                <img class="logo" alt="Twitter" src="./resources/social/twitter_transparent-39f60ddc31bce0d3e3d6ae72af7fbe74dc95e01b7d7a6f66cc38efabda3bb6da.png" />
              </a>

              <a href="#" class="icon-circle gl" target="_blank">
                <img class="logo" alt="Google Plus" src="./resources/social/gplus_transparent-fab632559c47bada047b0ff2cb7b8880a10836d08db04c7cdae2e3d3abe474e1.png" />
              </a>
                
                <a href="#" class="icon-circle pt" target="_blank">
                <img class="logo" alt="Pinterest" src="./resources/social/pinterest_transparent-a58a9baa98ec9a2e4fed6d4ab7ffdb69bc607c82649a486544b2b5dab03364ef.png" />
               </a>
            </div>

          </div><!--social-->

          <p id="copyright">&copy; 2018 Team RantRoom. All rights reserved | Designed by <a href="http://www.khansaad.com/" target="_blank" >Saad </a>| Mentored by <a href="http://www.roosnam.com/" target="_blank" >Mansoor</a></p>
        </footer>
        </div>    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
    </body>
</html>
