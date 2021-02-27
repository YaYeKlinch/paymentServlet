<%@include file="fragments/locale.jsp"%>
<html>
<head>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">

    <title>Title</title>
</head>
<body>
<div class="container">
    <%@include file="fragments/navbar.jsp"%>
<a href="/accounts/add-account"><fmt:message key="addAccount.link"/></a>
<table>
    <tr>
        <th >  <fmt:message key="account.name" /></th>
        <th >  <fmt:message key="account.number" /></th>
        <th>  <fmt:message key="account.costs" /></th>
    </tr>
    <c:forEach items="${accounts}" var="d" >
        <tr>
            <td>${d.name}</td>
            <td>${d.number}</td>
            <td>${d.costs}</td>
            <td><a href="/accounts/cards?account_id=${d.id}"><fmt:message key="card.list"/></a> </td>
            <td><a href="/accounts/increase-costs?account_id=${d.id}"><fmt:message key="increaseCost.label"/></a> </td>
        </tr>
    </c:forEach>
</table>
</div>
</body>
</html>
