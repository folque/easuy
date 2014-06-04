<%@page contentType="text/html" pageEncoding="UTF-8"%>
<form method="POST" action="j_security_check">
    <table>
        <tr>
            <td class="table-login-cell">Username:</td>
            <td class="table-login-cell"><input type="text" name="j_username" /></td>
        </tr>
        <tr>
            <td class="table-login-cell">Password:</td>
            <td class="table-login-cell"><input type="password" name="j_password" /></td>
        </tr>
        <tr>
            <td class="table-login-cell"><input type="submit" value="Login" /></td>
            <td class="table-login-cell"><input type="reset" value="Reset" /></td>
        </tr>
    </table>
</form>
<h:form>
    <a href="${pageContext.request.contextPath}/WEB-INF/view/login/register.xhtml">Register</a>
</h:form>