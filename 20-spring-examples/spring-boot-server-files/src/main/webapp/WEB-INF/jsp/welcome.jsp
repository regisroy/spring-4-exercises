<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="fr">
<head>
    <meta charset="ISO-8859-1">
    <style>
        html {
            font-family: sans-serif;
            color: #232323;
        }

        .nom {
            font-weight: bold;
        }

        .email {
            font-weight: bold;
        }
        h1 {
            text-align: center;
            font-size: larger;
        }
        h2 {
            text-align: left;
            font-size: medium;
        }
    </style>
</head>
<body>
<c:url value="/resources/text.txt" var="url"/>
<spring:url value="/resources/text.txt" htmlEscape="true" var="springUrl"/>
<h1> ${titre}</h1>
<hr/>
<h2>${message}</h2>

<p>Mon nom est : <span class="nom">${nom}</span></p>

<p>Je suis de : ${societe}</p>

<p>Mon adresse email est <span class="email">${email}</span></p>

<spring:url value="list" var="listUrl"/>
<a href="${listUrl}">Liste des fichiers téléchargeables</a>
</body>

</html>
