<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="col-md-3">
</div>
<div class="col-md-6">
    <div class="well" id="addpost">
        <div>

            <center><h4>Dodaj nowego posta</h4></center>
            <hr />
            <form:form modelAttribute="post" action="addpost?${_csrf.parameterName}=${_csrf.token}" cssClass="form-horizontal">
                <form:input type="text" path="title" cssClass="form-control" placeholder="Tytuł posta" />
                <form:textarea path="text" cssClass="form-control" cssStyle="resize: none; height: 300px" placeholder="Treść posta"/>
                <br />
                <input type="submit" class="btn btn-success" style="width: 100%" value="Dodaj" />
                <c:if test="${pageContext.request.method == 'POST'}">
                    <div class="alert alert-danger">
                        <form:errors path="title" />
                        <form:errors path="text" />
                    </div>
                </c:if>
            </form:form>

        </div>
    </div>
</div>
<div class="col-md-3">
</div>
