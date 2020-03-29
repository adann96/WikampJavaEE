<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table>
    <thead>
    <tr>
        <th>Wydział</th>
        <th>Liczba Studentów</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="fac" items="${facultyList}">
        <tr>
            <td>
                <c:out value="${fac.facultyName}" />
            </td>
            <td>
                <c:out value="${fac.studentsNo}" />
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<div id="piechart" style="width: 1200px; height: 500px;"></div>

</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script src="javascript/FacultyPieChart.js"></script>
</html>
