<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Employee Details and Leave Information</title>
</head>
<body>

<c:forEach items="${empDetails}" var="employee">
    <c:forEach items="${employee}" var="detail">
        <c:out value="${detail}"/><br>
    </c:forEach>
    <br>
</c:forEach>

</body>
</html>
