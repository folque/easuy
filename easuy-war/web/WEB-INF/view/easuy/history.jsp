<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:forEach items="${listHistory}" var="hist">
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
            <tr>
                <td>
                    ${hist.product.name}
                </td>
                <td>
                    ${hist.product.price}
                </td>
                <td>
                    ${hist.date}
                </td>
            </tr>
        </tbody>
    </table>
</c:forEach>