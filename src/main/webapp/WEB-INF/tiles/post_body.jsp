<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<img src="${appContextPath}/resources/upload/${post.imageName}" class="img-responsive" style="width: 100%"/>
<br />
<div class="row">
    <div class="col-md-6 text-center">
        <div class="well">Dodany przez <a href="${appContextPath}/user/${post.poster.id}">${post.poster.name}</a></div>
    </div>
    <div class="col-md-6">
        <div class="well text-center">Data dodania : ${post.dateOfPublish}</div>
    </div>
</div>
<div class="well text-justify">
    ${post.text}
</div>
<hr />
<div class="row">
    <div class="col-md-8 text-center">
        <h4>Komentarze ( ${comments.size()} ) :</h4>
    </div>
    <div class="col-md-4 text-center">
        <c:choose>
            <c:when test="${isUserLogged}">
                <button id="addCommentButton" class="btn btn-primary center-block" onclick="showAddCommentForm()">Dodaj komentarz</button>
            </c:when>
            <c:otherwise>Musisz być zalogowany aby dodawać komentarze</c:otherwise>
        </c:choose>
    </div>
</div>
<hr />
<div id="addCommentForm" class="well" style="display: none">
    <form:form modelAttribute="comment" cssClass="form-horizontal" method="POST">
        <form:textarea path="text" cssClass="form-control" cssStyle="resize: none; height: 100px" placeholder="Treść komentarza" />
        <input type="submit" class="btn btn-primary" value="Dodaj" />
    </form:form>
</div>

    <table class="table table-striped">
        <c:forEach var="comment" items="${comments}">
        <tr>
            <td class="text-center center-block col-md-2">
                <img src="${appContextPath}/resources/upload/${comment.publisher.imageName}" class="img-responsive img-circle center-block" style="height: 50px; width: 50px"/>
                <br />
                <a href="${appContextPath}/user/${comment.publisher.id}">${comment.publisher.name}</a>
            </td>
            <td class="text-justify col-md-10">
                ${comment.dateOfPublish}
                 <hr />
                ${comment.text}
            </td>
        </tr>
        </c:forEach>
    </table>
 
