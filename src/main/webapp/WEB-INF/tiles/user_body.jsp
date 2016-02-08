<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row">
    <div class="col-md-3">
        <div class="well">
            <center>
                <img class="img-responsive img-circle" src="${appContextPath}/resources/upload/${user.imageName}" style="width: 100px; height: 100px"/>
                <c:if test="${loggedUserName == user.name}">
                    <br />
                    <a href="${appContextPath}/user/${user.id}/deleteAvatar"/>Usuń awatar</a>
                    <br />
                    <a href="${appContextPath}/user/${user.id}/updateAvatar"/>Zmień awatar</a>
                </c:if>
                <c:if test="${error ne null}">
                    <div class="alert alert-danger">${error}</div>
                </c:if>
                <c:if test="${message ne null}">
                    <div class="alert alert-success">${message}</div>
                </c:if>
            </center>
        </div>
    </div>
    <div class="col-md-9">
        <div class="well">
            Nazwa użytkownika : <b>${user.name}</b>
            <br />
            Uprawnienia : <b>${userRole}</b>
            <br />
            Status konta : <b>${status}</b>
            <br />
            Liczba postów : <b>${numberOfPosts}</b>
            <br />
            Liczba komentarzy : <b>${numberOfComments}</b>
            <br />
        </div>
    </div>
</div>


