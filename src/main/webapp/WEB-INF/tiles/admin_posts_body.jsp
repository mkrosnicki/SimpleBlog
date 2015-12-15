<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="well">
    <h4>Panel admina</h4>
    Jesteś zalogowany jako : <b>${pageContext.request.userPrincipal.name}</b>
    <br />
</div>
<div class="well">
    <h4>Lista postów</h4>
    <table class="table">
        <thead>
            <tr>
                <th>ID</th>
                <th>Tytuł</th>
                <th>Ilość komentarzy</th>
                <th>Dodany przez</th>
                <th>Edycja</th>
                <th>Usuń</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="post" items="${posts}">
                <tr>
                    <td>${post.id}</td>
                    <td>${post.title}</td>
                    <td>${post.comments.size()}</td>
                    <td>${post.poster.name}</td>
                    <td><a href="delete/${post.id}">Usuń</a></td>
                    <td><a href="edit?id=${post.id}">Edytuj</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
