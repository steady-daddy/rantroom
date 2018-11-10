<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> <%-- imports function tags from JSTL, prefix "fn"--%>
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

    <title>RantRoom | ${user.getFirstname()}</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/style.css" rel="stylesheet">
    <!--favicons -->
	    <link rel="apple-touch-icon" sizes="57x57" href="${contextPath}/resources/favicons/apple-icon-57x57.png">
	    <link rel="apple-touch-icon" sizes="60x60" href="${contextPath}/resources/favicons/apple-icon-60x60.png">
	    <link rel="apple-touch-icon" sizes="72x72" href="${contextPath}/resources/favicons/apple-icon-72x72.png">
	    <link rel="apple-touch-icon" sizes="76x76" href="${contextPath}/resources/favicons/apple-icon-76x76.png">
	    <link rel="apple-touch-icon" sizes="114x114" href="${contextPath}/resources/favicons/apple-icon-114x114.png">
	    <link rel="apple-touch-icon" sizes="120x120" href="${contextPath}/resources/favicons/apple-icon-120x120.png">
	    <link rel="apple-touch-icon" sizes="144x144" href="${contextPath}/resources/favicons/apple-icon-144x144.png">
	    <link rel="apple-touch-icon" sizes="152x152" href="${contextPath}/resources/favicons/apple-icon-152x152.png">
	    <link rel="apple-touch-icon" sizes="180x180" href="${contextPath}/resources/favicons/apple-icon-180x180.png">
	    <link rel="icon" type="image/png" sizes="192x192"  href="${contextPath}/resources/favicons/android-icon-192x192.png">
	    <link rel="icon" type="image/png" sizes="32x32" href="${contextPath}/resources/favicons/favicon-32x32.png">
	    <link rel="icon" type="image/png" sizes="96x96" href="${contextPath}/resources/favicons/favicon-96x96.png">
	    <link rel="icon" type="image/png" sizes="16x16" href="${contextPath}/resources/favicons/favicon-16x16.png">
	    <link rel="manifest" href="${contextPath}/resources/favicons/manifest.json">
	    <meta name="msapplication-TileColor" content="#ffffff">
	    <meta name="msapplication-TileImage" content="/ms-icon-144x144.png">
	    <meta name="theme-color" content="#ffffff">
    <!--favicons-end -->
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
                              <a class="navbar-brand" href="../home"><img class="logo" alt="RantRoom logo" src="${contextPath}/resources/images/rantroomlogo_bl.png" /></a>
                            </div>
                        </div>    
                        <div class="col-sm-9">
                            <div class="row navbar-collapse collapse menu" id="bs-example-navbar-collapse-1" aria-expanded="false">                                
                                <div class="col-sm-8">    
                                      <ul class="nav navbar-nav">
                                        <li><a href="${contextPath}/home">Home</a></li>
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
                                	<ul class="nav navbar-nav navbar-right">
                                      	<c:choose>
                                      		<c:when test="${userForm != null}">
	                                            <li class="dropdown">
                                          			<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">${userForm.getUsername()}<span class="caret"></span></a>
                                            			<ul class="dropdown-menu sublist" role="menu">
		                                                    <li><a href="${contextPath}/users/profile">Profile</a></li>		                                                    
		                                                    <li><a href="${contextPath}/users/profile/settings">Settings</a></li>
		                                                    <li><a onclick="document.forms['logoutForm'].submit()">Logout</a></li> 
                                            			</ul>
									                    <form id="logoutForm" method="POST" action="${contextPath}/logout">
									                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
									                    </form>
                                        		</li>  	                                            
                                      			<form id="logoutForm" method="POST" action="${contextPath}/logout">
                                    				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                				</form>
                                        	</c:when>
                                        	<c:otherwise>
                                        		<li><a href="${contextPath}/login">Login</a></li>
	                                            <li><a class="home-links" href="${contextPath}/registration">Sign Up</a></li>
                                        	</c:otherwise>
                                        </c:choose>	    
                                      </ul>                                       
                                      <!-- <ul class="nav navbar-nav navbar-right">
                                            <li><a data-toggle="modal" data-target="#myModal" href="#">Delete Account</a></li>
                                           <li><a class="home-links" href="${contextPath}/registration">Sign Up</a></li>
                                      </ul> -->     
                                </div><!--inner col-sm-4--> 
                            </div><!--inner-row-->
                        </div><!--outer col-sm-9-->   
                    </div><!--outer-row-->    
                </div><!--container-->
			</nav>
		</header>
		<div id="main">
			<div class="container" id="sub-content">
			    <h1>Edit Profile</h1>
			  	<hr>
				<div class="row">
			      <!-- left column --> 
			      <div class="col-md-3">
                      <img src="${contextPath}/resources/images/no-dp-boy.jpg" class="avatar img-circle" alt="avatar" height="150" width="150">
                      <form:form action="/upload" enctype="multipart/form-data" method = "post">
                        <label> Update your Profile photo</label>
                        <!-- <input type="file" name="fileupload" value="fileupload" id="fileupload"> -->
                        <input type="file" name="file" class="custom-file-input" />
                        <input type="submit" value="Upload" class="custom-file-input" style="margin-top: 12px" />
                      </form:form>

			        <%-- <div class="text-center">
			          <img src="${contextPath}/resources/images/no-dp-boy.jpg" class="avatar img-circle" alt="avatar" height="150" width="150">
			          <h6>Change Avatar</h6>
			          
			          <input type="file" class="form-control">
			        </div> --%>
			      </div>
			      
			      <!-- edit form column -->
			      <div class="col-md-9 personal-info">
			        <!-- <div class="alert alert-info alert-dismissable">
			          <a class="panel-close close" data-dismiss="alert">�</a> 
			          <i class="fa fa-coffee"></i>
			          This is an <strong>.alert</strong>. Use this to show important messages to the user.
			        </div> -->
			        <h3>Personal info</h3>
			        <%-- <div class="col-sm-3 col-sm-offset-3 menu">
                        <p style="font-weight: 700"><a href="${contextPath}/users/profile">Cancel</a></p>
                    </div> --%>
			        
                    <form:form method="POST" modelAttribute="userForm" class="form-horizontal">
                        <div class="form-group">
                            <label class="col-lg-3 control-label">USERNAME:</label>
                            <spring:bind path="username">                       
	                            <div class="col-lg-8 form-group">
	                                <input type="text" value="${userForm.getUsername()}" class="form-control" readonly></input>                                            
	                            </div>
                       		</spring:bind>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 control-label">FIRST NAME:</label>
                            <spring:bind path="firstname">
                                <div class="col-lg-8 form-group ${status.error ? 'has-error' : ''}">
                                    <form:input type="text" path="firstname" value="${userForm.getFirstname()}" class="form-control" autofocus="true"></form:input>
                                    <form:errors path="firstname"></form:errors>
                                </div>
                            </spring:bind>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 control-label">LAST NAME:</label>
                            <spring:bind path="lastname">
                                <div class="col-lg-8 form-group ${status.error ? 'has-error' : ''}">
                                    <form:input type="text" path="lastname" value="${userForm.getLastname()}" class="form-control" autofocus="true"></form:input>
                                </div>
                            </spring:bind>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 control-label">EMAIL:</label>
                            <spring:bind path="email">                        
	                            <div class="col-lg-8 form-group">
	                                <input type="text" value="${userForm.getEmail()}" class="form-control" 	readonly></input>                                            
	                            </div>
                   			</spring:bind>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 control-label">PASSWORD:</label>
                            <spring:bind path="password">
                                <div class="col-lg-8 form-group ${status.error ? 'has-error' : ''}">
                                    <form:input type="password" path="password" value="${userForm.getPasswordConfirm()}" class="form-control"></form:input>
                                    <form:errors path="password"></form:errors>
                                </div>
                            </spring:bind>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 control-label">CONFIRM PASSWORD:</label>
                            <spring:bind path="passwordConfirm">
                                <div class="col-lg-8 form-group ${status.error ? 'has-error' : ''}">
                                    <form:input type="password" path="passwordConfirm" value="${userForm.getPasswordConfirm()}" class="form-control"></form:input>
                                    <form:errors path="passwordConfirm"></form:errors>
                                </div>
                            </spring:bind>
                        </div>    
                       	<div class="form-group">
				          <label class="col-md-3 control-label"></label>
				          <div class="col-md-8">
				            <button type="submit" class="btn btn-primary">Save Changes</button>						              						              
				          </div>
				       	</div>
                    </form:form>
			        <%-- <form class="form-horizontal" role="form">
			          <div class="form-group">
			            <label class="col-lg-3 control-label">Username:</label>
			            <div class="col-lg-8">
			              <input class="form-control" type="text" value="${user.getUsername()}" readonly>
			            </div>
			          </div>
			          <div class="form-group">
			            <label class="col-lg-3 control-label">First name:</label>
			            <div class="col-lg-8">
			              <input class="form-control" type="text" value="${user.getFirstname()}">
			            </div>
			          </div>
			          <div class="form-group">
			            <label class="col-lg-3 control-label">Last name:</label>
			            <div class="col-lg-8">
			              <input class="form-control" type="text" value="${user.getLastname()}">
			            </div>
			          </div>			          
			          
			          <div class="form-group">
			            <label class="col-lg-3 control-label">Email:</label>
			            <div class="col-lg-8">
			              <input class="form-control" type="text" value="${user.getEmail()}" readonly>
			            </div>
			          </div>			          		         
			          <div class="form-group">
			            <label class="col-md-3 control-label">Password:</label>
			            <div class="col-md-8">
			              <input class="form-control" type="password" value="${user.getPassword()}">
			            </div>
			          </div>
			          <div class="form-group">
			            <label class="col-md-3 control-label">Confirm password:</label>
			            <div class="col-md-8">
			              <input class="form-control" type="password" value="${user.getPassword()}">
			            </div>
			          </div>
			          <div class="form-group">
			            <label class="col-md-3 control-label"></label>
			            <div class="col-md-8">
			              <input type="button" class="btn btn-primary" value="Save Changes">
			              <span></span>
			              <input type="reset" class="btn btn-default" value="Cancel">
			            </div>
			          </div>
			        </form> --%>
			      </div>
			  </div>
				<hr>	
			</div> <!--container -->
			<!-- footer -->
            <footer id="footer" class="text-center">
              <div class="container social">

                <div class="col-sm-12">                
                  <a href="#" class="icon-circle fb" target="_blank">
                    <img class="logo" alt="Facebook" src="${contextPath}/resources/social/facebook_transparent-1c6a690dcde061958f50f712404c764613cc193d3f69e81734c8c9a7f36131e4.png" />
                  </a>

                  <a href="#" class="icon-circle tw" target="_blank">
                    <img class="logo" alt="Twitter" src="${contextPath}/resources/social/twitter_transparent-39f60ddc31bce0d3e3d6ae72af7fbe74dc95e01b7d7a6f66cc38efabda3bb6da.png" />
                  </a>

                  <a href="#" class="icon-circle gl" target="_blank">
                    <img class="logo" alt="Google Plus" src="${contextPath}/resources/social/gplus_transparent-fab632559c47bada047b0ff2cb7b8880a10836d08db04c7cdae2e3d3abe474e1.png" />
                  </a>

                    <a href="#" class="icon-circle pt" target="_blank">
                    <img class="logo" alt="Pinterest" src="${contextPath}/resources/social/pinterest_transparent-a58a9baa98ec9a2e4fed6d4ab7ffdb69bc607c82649a486544b2b5dab03364ef.png" />
                   </a>
                </div>

              </div><!--social-->

              <p id="copyright">&copy; 2018 Team RantRoom. All rights reserved | Designed by <a href="http://www.khansaad.com/" target="_blank" >Saad </a>| Mentored by <a href="http://www.roosnam.com/" target="_blank" >Mansoor</a></p>
        </footer>
		</div> <!--main -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="${contextPath}/resources/js/bootstrap-filestyle.min.js"> </script>
	</body>
</html>