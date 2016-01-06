<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row">
    <div class="col-md-3">
        <div class="well">
            gdfgdf
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
        </div>
    </div>
</div>


