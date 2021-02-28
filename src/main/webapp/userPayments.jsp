<%@include file="fragments/locale.jsp"%>
<html>
<head>
    <title>Title</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
</head>
<body>
<div class="container">
    <%@include file="fragments/navbar.jsp"%>
    <table class="table">
        <tr>
            <th >  <fmt:message key="time.userPayment" /></th>
            <th >  <fmt:message key="account.costs" /></th>
            <th>  <fmt:message key="purpose.payments" /></th>
            <th>  <fmt:message key="cardNumber.userPayment" /></th>
        </tr>
        <c:forEach items="${userPayments}" var="d" >
            <tr>
                <td>${d.localDateTime}</td>
                <td>${d.costs}</td>
                <td>${d.payment.purpose}</td>
                <td>${d.creditCard.number}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
