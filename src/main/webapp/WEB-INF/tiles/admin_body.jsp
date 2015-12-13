<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="well">
    <h4>Panel admina</h4>
    Jesteś zalogowany jako : <b>${pageContext.request.userPrincipal.name}</b>
    <br />
</div>
<div class="well">
    <ul class="nav nav-pills nav-stacked ">
        <li role="presentation"><a href="admin/users">Pokaż użytkowników</a></li>
        <li role="presentation"><a href="admin/addpost">Dodaj posta</a></li>
        <li role="presentation"><a href="admin/showposts">Pokaż moje posty</a></li>
    </ul>
</div>
