<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<table class="custom-table">
    <thead>
        <tr>
            <th>
                Name
            </th>
            <th>
                Price
            </th>
            <th/>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${listProducts}" var="prod">
            <form method="POST"> 
                <tr>
                    <td>${prod.name}<input type="hidden" name="prodId" value="${prod.id}"/></td>
                    <td>${prod.price}</td>
                    <td><input type="submit" value="Buy" /></td>
                </tr>
            </form>
        </c:forEach>
    </tbody>
</table>