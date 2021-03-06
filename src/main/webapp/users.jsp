<%@include file="fragments/locale.jsp"%>
<html>

<head>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <title>Title</title>
</head>
<body>
<div class="container">
    <%@include file="fragments/navbar.jsp"%>
    <a href="/accounts/cards/add-card?account_id=${account_id}"><fmt:message key="card.list"/></a>
        <table class="table">
            <tr>
                <th >  <fmt:message key="registration.firstName" /></th>
                <th >  <fmt:message key="registration.lastName" /></th>
                <th>  <fmt:message key="text.email" /></th>
                <th>  <fmt:message key="user.role" /></th>
                <th>  <fmt:message key="user.active" /></th>
            </tr>
            <c:forEach items="${users}" var="d" >
                <tr>
                    <td>${d.firs_name}</td>
                    <td>${d.last_name}</td>
                    <td>${d.username}</td>
                    <td>${d.role}</td>
                    <td>${d.active}</td>
                    <td>
                        <a class="btn btn-outline-primary" href="/users/change-permission?user_id=${d.id}">
                            <c:choose>
                            <c:when test="${d.active}">
                                <fmt:message key="ban.button"/>
                            </c:when>
                            <c:otherwise>
                                <fmt:message key="unblock.button"/>
                            </c:otherwise>
                            </c:choose>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
</div>
</body>
</html>
