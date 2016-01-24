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
<c:import url="header.jsp"/>
<c:import url="sidebar.jsp"/>

<!-- Main jumbotron for a primary marketing message or call to action -->
<br/><br/>
<h2>${profile.surname}</h2>
<h3>${profile.name}</h3>
<p>Стать: ${profile.sex}</p>
<br/>

<c:choose>
    <c:when test="${currentUser.isSubscriber(user)}">
            <p>TTTTTTTTTTTTTTT</p>>
    </c:when>
    <c:otherwise>
        <p>Other</p>
    </c:otherwise>
</c:choose>

<div id="addToFriendDiv">
    <button type="button" id="addToFriend" class="btn btn-default" value="${user.id}">
        Add to my friend
    </button>
</div>
<br/>
<h3>INFORMATION</h3>
<p><b>About me: </b> ${userData.shortInformation}</p>
<p><b>My favorite books: </b> ${userData.books}</p>
<p><b>My favorite music: </b> ${userData.music}</p>
<p><b>My films: </b> ${userData.films}</p>

<p><b>--- : </b> ${user.personRequests}</p>
<%--<p>Коротка інформація: ${data.shortInformation}</p>--%>

    <footer>
        <p>© 2015 Company, Inc.</p>
    </footer>
</div> <!-- /container -->

<script src="/resources/javascript/jquery-2.1.4.min.js"></script>
<script src="/resources/javascript/bootstrap.min.js"></script>

<script>
</script>
<script src="/resources/javascript/friend_invite.js"></script>
</body>
</html>