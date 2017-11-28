<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <spring:form modelAttribute="userDataFromServer" method="post" action="/user-system/users/saveuserdata">
        firstname: <spring:input path="firstName"/> </br>
        secondname: <spring:input path="secondName"/> </br>
        email: <spring:input path="email"/> </br>
        login: <spring:input path="login"/> </br>
        password: <spring:input path="password"/> </br>
        <spring:button>save user data</spring:button>
    </spring:form>
</body>
</html>