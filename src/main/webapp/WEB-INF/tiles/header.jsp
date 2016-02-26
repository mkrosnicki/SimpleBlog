<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
    <div class="row">
        <div class="col-md-8 col-sm-8 col-xs-8">
            <img src="<c:url value="/resources/img/logo_500.png" />" />
        </div>
        <c:choose>
            <c:when test="${isUserLogged}">
                <div class="col-md-3 col-sm-3 col-xs-3" style="padding-top: 5em; text-align: right">
                    <h5>Witaj, <a href="#">maku</a>!</h5>
                </div>
                <div class="col-md-1 col-sm-1 col-xs-1" style="padding-top: 5em">
                    <div class="pull-right form-group form-inline">
                        <button class="btn btn-danger pull-right">Wyloguj</button>
                    </div>
                </div>
            </c:when>
            <c:otherwise>
                <div class="col-md-4 col-sm-4 col-xs-4" style="padding-top: 5em">
                    <a href="<c:url value="/register" />"><button class="btn btn-danger pull-right">Zarejestruj się</button></a>
                    <a href="<c:url value="/login" />"><button class="btn btn-success pull-right">Zaloguj się</button></a>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
</div>


