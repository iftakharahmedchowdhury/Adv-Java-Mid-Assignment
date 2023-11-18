<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Employee Information Input</title>
</head>
<body>
    <h1>Employee Information Input</h1>
    <form action="employees" method="post">
        <c:forEach var="i" begin="0" end="2">
            <h3>Enter Employee Information for Employee ${i + 1}:</h3>
            <label>ID:</label>
            <input type="text" name="id${i}" required><br>

            <label>Name:</label>
            <input type="text" name="name${i}" required><br>

            <label>Date of Birth (yyyy-MM-dd):</label>
            <input type="text" name="dateOfBirth${i}" required><br>

            <label>Email:</label>
            <input type="text" name="email${i}" required><br>

            <label>Joining Date (yyyy-MM-dd):</label>
            <input type="text" name="joiningDate${i}" required><br>

            <label>Employee Type (1 for Officer, 2 for Staff):</label>
            <input type="text" name="employeeType${i}" required><br>

            <br><br>
        </c:forEach>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
