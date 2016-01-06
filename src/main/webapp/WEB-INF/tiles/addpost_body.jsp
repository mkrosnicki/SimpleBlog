<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="well">
    <ul class="nav nav-pills nav-stacked ">
        <h4>Dodaj nowego posta</h4>
        <form:form modelAttribute="post" cssClass="form-horizontal" enctype="multipart/form-data">
            <form:input type="text" path="title" cssClass="form-control" placeholder="Tytuł posta"/>
            <form:textarea  path="text" cssClass="form-control" cssStyle="resize: none; height: 300px" placeholder="Treść posta"/>
            <div class="form-inline">
                <form:input name="image" cssClass="" type="file" path="image"/>      
            </div>

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
        <c:if test="${message != null}">
            <span class="alert alert-success">
                ${message}
            </span>
        </c:if>
    </ul>
</div>
