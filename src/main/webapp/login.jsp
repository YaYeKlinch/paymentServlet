<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<fmt:setBundle basename="messages"/>
<head>
    <title>Title</title>
</head>
<body>
<form method="POST" >

    <c:if test="${!empty requestScope.requestedUrl}">
        <input type="hidden" name="requestedUrl" value="${requestScope.requestedUrl}">
    </c:if>
    <div class="form-group">
        <input type="text" name="email" class="form-control" placeholder="<fmt:message key="text.email" />" value="" />
    </div>
    <div class="form-group">
        <input type="password" name="password" class="form-control" placeholder="<fmt:message key="text.password" />" value="" />
    </div>
    <div class="form-group">
        <input type="submit" class="form-control"  value="<fmt:message key="login.button" />" />
    </div>
    <p class="text-center"><fmt:message key="login.registrationInvitation"/>
        <a href="/registration"><fmt:message key="login.registrationLink"/></a></p>
</form>
</body>
</html>