<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="well">
    <h4>Panel rejestracji nowego użytkownika</h4>
    <form:form modelAttribute="user" cssClass="form-horizontal">
        <form:input type="text" path="name" placeholder="Nazwa użytkownika" /><form:errors path="name" />
        <form:input type="text" path="password" placeholder="Hasło" /><form:errors path="password" />
        <form:button>Zarejestruj</form:button>
    </form:form>
    <c:if test="${message != null}">${message}</c:if>
</div>