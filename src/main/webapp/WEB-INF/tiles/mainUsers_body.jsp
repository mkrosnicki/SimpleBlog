<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="well">
    <table class="table table-bordered table-striped text-center" style="vertical-align: middle;">
        <tr class="text-primary">
            <td>Awatar</td>
            <td>Imię</td>
            <td>Liczba komentarzy</td>
            <td>Ilość postów</td>
            <td>Data rejestracji</td>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td><img class="img-responsive img-circle center-block" src="${appContextPath}/resources/upload/${user.imageName}" style="width: 50px; height: 50px"></td>
                <td><a href="${appContextPath}/user/${user.id}">${user.name}</a></td>
                <td>${user.comments.size()}</td>
                <td>${user.posts.size()}</td>
                <td>brak</td>
            </tr>
        </c:forEach>
    </table>
</div>
