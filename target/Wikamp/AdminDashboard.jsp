<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/adminDashBoard.css">
</head>

<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <ul class="navbar-nav">
        <li class="nav-item active">
            <a class="nav-link">Wikamp</a>
        </li>
        <li class="nav-item active">
            <a class="nav-link"><%= "Today is: " + (new java.util.Date().toString()) %></a>
        </li>
    </ul>
</nav>
<div class=".container-fluid">
    <div class="row">
        <div class="m-5 col">
            <h3>Column 1</h3>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit...</p>
            <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris...</p>
        </div>
        <div class="m-5 col-7">
            <div id="menuToggle">
                <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <button class="m-1 btn btn-success" id="tableButton">Table</button>
                        </li>
                        <li class="nav-item">
                            <button class="m-1 btn btn-success" id="chartButton">Chart</button>
                        </li>
                    </ul>
                </nav>
                <div id="navTogglePanel">
                    <table class="m-0 table table-dark">
                        <thead>
                        <tr>
                            <th>Faculty</th>
                            <th>Number of Students</th>
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
                </div>
            </div>
            <div id="piechart" style="width: 100%; height: 500px;"></div>
        </div>
        <div class="m-5 col">
            <h3>Column 3</h3>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit...</p>
            <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris...</p>
        </div>
    </div>
</div>
</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script src="javascript/FacultyPieChart.js"></script>
<script src="javascript/toggleMenuTable.js"></script>
<script src="javascript/toggleMenuChart.js"></script>
</html>