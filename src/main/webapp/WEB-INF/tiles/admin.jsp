<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    <td colspan="2">
                        <h4>Opcje</h4>
                    </td>
                </tr>
                <tr>
                    <td>Pokaż użytkowników</td>
                    <td>
                        <a href="${appContextPath}/admin/users"><button class="btn btn-success pull-right">Pokaż</button></a>
                    </td>
                </tr>
                <tr>
                    <td>Pokaż posty</td>
                    <td>
                        <a href="${appContextPath}/admin/posts"><button class="btn btn-success pull-right">Pokaż</button></a>
                    </td>
                </tr>
                <tr>
                    <td>Dodaj posta</td>
                    <td>
                        <a href="${appContextPath}/admin/addpost"><button class="btn btn-success pull-right">Dodaj</button></a>
                    </td>
                </tr>
            </table>

        </div>

    </div>

    <div class="col-md-1 col-xs-1 col-sm-1">
    </div>

</div>