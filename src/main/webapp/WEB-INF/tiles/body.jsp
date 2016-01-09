<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:forEach var="post" items="${posts}">
    <h1>${post.title}</h1>
    <p class="lead">
    <h5>Dodany przez <a href="<c:url value="/user/${post.poster.id}"/>">${post.poster.name}</a></h5>
</p>
<p><span class="glyphicon glyphicon-time"></span> ${post.dateOfPublish}</p>
<hr>
<img class="img-responsive" src="<c:url value="/resources/upload/${post.imageName}"/>" style="width: 100%; height: 200px">
<hr>
<a class="btn btn-primary" href="${appContextPath}/post/${post.id}">Zobacz posta  <span class="glyphicon glyphicon-chevron-right"></span></a>

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
