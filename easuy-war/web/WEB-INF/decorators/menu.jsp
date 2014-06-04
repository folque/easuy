<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
    <ul class="nav nav-sidebar">
    
    <c:choose>
        <c:when test="${not empty pageContext.request.remoteUser}">
            <li><a href="${pageContext.request.contextPath}/home">Home</a></li>
            <li class="active"><a href="${pageContext.request.contextPath}/easuy/category">Shop</a></li>
            <li><a href="${pageContext.request.contextPath}/easuy/log">Log</a></li>
        </c:when>
        <c:otherwise>
            <%@ include file="/WEB-INF/view/login/login.jsp"%>
         </c:otherwise>
    </c:choose>
</ul>