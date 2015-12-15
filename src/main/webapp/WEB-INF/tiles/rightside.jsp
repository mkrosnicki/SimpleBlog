<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="well">
    <h4>Panel logowania</h4>
    <form action="${pageContext.request.contextPath}/logout" method="post" id="logoutForm">
        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}" />
    </form>
    <c:choose>
        <c:when test="${pageContext.request.userPrincipal.name != null}">
            Jesteś zalogowany jako : <b>${pageContext.request.userPrincipal.name}</b>
            &nbsp;|&nbsp;
            <a href="javascript:formSubmit()" >Wyloguj</a>
            <br />
            <c:if test="${isAdminLogged}">
                <br />
                <a href="${pageContext.request.contextPath}/admin">Panel admina</a>
            </c:if>
        </c:when>
        <c:otherwise>
            Nie jesteś zalogowany
            &nbsp;|&nbsp;
            <a href="<c:url value="/login" />">Zaloguj</a>
            &nbsp;lub&nbsp;
            <a href="<c:url value="/register" />">Zarejestruj sie</a>
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
