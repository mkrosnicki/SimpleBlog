<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="well">
    <h4>Panel admina</h4>
    Jesteś zalogowany jako : <b>${pageContext.request.userPrincipal.name}</b>
    <br />
</div>
<div class="well">
    <ul class="nav nav-pills nav-stacked ">
        <h4>Dodaj nowego posta</h4>
        <form:form modelAttribute="post" cssClass="form-horizontal">
            <form:input type="text" path="title" cssClass="form-control" placeholder="Tytuł posta"/><form:errors path="title" />
            <form:textarea  path="text" cssClass="form-control" cssStyle="resize: none; height: 300px" placeholder="Treść posta"/><form:errors path="text" />
            <span class="btn-group">
                <input type="submit" class="btn btn-default" value="Dodaj"/>
            </span>
            <c:if test="${pageContext.request.method == 'POST'}">
                <div class="alert alert-danger">
                    <form:errors path="title" />
                    <form:errors path="text" />
                </div>
            </c:if>
        </form:form>
    </ul>
</div>
