<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="col-md-4">
</div>
<div class="col-md-4">
    <div class="well" id="register">
        <p class="text-center">
            <img src="${appContextPath}/resources/img/logo_500.png" class="img img-responsive">
        </p>
        <hr>
        <form:form modelAttribute="password" method='POST' cssStyle="min-height: 100px;">
            <div class="input-group">
                <form:input path="oldPassword" type="password" cssClass="form-control" placeholder="Stare hasło" aria-describedby="basic-addon1" />
                <span class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></span>
            </div>
            <br />
            <div class="input-group">
                <form:input path="newPassword" type="password" cssClass="form-control" placeholder="Nowe hasło" aria-describedby="basic-addon2" />
                <span class="input-group-addon" id="basic-addon2"><span class="glyphicon glyphicon-lock" aria-hidden="true"></span></span>
            </div>
            <br />
            <div class="input-group">
                <form:input path="newPasswordRepeat" type="password" cssClass="form-control" placeholder="Repeat password" aria-describedby="basic-addon2" />
                <span class="input-group-addon" id="basic-addon2"><span class="glyphicon glyphicon-lock" aria-hidden="true"></span></span>
            </div>
            <br />
            <input type="submit" class="btn btn-danger" style="width: 100%" value="Zmień hasło" />
        </form:form>
        <c:if test="${changePassError ne null}">
            <div class="alert alert-danger text-center">${changePassError}</div>
        </c:if>
    </div>
</div>
<div class="col-md-4">
</div>