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
<a href="/accounts/cards/add-card?account_id=${account_id}"><fmt:message key="card.list"/></a>
<table>
    <tr>
        <th >  <fmt:message key="account.number" /></th>
        <th >  <fmt:message key="card.endDate" /></th>
        <th>  <fmt:message key="card.type" /></th>
    </tr>
    <c:forEach items="${cards}" var="d" >
        <tr>
            <td>${d.number}</td>
            <td>${d.endDate}</td>
            <td>${d.cardType}</td>
        </tr>
    </c:forEach>
</table>
</div>
</body>
</html>
