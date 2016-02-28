<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<br />
<br />

<!-- CONTENT -->
<div class="col-md-1"></div>

<div class="col-md-10">

    <!-- USER -->

    <c:forEach items="${users}" var="user">
        <div class="row">
            <div class="well" id="posts">
                <div class="col-md-2">
                    <p class="text-center">
                        <img src="${appContextPath}/resources/upload/${user.imageName}" class="img img-circle" style="margin: 0 auto; height: 125px; width: 125px">
                    </p>
                </div>
                <div class="col-md-10">

                    <div class="row">
                        <h4>${user.name}</h4>
                    </div>
                    <table class="table">
                        <tr>
                            <td>Rola</td>
                            <td>do zrobienia</td>
                            <td></td>
                        </tr>
                        <tr>
                            <td>Data rejestracji</td>
                            <td>narazie brak</td>
                            <td>
                                <button class="btn btn-danger pull-right">Zablokuj</button>
                                <button class="btn btn-success pull-right">Zmień uprawnienia</button>
                            </td>
                        </tr>
                    </table>

                </div>
            </div>
        </div>
    </c:forEach>

    <br />
</div>

<div class="col-md-1"></div>
