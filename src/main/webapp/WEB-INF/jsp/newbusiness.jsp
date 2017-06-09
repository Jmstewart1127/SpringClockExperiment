<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Getting Started: Handling Form Submission</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
	<font color="red">${errorMessage}</font>
    <form action="#" th:action="@{/newbusiness}" th:object="${business}" method="post">
    	<p>Admin Name: <input type="text" th:field="*{adminName}" /></p>
    	<p>Business Name <input type="text" th:field="*{bizName}" /></p>
        <p>Password: <input type="password" th:field="*{password}" /></p>
        <p><input type="submit" value="Submit" /> <input type="reset" value="Reset" /></p>
    </form>
</body>
</html>