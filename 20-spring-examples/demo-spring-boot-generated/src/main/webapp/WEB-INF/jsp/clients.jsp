<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
<body>
<h1>CLIENTS</h1>
<ul>
    <c:forEach items="${clients}" var="client">
        <li>
            <p>${client.id} ${client.firstName} ${client.lastName}</p>
        </li>
    </c:forEach>
</ul>

</body>
</html>