<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<table>
    <c:forEach items="${listCategories}" var="cat" varStatus="iteration">
        <tr>
            <td>
                <form name="categoryForm" method="POST">
                    <input type="hidden" value="${cat.id}" name="catId"/>
                    <input type="hidden" value="${cat.name}" name="catName"/>
                    <a onclick="document.getElementsByName('categoryForm')[${iteration.index}].submit(); return false;" 
                   href="<c:url value='/easuy/category' />">${cat.name}</a>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>