<%@include file="fragments/locale.jsp"%>
<html>
<head>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">

    <title>Title</title>
</head>
<body>
<div class="container">
<%@include file="fragments/navbar.jsp"%>
    <c:if test="${sessionScope.LoggedUser!=null}">
    <c:if test="${sessionScope.LoggedUser.role.name().equals('ADMIN')}">
    <a href="/add-payment"><fmt:message key="addPayment.link"/></a>
    </c:if>
    </c:if>
<table>
    <tr>
        <th >  <fmt:message key="property.payments" /></th>
        <th >  <fmt:message key="purpose.payments" /></th>
    </tr>
    <c:forEach items="${payments}" var="d" >
        <tr>
            <td>${d.property}</td>
            <td>${d.purpose}</td>
            <c:if test="${sessionScope.LoggedUser!=null}">
            <td><a href="/make-payment?payment_id=${d.id}"><fmt:message key="makePayment.label"/></a></td>
            </c:if>
        </tr>
    </c:forEach>
</table>
</div>
</body>
</html>