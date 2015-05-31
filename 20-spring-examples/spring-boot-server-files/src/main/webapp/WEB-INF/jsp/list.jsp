<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
<body>
<ul>
    test
    <%--@elvariable id="files" type="java.util.List"--%>
    <c:forEach items="${files}" var="file">
        <li>
            <a href="<spring:url value="/zip/${file}" />">${file}</a>
        </li>
    </c:forEach>
</ul>

</body>
</html>