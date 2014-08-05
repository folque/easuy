<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<form method='POST'>
    <table>
        <tr>
            <td class="table-login-cell">
                Email
            </td>
            <td class="table-login-cell">
                <input type="email" id="email" value="${register.email}" required="true" name="email" />
            </td>
        </tr>
        <tr>
            <td class="table-login-cell">
                Repeat e-mail
            </td>
            <td class="table-login-cell">
                <input type="email" id="confirmEmail" value="${register.confirmEmail}" required="true"/>
            </td>
        </tr>
        <tr>
            <td class="table-login-cell">
                Password
            </td>
            <td class="table-login-cell">
                <input type="password" id="password" value="${register.password}"
                       required="true" name='password' />
            </td>
        </tr>
        <tr>
            <td class="table-login-cell">
                Repeat password
            </td>
            <td class="table-login-cell">
                <input type="password" id="confirmPassword" value="${register.confirmPassword}"
                       required="true" />
            </td>
        </tr>
        <tr>
            <td class="table-login-cell" colspan="2">
                <input type="submit" value="Register" name="register" />
                <input type="reset" value="Reset" />
        </td>
        </tr>
    </table>
</form>