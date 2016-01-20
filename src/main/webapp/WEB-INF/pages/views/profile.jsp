<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />" type="text/css"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap-theme.min.css" />" type="text/css"/>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="http://getbootstrap.com/examples/jumbotron/#">Project name</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <form class="navbar-form navbar-right">
                <div class="form-group">
                    <input type="text" placeholder="Email" class="form-control">
                </div>
                <div class="form-group">
                    <input type="password" placeholder="Password" class="form-control">
                </div>
                <button type="submit" class="btn btn-success">Sign in</button>
            </form>
        </div><!--/.navbar-collapse -->
    </div>
</nav>

<!-- Main jumbotron for a primary marketing message or call to action -->
<br/><br/>
<h2>${profile.surname}</h2>
<h3>${profile.name}</h3>
<p>Стать: ${profile.sex}</p>
<br/><br/>
<h3>INFORMATION</h3>
<p><b>About me: </b> ${userData.shortInformation}</p>
<p><b>My favorite books: </b> ${userData.books}</p>
<p><b>My favorite music: </b> ${userData.music}</p>
<p><b>My films: </b> ${userData.films}</p>
<%--<p>Коротка інформація: ${data.shortInformation}</p>--%>

    <footer>
        <p>© 2015 Company, Inc.</p>
    </footer>
</div> <!-- /container -->

<script src="/resources/javascript/jquery-2.1.4.min.js"></script>
<script src="/resources/javascript/bootstrap.min.js"></script>
</body>
</html>