<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title><tiles:getAsString name="title" /></title>
>
        <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

    </head>

    <body>

        <tiles:insertAttribute name="menu" /> 

        
        <div class="container">
            <div class="row">
                <div class="col-md-8">
                    <tiles:insertAttribute name="header" />
                    <tiles:insertAttribute name="body" />
                </div>

                <div class="col-md-4">
                    <tiles:insertAttribute name="rightside" />
                </div>
            </div>

            <hr>

            <!-- Footer -->
            <footer>
                <div class="row">
                    <div class="col-lg-12">
                        <p>Copyright &copy; Your Website 2014</p>
                    </div>
                </div>
            </footer>

        </div>

        <script src="<c:url value="/resources/js/jquery.js" />" ></script>
        <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>

        <script>
            function formSubmit() {
                document.getElementById("logoutForm").submit();
            }

            $("#addCommentButton").click(function () {
                $("#addCommentForm").toggle(500);
            }
            );
        </script>

    </body>

</html>

