<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<body>

<h2>Create User</h2>

<form action="/users/create" method="post">
    Name: <input name="name"/>
    Age: <input name="age"/>
    <button type="submit">Create</button>
</form>

</body>
</html>