    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="navbar-header">
    <a href="<c:url value="/home"/>" >
        <img class="a navbar-brand" src="${pageContext.request.contextPath}/resources/img/logo_small.png"/>
    </a>
        <a class="navbar-brand" href="<c:url value="/home"/>" >Easuy</a>
</div>
<div class="navbar-collapse collapse">
    <ul class="nav navbar-nav navbar-right">
                        <c:if test="${not empty pageContext.request.remoteUser}">
                            <li><a>${auth.loggedInUser}</a></li>
                            <li><a href="<c:url value="/logout" />" >Logout</a></li>
                        </c:if>
    <form class="navbar-form navbar-right">
        <input type="text" class="form-control" placeholder="Search..."/>
    </form>
</div>

