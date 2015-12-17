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
        <h4>Edytuj posta</h4>
        <form:form modelAttribute="posttoedit" cssClass="form-horizontal">
            <form:input type="text" path="title" cssClass="form-control" placeholder="Tytuł posta"/>
            <form:textarea  path="text" cssClass="form-control" cssStyle="resize: none; height: 300px" placeholder="Treść posta"/>
            <span class="btn-group">
                <input type="submit" class="btn btn-default" value="Edytuj"/>
            </span>
            <c:if test="${pageContext.request.method == 'POST'}">
                <div class="alert alert-danger">
                    <form:errors path="title" />
                    <form:errors path="text" />
                </div>
            </c:if>
        </form:form>
        <c:if test="${message != null}">
            <div class="alert alert-success">
                ${message}
            </div>
        </c:if>
    </ul>
</div>
