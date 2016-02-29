<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<br />
<br />
<div class="row">

    <div class="col-md-1 col-xs-1 col-sm-1">
    </div>

    <div class="col-md-10 col-xs-10 col-sm-10">

        <div class="well">

            <table class="table text-center block-center table-vcenter" id="user2">

                <tr>
                    <td colspan="5">
                        <h3>Posty</h3>
                    </td>
                </tr>
                <tr>
                    <td>
                        <h4>Tytuł</h4>
                    </td>
                    <td>
                        <h4>Ostatnia edycja</h4>
                    </td>
                    <td>
                        <h4>Treść / tytuł</h4>
                    </td>
                    <td>
                        <h4>Obrazek</h4>
                    </td>
                    <td>
                        <h4>Usuń</h4>
                    </td>
                </tr>
                <c:forEach items="${posts}" var="post">
                    <tr>
                        <td>${post.title}</td>
                        <td>${post.dateOfPublish}</td>
                        <td>
                            <a href="edit/post/${post.id}"><button class="btn btn-success">Edytuj</button></a>
                        </td>
                        <td>
                            <a href="edit/postimage/${post.id}"><button class="btn btn-success">Zmień</button></a>
                        </td>
                        <td>
                            <a href="delete/post/${post.id}"><button class="btn btn-danger">Usuń</button></a>
                        </td>
                    </tr>

                </c:forEach>

            </table>

        </div>

    </div>

    <div class="col-md-1 col-xs-1 col-sm-1">
    </div>

</div>
