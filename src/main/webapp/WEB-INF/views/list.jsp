<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SpringCrud :: Lista osób</title>
    </head>
    <body>
        <a href="./">Powrót do strony głównej</a><br />
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Imię</th>
                    <th>Nick</th>
                    <th>Hasło</th>
                    <th>Środki</th>
                    <th>Edytuj</th>
                    <th>Usuń</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${persons}" var="person">
                    <tr>
                        <td>${person.id}</td>
                        <td>${person.name}</td>
                        <td>${person.password}</td>
                        <td>${person.nickName}</td>
                        <td>${person.balance}</td>
                        <td><a href="<c:url value="/editperson/${person.id}" />">:: Edytuj ::</a></td>
                        <td><a href="<c:url value="/deleteperson/${person.id}" />">:: Usuń ::</a></td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>
        <br />
        <hr />
        Uwaga! W kontekście użycia HTML oraz sposobu budowania stron, te rozwiązania są bardziej antyprzykładem niż materiałem do nauki!<br />
        Jeśli chciałabyś także tworzyć same widoki i pisac poprawny, dobrze skonstruowany kod HTML, zachęcamy do zapoznania się np. z frameworkiem <a href="http://getbootstrap.com" target="_blank">Bootstrap</a>.
    </body>
</html>