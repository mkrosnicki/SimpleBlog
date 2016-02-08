<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="well">
    <form:form method="POST" enctype="multipart/form-data" cssClass="form-horizontal">
        <input name="image" type="file" />
        <br />
        <input type="submit" class="btn btn-default" />
    </form:form>
    <c:if test="${error ne null}">
        <br />
        <div class="alert alert-danger">${error}</div>
    </c:if>
</div>
