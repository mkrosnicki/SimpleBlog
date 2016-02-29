<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<br />
<br />

<!-- CONTENT -->
<div class="col-md-1"></div>

<div class="col-md-10">

    <!-- POST -->

    <div class="well" id="post" style="text-align: center">
        <hr />
        <h3>${post.title}</h3>
        <hr />
        <img src="${appContextPath}/resources/upload/${post.imageName}" class="img img-responsive" style="margin: 0px auto; width: 94%" />\
        <br />
        <div class="row">
            <div class="col-md-3">
                Autor : <a href="${appContextPath}/user/${post.poster.id}">${post.poster.name}</a>
            </div>
            <div class="col-md-9">
                Ostatnia edycja : ${post.dateOfPublish}
            </div>
        </div>
        <br />
        <p>
            ${post.text}
        </p>

        <hr />
        <div class="row">
            <div class="col-md-6">
            </div>
            <div class="col-md-6" >
                <c:choose>
                    <c:when test="${isUserLogged}">
                        <button class="btn btn-danger pull-right" id="addCommentButton">Dodaj komentarz</button>        
                    </c:when>
                    <c:otherwise>
                        <a href="${appContextPath}/login">Zaloguj się</a>, aby dodać komentarz.
                    </c:otherwise>
                </c:choose>

            </div>
        </div>
        <br />
        <div id="addcommentform" class="well" style="display: none">
            <form:form modelAttribute="comment" cssClass="form-horizontal">
                <form:textarea path="text" cssClass="form-control" cssStyle="resize: none; height: 100px" placeholder="Treść komentarza" />
                <br />
                <input type="submit" class="btn btn-success pull-right" value="Dodaj" />
                <br />
            </form:form>
        </div>

        <h4>Komentarze <span class="badge">${comments.size()}</span> </h4>
        <br />
        <br />

        <table class="table table-striped">

            <c:forEach items="${comments}" var="comment">

                <tr>
                    <td class="text-center center-block col-md-3">
                        <img src="${appContextPath}/resources/upload/${post.poster.imageName}" class="img img-circle" style="width: 40px; height: 40px;" />
                        <br />
                        <br />
                        <a href="${appContextPath}/user/${comment.publisher.id}">${comment.publisher.name}</a>
                    </td>
                    <td class="text-justify col-md-9">
                        ${comment.dateOfPublish}
                        <br />
                        <br />
                        ${comment.text}
                    </td>
                </tr>

            </c:forEach>

        </table>

    </div>


    <br />
</div>

<div class="col-md-1"></div>