<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:forEach items="${logList}" var="logs">
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
            <tr>
                <td>
                    <fmt:formatDate value="${logs.userLogPK.date}" pattern="yyyy-MM-dd HH:mm" />
                </td>
                <td>
                    ${logs.userLogPK.type}
                </td>
            </tr>
        </tbody>
    </table>
</c:forEach>