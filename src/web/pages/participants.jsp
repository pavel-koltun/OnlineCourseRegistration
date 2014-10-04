<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Participant list</title>
    <link rel="stylesheet" href="/css/registration.css"/>
</head>
<body>
<div id="welcome">
    <h2>Participant list</h2>
    <hr/>
    <c:if test="${empty participants}">
        <h3>No participants found</h3>
    </c:if>
    <c:if test="${not empty participants}">
        <table class="participants">
            <thead>
            <tr>
                <th>Id</th>
                <th>FirstName</th>
                <th>LastName</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Confirmed</th>
                <th>Delete</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${participants}" var="participant">
                <tr>
                    <td>${participant.id}</td>
                    <td>${participant.firstName}</td>
                    <td>${participant.lastName}</td>
                    <td>${participant.phone}</td>
                    <td>${participant.email} </td>
                    <td>${participant.confirmed}
                        <form method="post">
                            <input type="hidden" name="confirm" value="${participant.id}">
                            <input type="submit" value="Change">
                        </form>
                    </td>
                    <td>
                        <form class="delete-form" method="post">
                            <input type="hidden" name="delete" value="${participant.id}">
                            <input type="submit" value="Delete">
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
</body>
</html>
