<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<html>
<body>

<h2>Users</h2>

<form action="/users/create" method="post">
    Name: <input name="name"/>
    Age: <input name="age"/>
    <button type="submit">Create</button>
</form>

<hr/>

<table border="1">
    <tr>
        <th>Name</th>
        <th>Age</th>
        <th>Action</th>
    </tr>

    <c:forEach var="u" items="${users}">
        <tr>
            <td>${u.name}</td>
            <td>${u.age}</td>
            <td>
                <a href="/users/delete?key=${u.key}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>