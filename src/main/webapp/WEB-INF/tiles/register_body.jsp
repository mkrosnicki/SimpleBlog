<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="well">
    <h4>Panel rejestracji nowego użytkownika</h4>
    <form:form modelAttribute="user" cssClass="form-horizontal" enctype="multipart/form-data">
        <form:input type="text" path="name" placeholder="Nazwa użytkownika" cssClass="form-control"/>
        <form:input type="password" path="password" placeholder="Hasło" cssClass="form-control"/>
        <form:input type="password" path="repeatPassword" placeholder="Powtórz hasło" cssClass="form-control"/>
        <form:input name="image" cssClass="" type="file" path="image"/>
        <span class="input-group-btn">
            <input type="submit" class="btn btn-default" value="Zarejestruj" >
        </span>
        <br />
        <c:if test="${registerError ne null}">
            <div class="alert alert-danger">
                ${registerError}
                <br />
                <form:errors path="name" />
                <br />
                <form:errors path="password" />
            </div>
        </c:if>
    </form:form>
</div>