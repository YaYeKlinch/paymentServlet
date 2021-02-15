
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<html>
<fmt:setBundle basename="messages"/>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <div class="signup-form">
        <form method="POST">
            <h2><fmt:message key="registration.label"/></h2>
            <c:if test="${!empty requestScope.registrationError}">
                <div class="alert-danger error-message" >
                    <fmt:message key="registration.error" />
                </div>
            </c:if>
            <div class="form-group">
                <label><fmt:message key="registration.firstName"/></label>
                <c:if test="${!empty requestScope.nameEmpty}">
                    <div class="alert-danger error-message" >
                        <fmt:message key="field.empty" />
                    </div>
                </c:if>
                <c:if test="${!empty requestScope.nameWrong}">
                    <div class="alert-danger error-message" >
                        <fmt:message key="field.incorrect" />
                    </div>
                </c:if>
                <input type="text" class="form-control" name="firs_name"  value="${values.firs_name}"/>
            </div>
            <div class="form-group">
                <label><fmt:message key="registration.lastName"/></label>
                <c:if test="${!empty requestScope.surnameEmpty}">
                    <div class="alert-danger error-message" >
                        <fmt:message key="field.empty" />
                    </div>
                </c:if>
                <c:if test="${!empty requestScope.surnameWrong}">
                    <div class="alert-danger error-message" >
                        <fmt:message key="field.incorrect" />
                    </div>
                </c:if>
                <input type="text" class="form-control" name="last_name" required="required" value="${values.last_name}"/>
            </div>
            <div class="form-group">
                <label><fmt:message key="registration.email"/></label>
                <c:if test="${!empty requestScope.emailEmpty}">
                    <div class="alert-danger error-message" >
                        <fmt:message key="field.empty" />
                    </div>
                </c:if>
                <c:if test="${!empty requestScope.emailWrong}">
                    <div class="alert-danger error-message" >
                        <fmt:message key="field.incorrect" />
                    </div>
                </c:if>
                <c:if test="${!empty requestScope.emailExists}">
                    <div class="alert-danger error-message" >
                        <fmt:message key="email.exists" />
                    </div>
                </c:if>
                <input type="email" class="form-control" name="username" required="required" value="${values.username}"/>

            </div>
            <div class="form-group">
                <label><fmt:message key="registration.password"/></label>
                <c:if test="${!empty requestScope.passwordEmpty}">
                    <div class="alert-danger error-message" >
                        <fmt:message key="field.empty" />
                    </div>
                </c:if>
                <c:if test="${!empty requestScope.passwordWrong}">
                    <div class="alert-danger error-message" >
                        <fmt:message key="field.incorrect" />
                    </div>
                </c:if>
                <input type="password" class="form-control" name="password" required="required" value="${values.password}"/>

            </div>
            <div class="form-group">
                <label><fmt:message key="registration.confirmPassword"/></label>
                <c:if test="${!empty requestScope.passwordsNotEqual}">
                    <div class="alert-danger error-message" >
                        <fmt:message key="password.matches.validation" />
                    </div>
                </c:if>
                <input type="password" class="form-control" name="confirmedPassword" required="required" value="${values.confirmedPassword}"/>

            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-block btn-lg"><fmt:message key="registration.signUp"/></button>
            </div>
    </div>
                <a href="/login"><fmt:message key="registration.loginLink"/></a></p>
        </form>
    </div>
</body>
</html>
