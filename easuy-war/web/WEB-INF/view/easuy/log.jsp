<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    <table class="custom-table">
        <thead>
            <tr>
                <th>
                    Date
                </th>
                <th>
                    Action
                </th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${logList}" var="logs">
                <tr>
                    <td>
                        <fmt:formatDate value="${logs.date}" pattern="yyyy-MM-dd HH:mm" />
                    </td>
                    <td>
                        ${logs.type}
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>