<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<table class="custom-table">
    <thead>
        <tr>
            <th>
                Product
            </th>
            <th>
                Price
            </th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${listUserProducts}" var="userProd">
            <tr>
                <td>
                    ${userProd.product.name}
                </td>
                <td>
                    ${userProd.product.price}
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<c:if test="${not empty listUserProducts}">
    <form name="userProdForm" method="POST">
        <input type="submit" value="Purchase" />
    </form>
</c:if>
<c:if test="${empty listUserProducts}">
    Your cart is empty
</c:if>