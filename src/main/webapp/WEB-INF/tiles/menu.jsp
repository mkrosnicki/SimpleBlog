<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>


<div id="menu" style="background-color: #5cb85c">
    <nav class="navbar navbar-default" style="margin: 0px; margin-top: 10px;">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" style="padding: 0px">
                <ul class="nav navbar-nav">
                    <li><a href="">Strona główna</a></li>
                    <li><a href="<c:url value="/users" />">Użytkownicy</a></li>
                    <li><a href="<c:url value="/contact" />">Kontakt</a></li>
                    <c:if test="${isUserLogged}">
                        <li><a href="#">Twoje konto</a></li>
                    </c:if>
                    <c:if test="${isAdminLogged}">
                        <li><a href="#">Panel admina</a></li>
                    </c:if>
                </ul>
                <form class="navbar-form navbar-left pull-right" style="padding: 0px" role="search" action="<c:url value="/search"/>">
                    <div class="form-group">
                        <input type="text" name="q" class="form-control" placeholder="Szukaj...">
                    </div>
                    <button type="submit" class="btn btn-default">Szukaj</button>
                </form>
            </div>
        </div>
    </nav>
</div>