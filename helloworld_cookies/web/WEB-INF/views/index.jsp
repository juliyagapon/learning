<!--take a look on spring tags-->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
  <title>Index Page</title>
</head>

<body>
<spring:form method="post"  modelAttribute="userJSP" action="check-user">

  Name: <spring:input path="name" value="${cookie.userName.value}"/>  <br/>
  Password: <spring:password path="password" value="${cookie.userPassword.value}"/>   <br/>
  <spring:button>Login</spring:button>
</spring:form>

<spring:form method="post" modelAttribute="userJSP" action="logout">
    <spring:button>Logout</spring:button>
</spring:form>

</body>

</html>