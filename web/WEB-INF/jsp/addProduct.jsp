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
        <title>Inscription</title>
    </head>
    <body>
    <div class="main" style="padding-top: 0">


        <form:form modelAttribute="productNew" action="products.htm" method="POST">
               <div class="lable">

            <form:label cssClass="col_1_of_2 span_1_of_2" path="label">Label:</form:label>
            <form:input path="label"/><br>
            <form:label cssClass="col_1_of_2 span_1_of_2" path="price">Prix:</form:label>
            <form:input path="price"/><br>
            </div>
            <div class="lable">
            <form:label cssClass="col_1_of_2 span_1_of_2" path="supplier">Fournisseur</form:label>
            <form:input path="supplier"/><br>
            <form:label cssClass="col_1_of_2 span_1_of_2" path="categorySet">Category:</form:label>
            <form:select  cssClass="lable" itemLabel="label" itemValue="idCategory" items="${lCats}" path="categorySet"/>
            </div>
            <div class="lable">
            <form:label cssClass="col_1_of_2 span_1_of_2" path="productSize">Taille:</form:label>
            <form:input path="productSize"/><br>
            <form:label cssClass="col_1_of_2 span_1_of_2" path="color">Couleur:</form:label>
            <form:input path="color"/><br>
            </div>
            <div class="submit">
            <input class="submit" type="submit" value="Inscription"/>
            </div>
        </form:form>
                </div>
    </body>
</html>
