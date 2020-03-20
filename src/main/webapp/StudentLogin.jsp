<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wikamp | Student Login</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <ul class="navbar-nav">
        <li class="nav-item active">
            <a class="nav-link">Wikamp</a>
        </li>
    </ul>
</nav>
<section>
    <div class="wrapper fadeInDown">
        <div class="formContent">
            <div class="fadeIn first">
                <img src="photos/student__graduation__degree__hat__education-512.png" class="icon" alt="User Icon" />
            </div>
            <form action="StudentLogin" method="POST">
                <input type="text" name="indexNo" class="fadeIn fourth" required autofocus></br>
                <input type="password" name="passAcc" class="fadeIn fourth" required></br>
                <input type="submit" class="fadeIn fourth" value="Log In">
            </form>
        </div>
    </div>
</section>
</body>
</html>