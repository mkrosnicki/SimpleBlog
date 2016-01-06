<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="well">
    <h4>Panel logowania</h4>
    <br />
    <c:if test="${isUserLogged}">

    </c:if>
    <c:choose>
        <c:when test="${isUserLogged}">

            <form action="${appContextPath}/logout" method="post" id="logoutForm">
                <input type="hidden"
                       name="${_csrf.parameterName}"
                       value="${_csrf.token}" />
            </form>

            Jesteś zalogowany jako : <b><a href="${appContextPath}/user/${loggedUserId}">${loggedUserName}</a></b>
            &nbsp;|&nbsp;
            <a href="javascript:formSubmit()" >Wyloguj</a>

        </c:when>
        <c:otherwise>
            <c:url value="/j_spring_security_check" var="loginUrl" />
            <form class="form-horizontal" action="${loginUrl}" method="POST">
                <input type="text" name="username" class="form-control" placeholder="Nazwa użytkownika">
                <input type="password" name="password" class="form-control" id="password" placeholder="Twoje hasło">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <span class="input-group-btn">
                    <input type="submit" class="btn btn-default" value="Zaloguj" >
                </span>
            </form>
            <br />
            <c:if test="${error ne null}">
                <div class="alert alert-danger">${error}</div>
            </c:if>
            <center>Nie masz konta? <a href="<c:url value="/register" />">Zarejestruj się!</a></center>
            </c:otherwise>            
        </c:choose>



    <!--     /.input-group -->
</div>

<!-- Blog Search Well -->
<div class="well">
    <h4>Wyszukiwarka</h4>
    <div class="input-group">
        <input type="text" class="form-control">
        <span class="input-group-btn">
            <button class="btn btn-default" type="button">
                <span class="glyphicon glyphicon-search"></span>
            </button>
        </span>
    </div>
    <!-- /.input-group -->
</div>

<!-- Blog Categories Well -->
<div class="well">
    <h4>Blog Categories</h4>
    <div class="row">
        <div class="col-lg-6">
            <ul class="list-unstyled">
                <li><a href="#">Category Name</a>
                </li>
                <li><a href="#">Category Name</a>
                </li>
                <li><a href="#">Category Name</a>
                </li>
                <li><a href="#">Category Name</a>
                </li>
            </ul>
        </div>
        <!-- /.col-lg-6 -->
        <div class="col-lg-6">
            <ul class="list-unstyled">
                <li><a href="#">Category Name</a>
                </li>
                <li><a href="#">Category Name</a>
                </li>
                <li><a href="#">Category Name</a>
                </li>
                <li><a href="#">Category Name</a>
                </li>
            </ul>
        </div>
        <!-- /.col-lg-6 -->
    </div>
    <!-- /.row -->
</div>

<!-- Side Widget Well -->
<div class="well">
    <h4>Informacje o autorze</h4>
    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore, perspiciatis adipisci accusamus laudantium odit aliquam repellat tempore quos aspernatur vero.</p>
</div>
