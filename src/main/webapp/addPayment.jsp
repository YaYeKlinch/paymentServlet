<%@include file="fragments/locale.jsp"%>
<html>
<head>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <title>Title</title>
</head>
<body>
<div class="container">
    <%@include file="fragments/navbar.jsp"%>
    <form method="POST">
        <h2><fmt:message key="addPayment.label"/></h2>
        <c:if test="${!empty requestScope.creationError}">
            <div class="alert-danger error-message" >
                <fmt:message key="paymentCreation.error" />
            </div>
        </c:if>
        <div class="form-group">
            <c:if test="${!empty requestScope.propertyWrong}">
                <div class="alert-danger error-message" >
                    <fmt:message key="property.error" />
                </div>
            </c:if>
            <c:if test="${!empty requestScope.PaymentExists}">
                <div class="alert-danger error-message" >
                    <fmt:message key="paymentExists.exception" />
                </div>
            </c:if>
            <input type="number" class="form-control" name="property" />
        </div>
        <div class="form-group">
            <c:if test="${!empty requestScope.purposeEmpty}">
                <div class="alert-danger error-message" >
                    <fmt:message key="field.empty" />
                </div>
            </c:if>
            <input type="text" class="form-control" name="purpose" />
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary btn-block btn-lg"><fmt:message key="submit.button"/></button>
        </div>
    </form>
</div>
</body>
</html>
