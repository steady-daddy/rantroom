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

        <title>Signup - RantRoom</title>

        <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
        <link href="${contextPath}/resources/css/style.css" rel="stylesheet">
        <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
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
        <div class="container">
            <div class="row">
                <div class="col-sm-4 col-sm-offset-4">
                    <h2 class="home-h2">Welcome to RantRoom</h2>
                </div>
            </div>
            <!--signin-form-->
            <div class="row">
                <div class="col-sm-4 col-sm-offset-4">
                    <div class="form-body">
                        <h3>Register</h3>

                        <div class="login-form">
                            <form:form method="POST" modelAttribute="userForm">
                                <div>
                                    <label>USERNAME:</label>
                                    <spring:bind path="username">
                                        <div class="form-group ${status.error ? 'has-error' : ''}">
                                            <form:input type="text" path="username" class="form-control" autofocus="true"></form:input>
                                            <form:errors path="username"></form:errors>
                                        </div>
                                    </spring:bind>
                                </div>
                                <div>
                                    <label>FIRST NAME:</label>
                                    <spring:bind path="firstname">
                                        <div class="form-group ${status.error ? 'has-error' : ''}">
                                            <form:input type="text" path="firstname" class="form-control" autofocus="true"></form:input>
                                            <form:errors path="firstname"></form:errors>
                                        </div>
                                    </spring:bind>
                                </div>
                                <div>
                                    <label>LAST NAME:</label>
                                    <spring:bind path="lastname">
                                        <div class="form-group ${status.error ? 'has-error' : ''}">
                                            <form:input type="text" path="lastname" class="form-control" autofocus="true"></form:input>
                                        </div>
                                    </spring:bind>
                                </div>
                                <div>
                                    <label>EMAIL:</label>
                                    <spring:bind path="email">
                                        <div class="form-group ${status.error ? 'has-error' : ''}">
                                            <form:input type="text" path="email" class="form-control" autofocus="true"></form:input>
                                            <form:errors path="email"></form:errors>
                                        </div>
                                    </spring:bind>
                                </div>
                                <div>
                                    <label>PASSWORD:</label>
                                    <spring:bind path="password">
                                        <div class="form-group ${status.error ? 'has-error' : ''}">
                                            <form:input type="password" path="password" class="form-control"></form:input>
                                            <form:errors path="password"></form:errors>
                                        </div>
                                    </spring:bind>
                                </div>
                                <div>
                                    <label>CONFIRM PASSWORD:</label>
                                    <spring:bind path="passwordConfirm">
                                        <div class="form-group ${status.error ? 'has-error' : ''}">
                                            <form:input type="password" path="passwordConfirm" class="form-control"></form:input>
                                            <form:errors path="passwordConfirm"></form:errors>
                                        </div>
                                    </spring:bind>
                                </div>    
                                <button type="submit">Sign up</button>
                            </form:form>                            
                        </div><!--log-in-form-->
                        <h4 class="text-center" style="font-size: 12px;margin-top: 30px"><a href="${contextPath}/login">Already a Member?</a></h4>
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
