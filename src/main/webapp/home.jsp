<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<fmt:setBundle basename="messages"/>
<head>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">

    <title>Title</title>
</head>
<body>
<div class="container">
<%@include file="fragments/navbar.jsp"%>
<table>
    <tr>
        <th >  <fmt:message key="property.payments" /></th>
        <th >  <fmt:message key="purpose.payments" /></th>
    </tr>
    <c:forEach items="${payments}" var="d" >
        <tr>
            <td>${d.property}</td>
            <td>${d.purpose}</td>
        </tr>
    </c:forEach>
</table>
</div>
</body>
</html>