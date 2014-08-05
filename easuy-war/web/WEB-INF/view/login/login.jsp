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
    <a href='<c:url value="/login/register"/>' >Register</a>
</h:form>