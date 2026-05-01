<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<body>

<h2>Edit User</h2>

<form action="/users/update" method="post">
    <input type="hidden" name="key" value="${user.key}"/>

    Name: <input name="name" value="${user.name}"/>
    Age: <input name="age" value="${user.age}"/>

    <button type="submit">Update</button>
</form>

</body>
</html>