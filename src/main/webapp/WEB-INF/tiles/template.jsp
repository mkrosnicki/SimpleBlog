<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if IE 9 ]><html class="ie ie9" lang="en"> <![endif]-->
<html lang="en">
    <!--<![endif]-->

    <head>
        <meta charset="utf-8">

        <title><tiles:getAsString name="title" /></title>

        <script src="<c:url value="/resources/js/jquery.js" />" ></script>
        <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>

        <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

        <link href="<c:url value="/resources/css/fileinput.min.css"/>" media="all" rel="stylesheet" type="text/css" />
        <script src="<c:url value="/resources/js/plugins/canvas-to-blob.min.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/fileinput.min.js" />"></script>
        <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
        <script src="<c:url value="/resources/js/fileinput_locale_pl.js" />"></script>

        <link href="<c:url value="/resources/css/blog.css" />" rel="stylesheet">


        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->


    </head>

    <body>

        <!-- NAGŁÓWEK -->


        <tiles:insertAttribute name="header" />


        <!-- MENU -->

        <tiles:insertAttribute name="menu" />


        <!-- TREŚĆ -->


        <div id="content" style="min-height: 700px;">
            <div class="container">


                <tiles:insertAttribute name="content" />


            </div>
        </div>


        <!-- MENU DOLNE -->

        <tiles:insertAttribute name="lower_menu" />

        <!-- STOPKA -->

        <tiles:insertAttribute name="footer" />


        <script>
            function formSubmit() {
                document.getElementById("logoutForm").submit();
            }
        </script>
        <script>
            $("#addCommentButton").click(function () {
                $("#addcommentform").toggle(50);
            }
            );
        </script>
        <script>
            $(document).on('ready', function () {
                $("#input-form").fileinput({
                    showUpload: false,
                    maxFileCount: 10,
                    mainClass: "input-group-lg"
                });
            });
        </script>


    </body>
</html>