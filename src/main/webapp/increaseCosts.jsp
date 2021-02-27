<%@include file="fragments/locale.jsp"%>
<html>
<head>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">

    <title>Title</title>
</head>
<body>
<div class="container">
    <%@include file="fragments/navbar.jsp"%>
<form method="POST" >
    <h2><fmt:message key="increaseCost.label"/></h2>
    <c:if test="${!empty requestScope.increaseException}">
        <div class="alert-danger error-message" >
            <fmt:message key="cardCreation.error" />
        </div>
    </c:if>
    <label><fmt:message key="inputCosts.account"/></label>
    <c:if test="${!empty requestScope.invalidCosts}">
        <div class="alert-danger error-message" >
            <fmt:message key="field.incorrect" />
        </div>
    </c:if>
    <input type="number" class="form-control" name="costs"/>
    <button type="submit" class="btn btn-primary btn-block btn-lg"><fmt:message key="submit.button"/></button>
</form>
</div>
</body>
</html>
