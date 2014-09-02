<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
    <ul class="nav nav-sidebar">
    
    <c:choose>
        <c:when test="${not empty pageContext.request.remoteUser}">
            <li><a href="<c:url value="/home" />" >Home</a></li>
            <li><a href="<c:url value="/easuy/category" />" >Shop</a></li>
            <li><a href="<c:url value="/easuy/log" />" >Log</a></li>
            <li><a href="<c:url value="/easuy/cart" />" >Cart</a></li>
            <li><a href="<c:url value="/easuy/history" />" >History</a></li>
        </c:when>
        <c:otherwise>
            <%@ include file="/WEB-INF/view/login/login.jsp"%>
         </c:otherwise>
    </c:choose>
</ul>