<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
<body>
<h1>LISTE</h1>
<ul>
    <%--@elvariable id="files" type="java.util.List"--%>
    <c:forEach items="${items}" var="item">
        <li>
            <a href="<spring:url value="${item}" />">${item}</a>
        </li>
    </c:forEach>
</ul>

</body>
</html>