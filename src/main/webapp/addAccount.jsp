
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<html>
<fmt:setBundle basename="messages"/>
<head>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">

    <title>Title</title>
</head>
<body>
<div class="container">
    <%@include file="fragments/navbar.jsp"%>
<form method="POST">
    <h2><fmt:message key="addAccount.label"/></h2>
    <c:if test="${!empty requestScope.creationError}">
        <div class="alert-danger error-message" >
            <fmt:message key="creation.error" />
        </div>
    </c:if>
    <div class="form-group">
        <label><fmt:message key="account.name"/></label>
        <c:if test="${!empty requestScope.accountNameEmpty}">
            <div class="alert-danger error-message" >
                <fmt:message key="field.empty" />
            </div>
        </c:if>
        <input type="text" class="form-control" name="name"  value="${values.name}"/>
    </div>
    <div class="form-group">
        <label><fmt:message key="account.number"/></label>
        <c:if test="${!empty requestScope.numberEmpty}">
            <div class="alert-danger error-message" >
                <fmt:message key="field.empty" />
            </div>
        </c:if>
        <c:if test="${!empty requestScope.numberWrong}">
            <div class="alert-danger error-message" >
                <fmt:message key="field.incorrect" />
            </div>
        </c:if>
        <input type="text" class="form-control" name="number"  value="${values.number}"/>
    </div>
    <div class="form-group">
        <button type="submit" class="btn btn-primary btn-block btn-lg"><fmt:message key="submit.button"/></button>
    </div>
    <a href="/accounts"><fmt:message key="back.link"/></a>
</form>
</div>
</body>
</html>
