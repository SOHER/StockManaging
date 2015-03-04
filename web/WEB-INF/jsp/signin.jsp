<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
<!--        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">-->
<link href="../css/style.css" rel='stylesheet' type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--webfonts-->
<link href='http://fonts.googleapis.com/css?family=Oxygen:400,300,700' rel='stylesheet' type='text/css'>
<!--//webfonts-->
        <title>Inscription</title>
    </head>
    <body>
    <div class="main" style="padding-top: 0">


        <form:form modelAttribute="client" action="welcome.htm" method="POST">
               <div class="lable">
            <form:label cssClass="col_1_of_2 span_1_of_2" path="name">Nom:</form:label>
            <form:input path="name"/><br>
            <form:label cssClass="col_1_of_2 span_1_of_2" path="surname">Prenom:</form:label>
            <form:input path="surname"/><br>
            </div>
            <div class="lable">
            <form:label cssClass="col_1_of_2 span_1_of_2" path="mail">Mail:</form:label>
            <form:input path="mail"/><br>
            <form:label cssClass="col_1_of_2 span_1_of_2" path="password">Mot de passe:</form:label>
            <form:input path="password"/><br>
            </div>
            <div class="submit">
            <input class="submit" type="submit" value="Inscription"/>
            </div>
        </form:form>
                </div>
    </body>
</html>
