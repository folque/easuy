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
                <th>
                    Date of order
                </th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listHistory}" var="hist">
            <tr>
                <td>
                    ${hist.product.name}
                </td>
                <td>
                    ${hist.product.price}
                </td>
                <td>
                    <fmt:formatDate value="${hist.date}" pattern="yyyy-MM-dd HH:mm" />
                </td>
            </tr>
            </c:forEach>
        </tbody>
    </table>