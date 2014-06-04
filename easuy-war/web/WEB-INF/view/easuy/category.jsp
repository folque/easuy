<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<table>
    <c:forEach items="${listCategories}" var="cat">
        <tr>
            <td><a href="<c:url value='/easuy/category/${cat.id}' />">${cat.name}</a></td>
        </tr>
    </c:forEach>
</table>