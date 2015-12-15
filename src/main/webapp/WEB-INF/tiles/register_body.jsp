<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="well">
    <h4>Panel rejestracji nowego użytkownika</h4>
    <form:form modelAttribute="user" cssClass="form-horizontal">
        <form:input type="text" path="name" placeholder="Nazwa użytkownika" cssClass="form-control"/>
        <form:input type="password" path="password" placeholder="Hasło" cssClass="form-control"/>
        <span class="input-group-btn">
            <input type="submit" class="btn btn-default" value="Zarejestruj" >
        </span>
        <br />
        <c:if test="${pageContext.request.method == 'POST'}">
            <div class="alert alert-danger">
                <form:errors path="name" />
                <form:errors path="password" />
                <c:if test="${message != null}">${message}</c:if>
                </div>
        </c:if>
    </form:form>
</div>