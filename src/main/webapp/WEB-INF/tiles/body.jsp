<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:forEach var="post" items="${posts}">
    <h2>${post.title}</h2>
    <p class="lead">
        by <a href="index.php">${post.poster.name}</a>
    </p>
    <p><span class="glyphicon glyphicon-time"></span> Posted on August ${post.dateOfPublish}</p>
    <hr>
    <img class="img-responsive" src="http://placehold.it/900x300" alt="">
    <hr>
    <p>${post.text}</p>
    <a class="btn btn-primary" href="#">Read More <span class="glyphicon glyphicon-chevron-right"></span></a>

    <hr>
</c:forEach>

<!-- Pager -->
<ul class="pager">
    <li class="previous">
        <a href="#">&larr; Older</a>
    </li>
    <li class="next">
        <a href="#">Newer &rarr;</a>
    </li>
</ul>
