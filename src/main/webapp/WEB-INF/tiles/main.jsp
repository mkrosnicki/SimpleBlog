<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<br />
<br />

<!-- CONTENT -->
<div class="col-md-1"></div>

<div class="col-md-10">

    <!-- POST -->

    <c:forEach items="${posts}" var="post">
        <div class="row">
            <div class="well" id="posts">
                <div class="col-md-4">
                    <p class="text-center">
                        <img src="${appContextPath}/resources/upload/${post.imageName}" class="img img-responsive" style="margin: 0 auto; height: 125px">
                    </p>
                </div>
                <div class="col-md-8">
                    <div class="row">
                        <h4>${post.title}</h4>
                    </div>
                    <hr />
                    <div class="row">
                        <span class="label label-danger">Transfery</span>
                        <span class="label label-danger">Zapowiedzi</span>
                        <span class="label label-danger">Inne</span>
                        <a href="<c:url value="/post/${post.id}" />"<button class="btn btn-success pull-right">Przeczytaj więcej</button></a>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>    


    <br />
</div>

<div class="col-md-1"></div>