<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<div class="col-md-4">
</div>
<div class="col-md-4">
    <div class="well" id="login">
        <div>
            <p class="text-center">
                <img src="${appContextPath}/resources/img/logo_500.png" class="img img-responsive">
            </p>
            <hr>
            <c:url value="/login" var="loginUrl" />
            <form name='loginForm' action="${loginUrl}" method='POST'>
                <div class="input-group">
                    <input type="text" name="username" class="form-control" placeholder="Nazwa użytkownika" aria-describedby="basic-addon1">
                    <span class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></span>
                </div>
                <br />
                <div class="input-group">
                    <input type="password" name="password" class="form-control" placeholder="Hasło" aria-describedby="basic-addon2">
                    <span class="input-group-addon" id="basic-addon2"><span class="glyphicon glyphicon-lock" aria-hidden="true"></span></span>
                </div>
                <br />
                <input type="submit" class="btn btn-success" style="width: 100%" value="Zaloguj się" />
                <br />
                <br />

                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
            <a href="./register"><button class="btn btn-danger" style="width: 100%">Załóż konto</button></a>
            <c:if test="${error ne null}">
                <div class="alert alert-danger">${error}</div>
            </c:if>
        </div>
    </div>
</div>
<div class="col-md-4">
</div>