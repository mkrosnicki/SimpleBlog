<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="well">
    <h4>Panel logowania</h4>
    <c:url value="/j_spring_security_check" var="loginUrl" />
    <form class="form-horizontal" action="${loginUrl}" method="POST">
        <input type="text" name="username" class="form-control" placeholder="Nazwa użytkownika">
        <input type="password" name="password" class="form-control" id="password" placeholder="Twoje hasło">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <span class="input-group-btn">
            <input type="submit" class="btn btn-default" value="Zaloguj" >
        </span>
    </form>
    <c:if test="${error ne null}">
        <div class="alert alert-danger">${error}</div>
    </c:if>
    <c:if test="${message ne null}">
        <div class="alert alert-danger">${message}</div>
    </c:if>
</div>