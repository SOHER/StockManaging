<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <title>Login</title>
    </head>
    <body>
        <h1 class="text">Gestion des employés</h1>

        <div  class="main">

            <table style="color:#FFF " width="100%" border="1" align="center" cellpadding="2" cellspacing="2">
    <tr>
        <td Class="text">Name</td>
        <td Class="text">Surname</td>
    </tr>   
            <c:forEach var="i" items="${lEmployees}">

    <tr>  
            <td class="tdstyle"><c:out value="${i.name}"/></td>
            <td class="tdstyle"><c:out value="${i.surname}"/></td>
        <td class="tdstyle">            
            <div class="submit">
                       <a class="submit" href="<%=request.getContextPath()%>/user/managingEmployee/modifyEmployee.htm?id=${i.idEmployee}">Modifier</a>
            </div>
        </td>
    </tr>
                </c:forEach>

</table> 
</div>
    </body>
</html>
