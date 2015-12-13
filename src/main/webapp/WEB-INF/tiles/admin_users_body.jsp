<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="well">
    <h4>Panel admina</h4>
    Jesteś zalogowany jako : <b>${pageContext.request.userPrincipal.name}</b>
    <br />
</div>
<div class="well">
    <table class="table">
        <thead>
            <tr>
                <th>ID</th>
                <th>Imię</th>
                <th>Uprawnienia</th>
                <th>Status konta</th>
                <th>Ilość postów</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td><c:forEach var="role" items="${user.roles}">
                            <c:if test="${role.authority == 'ROLE_ADMIN'}">ADMIN<br /></c:if>
                            <c:if test="${role.authority == 'ROLE_USER'}">USER<br /></c:if>
                        </c:forEach></td>
                    <td>
                        <c:choose>
                            <c:when test="${user.enabled}">Aktywne</c:when>
                            <c:otherwise>Nieaktywne</c:otherwise>
                        </c:choose>
                    </td>
                    <td>${user.roles.size()}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
