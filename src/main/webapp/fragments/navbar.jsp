<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<nav  class="navbar navbar-expand-lg ">
    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
    <li class="nav-item">
        <a class="nav-link" href="/"><fmt:message key="home.tab"/></a>
    </li>
        <c:if test="${sessionScope.LoggedUser!=null}">
    <li class="nav-item">
        <a class="nav-link" href="/accounts"><fmt:message key="accounts.tab"/></a>
    </li>
            <li class="nav-item">
                <a class="nav-link" href="/user-payment"><fmt:message key="userPayments.tab"/></a>
            </li>
     <li class="nav-item">
         <a class="nav-link" href="/logout"><fmt:message key="logout.tab"/></a>
      </li>

        </c:if>
        <c:if test="${sessionScope.LoggedUser==null}">
        <li class="nav-item">
            <a class="nav-link" href="/login-page"><fmt:message key="login.tab"/></a>
        </li>
        </c:if>
    </ul>
</nav>