<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<br />
<br />
<div class="row">

    <div class="col-md-1 col-xs-1 col-sm-1">
    </div>

    <div class="col-md-10 col-xs-10 col-sm-10">

        <div class="well">

            <table class="table text-center block-center table-vcenter" id="user2">
                <colgroup>
                    <col style="width: 30%">
                    <col style="width: 40%">
                    <col style="width: 30%">
                </colgroup>
                <tr>
                    <td>
                        <h3>${user.name}</h3>
                    </td>
                    <td colspan="2">
                        <h4>Dane użytkownika</h4>
                    </td>
                </tr>
                <tr>
                    <td rowspan="6">
                        <img src="${appContextPath}/resources/upload/${user.imageName}" class="img img-circle" style="width: 200px; height: 200px" />
                    </td>
                    <td>Rola</td>
                    <td>admin<br></td>
                </tr>
                <tr>
                    <td>Ilość komentarzy</td>
                    <td>${user.comments.size()}</td>
                </tr>
                <tr>
                    <td>Data rejestracji</td>
                    <td>${user.dateOfRegister}</td>
                </tr>

                <!-- DLA WŁAŚCICIELA KONTA -->
                <c:if test="${loggedUserName == user.name}">
                    <tr>
                        <td colspan="2">
                            <h4>Opcje</h4>
                        </td>
                    </tr>
                    <tr>
                        <td>Zmień hasło</td>
                        <td>
                            <a href="${user.id}/changepassword"><button class="btn btn-success pull-right">Zmień</button></a>
                        </td>
                    </tr>
                    <tr>
                        <td>Zmień awatar</td>
                        <td>
                            <a href="${user.id}/delete"><button class="btn btn-success pull-right">Zmień</button></a>
                        </td>
                    </tr>
                </c:if>

            </table>

        </div>

    </div>

    <div class="col-md-1 col-xs-1 col-sm-1">
    </div>

</div>


