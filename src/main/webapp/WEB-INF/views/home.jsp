<jsp:useBean id="tsveta" class="ru.rostelecom.model.Tsveta"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" type="text/css" media="all" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" media="all" href="<c:url value="/css/style.css"/>"/>
</head>
<body>
<div>
    <a href="home">
        <img class="img-fluid" src="<c:url value="/images/logo.jpg"/>" alt="logo" title="University logo"/>
    </a>
</div>
<br>
<div class="table">
    <h2>Colors:</h2>
    <table class="table table-hover table-sm">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Color number</th>
            <th scope="col">name</th>
        </tr>
        </thead>

        <c:forEach var="tsveta" items="${allColors}">
        <tr onmouseover = "this.style.backgroundColor='${tsveta.name}';" onmouseout = "this.style.backgroundColor=defaultStatus;">
            <th scope="row">${tsveta.id}</th>
            <td>${tsveta.colorNumber}</td>
            <td>${tsveta.name}</td>
        </tr>
        </c:forEach>
    </table>
</div>
<br>

<div>
    &copy; 2019 Vladimir Zhdanov.
</div>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>