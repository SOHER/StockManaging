<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
<!--        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">-->
<link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet"/>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--webfonts-->
<link href='http://fonts.googleapis.com/css?family=Oxygen:400,300,700' rel='stylesheet' type='text/css'>
<!--//webfonts-->
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        <div class="main" >
		<form>
		   <div class="submit">
                       <a class="submit" href="<%=request.getContextPath()%>/user/login.htm">Se connecter</a>
		   </div>
		   <div class="submit">
                       <a class="submit" href="<%=request.getContextPath()%>/user/signin.htm">Créer un Compte</a>
		   </div>
		   <div class="clear"> </div>
		</form>
		<!-----//end-main---->
		</div>
		 <!-----start-copyright---->
   		<div class="copy-right">
			<p>Template by <a href="http://google.com">STORYK</a></p> 
		</div>

    </body>
</html>
