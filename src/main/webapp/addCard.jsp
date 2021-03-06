<%@include file="fragments/locale.jsp"%>
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
    <h2><fmt:message key="addCard.label"/></h2>
    <c:if test="${!empty requestScope.creationError}">
        <div class="alert-danger error-message" >
            <fmt:message key="cardCreation.error" />
        </div>
    </c:if>
    <select name="cardType">
        <c:forEach var="item" items="${types}">
            <option>${item}</option>
        </c:forEach>
    </select>
    <div class="form-group">
        <label><fmt:message key="card.pin"/></label>
        <c:if test="${!empty requestScope.pinEmpty}">
            <div class="alert-danger error-message" >
                <fmt:message key="field.empty" />
            </div>
        </c:if>
        <c:if test="${!empty requestScope.pinIncorrect}">
            <div class="alert-danger error-message" >
                <fmt:message key="field.incorrect" />
            </div>
        </c:if>
        <input type="number" class="form-control" name="pin"  value="${values.pin}"/>
    </div>
    <div class="form-group">
        <label><fmt:message key="card.confirmPin"/></label>
        <c:if test="${!empty requestScope.confirmPinEmpty}">
            <div class="alert-danger error-message" >
                <fmt:message key="field.empty" />
            </div>
        </c:if>
        <c:if test="${!empty requestScope.pinNotMatching}">
            <div class="alert-danger error-message" >
                <fmt:message key="card.pinNotMatch" />
            </div>
        </c:if>
        <input type="number" class="form-control" name="confirmPin"  value="${values.confirmPin}"/>
    </div>
    <div class="form-group">
        <button type="submit" class="btn btn-primary btn-block btn-lg"><fmt:message key="submit.button"/></button>
    </div>
</form>
</div>
</body>
</html>
