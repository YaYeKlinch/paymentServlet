<%@include file="fragments/locale.jsp"%>
<html>
<head>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">

    <title>Title</title>
</head>
<body>
<div class="container">
    <%@include file="fragments/navbar.jsp"%>
    <h2><fmt:message key="makePayment.label"/></h2>
    <form method="POST">
    <c:if test="${!empty requestScope.paymentEx}">
        <div class="alert-danger error-message" >
            <fmt:message key="makePayment.error" />
        </div>
    </c:if>
    <c:if test="${!empty requestScope.CardNotFind}">
        <div class="alert-danger error-message" >
            <fmt:message key="findCard.error" />
        </div>
    </c:if>
    <c:if test="${!empty requestScope.PinNotMatch}">
        <div class="alert-danger error-message" >
            <fmt:message key="card.pinNotMatch" />
        </div>
    </c:if>
        <label><fmt:message key="account.number"/></label>
        <input type="number" class="form-control" name="number"  />
        <label><fmt:message key="card.pin"/></label>
        <input type="number" class="form-control" name="pin"  />
        <label><fmt:message key="account.costs"/></label>
        <input type="number" class="form-control" name="costs"  />
        <div class="form-group">
            <button type="submit" class="btn btn-primary btn-block btn-lg"><fmt:message key="submit.button"/></button>
        </div>
    </form>
</div>
</body>
</html>
