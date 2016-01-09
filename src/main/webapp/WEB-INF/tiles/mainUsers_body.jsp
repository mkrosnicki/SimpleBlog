<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="well">
    <table class="table table-bordered table-striped text-center" style="vertical-align: middle;">
        <tr>
            <th>Awatar</th>
            <th>Imię</th>
            <th>Liczba komentarzy</th>
            <th>Ilość postów</th>
            <th>Data rejestracji</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td><img class="img-responsive img-circle center-block" src="${appContextPath}/resources/upload/${user.imageName}" style="width: 50px; height: 50px"></td>
                <td>${user.name}</td>
                <td>narazie brak</td>
                <td>narazie brak</td>
                <td>narazie brak</td>
            </tr>
        </c:forEach>
    </table>
</div>
