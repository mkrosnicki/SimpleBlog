<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SpringCrud :: Strona logowania</title>
    </head>
    <body>
        <a href="persons">Przejdz do listy osób</a><br />
        <a href="./">Powrot do strony głównej</a><br />
        <form:form method="POST" modelAttribute="person">
            <table border="1">
                <tbody>
                    <tr>
                        <td>User</td>
                        <td><form:input type="text" path="name" /></td>
                    </tr>
                    <tr>
                        <td>Hasło</td>
                        <td><form:input type="text" path="password" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><form:button id="log" value="Zaloguj" /></td>
                    </tr>
                </tbody>
            </table>
        </form:form>
        <br />
        <hr />
        Uwaga! W kontekście użycia HTML oraz sposobu budowania stron, te rozwiązania są bardziej antyprzykładem niż materiałem do nauki!<br />
        Jeśli chciałabyś także tworzyć same widoki i pisac poprawny, dobrze skonstruowany kod HTML, zachęcamy do zapoznania się np. z frameworkiem <a href="http://getbootstrap.com" target="_blank">Bootstrap</a>.
    </body>
</html>